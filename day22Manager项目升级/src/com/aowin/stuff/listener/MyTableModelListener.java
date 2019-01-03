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
		// �õ����ݿ��е���������
		oldDm = new DefaultTableModel(UtilsDemo.getAllData(personDao.getAll()),
				new String[] { "���", "����", "�Ա�", "����", "����" });
	}
	
	private static int row ;
	private static int col ;
	@Override
	public void tableChanged(TableModelEvent e) {
		row = e.getLastRow();
		col = e.getColumn();
		//System.out.println(row + "  " + col);
		// �ų� ���� �� Ա������Ͳ��Ź��� �� ����Ĳ���
		if (col != -1) {
			String oldData = (String) oldDm.getValueAt(row, col);
			String change = (String) pView.getDm().getValueAt(row, col);
			// �õ��޸�ǰ��id
			int oidId = Integer.valueOf((String) oldDm.getValueAt(row, 0));
			// System.out.println("�У�" + row + " �У�" + col);

			// �õ��޸ĺ������
			String colName = pView.getDm().getColumnName(col);

			String sql = "update person set ";
			int newId = 0;
//			 System.out.println(
//			 "�У�" + row + " �У�" + col + " �޸ĵ�������" + colName + " �޸ĺ�ĵ�Ԫֵ��" + change +
//			 "�޸�ǰ�ĵ�Ԫֵ��" + oldData);
			if (colName.equals("���")) {
				sql = sql + " id = " + change;
				newId = Integer.valueOf(change);
			} else if (colName.equals("����")) {
				sql = sql + " name = '" + change + "' ";
			} else if (colName.equals("�Ա�")) {
				if (change.equals("��"))
					sql = sql + " sex = " + 1;
				if (change.equals("Ů"))
					sql = sql + " sex = " + 0;
			} else if (colName.equals("����")) {
				sql = sql + " department = '" + change + "' ";
			} else if (colName.equals("����")) {
				sql = sql + " salary = " + change;
			}
			sql = sql + " where id = " + oidId;
			boolean flag = true;
			try {
				personDao.updateBySQL(sql, newId);
			} catch (IdIsExistException e1) {
				pView.getDm().setValueAt(oldData, row, col);
				JOptionPane.showMessageDialog(null, "id=" + e1.getId() + "�Ѵ��ڣ�");
				flag = false;
			}
			if (flag && !change.equals(oldData)) {
				JOptionPane.showMessageDialog(null, "�����޸ĳɹ�����ͬ�������ݿ��У�");
			}

		}

	}

}
