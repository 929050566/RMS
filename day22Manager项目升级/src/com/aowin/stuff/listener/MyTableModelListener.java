package com.aowin.stuff.listener;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.aowin.stuff.dbconnection.PersonDao;
import com.aowin.stuff.exception.IdIsExistException;
import com.aowin.stuff.utils.UtilsDemo;
import com.aowin.stuff.view.PrimeView;

public class MyTableModelListener implements TableModelListener {

	private PrimeView pView;
	private DefaultTableModel oldDm;
	private PersonDao personDao;

	public MyTableModelListener(PrimeView pView) {
		super();
		this.pView = pView;
		personDao = new PersonDao();
		// 得到数据库中的所有数据
		oldDm = new DefaultTableModel(UtilsDemo.getAllData(personDao.getAll()),
				new String[] { "编号", "名字", "性别", "部门", "工资" });
	}
	
	private static int row ;
	private static int col ;
	@Override
	public void tableChanged(TableModelEvent e) {
		row = e.getLastRow();
		col = e.getColumn();
		//System.out.println(row + "  " + col);
		// 排除 更新 和 员工管理和部门管理 和 排序的操作
		if (col != -1) {
			String oldData = (String) oldDm.getValueAt(row, col);
			String change = (String) pView.getDm().getValueAt(row, col);
			// 得到修改前的id
			int oidId = Integer.valueOf((String) oldDm.getValueAt(row, 0));
			// System.out.println("行：" + row + " 列：" + col);

			// 得到修改后的数据
			String colName = pView.getDm().getColumnName(col);

			String sql = "update person set ";
			int newId = 0;
//			 System.out.println(
//			 "行：" + row + " 列：" + col + " 修改的列名：" + colName + " 修改后的单元值：" + change +
//			 "修改前的单元值：" + oldData);
			if (colName.equals("编号")) {
				sql = sql + " id = " + change;
				newId = Integer.valueOf(change);
			} else if (colName.equals("名字")) {
				sql = sql + " name = '" + change + "' ";
			} else if (colName.equals("性别")) {
				if (change.equals("男"))
					sql = sql + " sex = " + 1;
				if (change.equals("女"))
					sql = sql + " sex = " + 0;
			} else if (colName.equals("部门")) {
				sql = sql + " department = '" + change + "' ";
			} else if (colName.equals("工资")) {
				sql = sql + " salary = " + change;
			}
			sql = sql + " where id = " + oidId;
			boolean flag = true;
			try {
				personDao.updateBySQL(sql, newId);
			} catch (IdIsExistException e1) {
				pView.getDm().setValueAt(oldData, row, col);
				JOptionPane.showMessageDialog(null, "id=" + e1.getId() + "已存在！");
				flag = false;
			}
			if (flag && !change.equals(oldData)) {
				JOptionPane.showMessageDialog(null, "您的修改成功并已同步到数据库中！");
			}

		}

	}

}
