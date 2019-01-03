package com.aowin.stuff.listener;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.aowin.stuff.dbconnection.PersonDao;
import com.aowin.stuff.dbconnection.UserDao;
import com.aowin.stuff.model.Person;
import com.aowin.stuff.utils.UtilsDemo;
import com.aowin.stuff.view.PrimeView;

public class MyMouseListener extends MouseAdapter {

	private PrimeView pView;
	private boolean flag;
	private PersonDao personDap;
	
	public MyMouseListener(PrimeView pView) {
		super();
		this.pView = pView;
		flag = true;
		personDap = new PersonDao();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// 点击次数
		int count = e.getClickCount();
		// 获得鼠标点击的按钮 左键是1 滚轮是2 右键是3
		int x = e.getButton();
		if (count == 2 && x == 3) {
			Point point = e.getPoint();
			JTable tal = pView.getTable();
			// 得到列数
			count = tal.columnAtPoint(point);
			// 获得排序的条件
			String condition = tal.getColumnName(count);
			DefaultTableModel dm = pView.getDm();
			List<Person> list = personDap.getAll();
//			for (int i = 0; i < dm.getRowCount(); i++) {
//				Person person = new Person();
//				person.setId(Integer.valueOf((String) dm.getValueAt(i, 0)));
//				person.setName((String) dm.getValueAt(i, 1));
//				if (((String) dm.getValueAt(i, 2)).equals("男")) {
//					person.setSex(1);
//				} else if (((String) dm.getValueAt(i, 2)).equals("女")) {
//					person.setSex(2);
//				}
//				person.setDepartment((String) dm.getValueAt(i, 3));
//				person.setSalary(Integer.valueOf((String) dm.getValueAt(i, 4)));
//				list.add(person);
//			}
			Collections.sort(list, new MyCompareByCondition(condition, flag));
			flag = !flag;
			// 更新
			pView.getDm().setRowCount(0);
			int depOrEmp = pView.getDepOrEmpOrTalk();
			MyTableModelListener modelListener = new MyTableModelListener(pView);
			if(depOrEmp == pView.dep) {
				pView.setDm(
						new DefaultTableModel(UtilsDemo.getAllData(list), new String[] { "编号", "名字", "性别", "部门"}));
			}else if(depOrEmp == pView.emp) {
				pView.setDm(
						new DefaultTableModel(UtilsDemo.getAllData(list), new String[] { "编号", "名字", "性别", "部门","工资"}));
			}
			//重新注册驱动
			pView.getDm().addTableModelListener(modelListener);
			pView.getTable().setModel(pView.getDm());
		}

	}

}

class MyCompareByCondition implements Comparator<Person> {

	private String condition;
	private boolean flag;

	public MyCompareByCondition(String condition, boolean flag) {
		super();
		this.condition = condition;
		this.flag = flag;
	}

	@Override
	public int compare(Person o1, Person o2) {
		if (flag) {
			if (condition.equals("编号")) {
				return o1.getId() - o2.getId();
			} else if (condition.equals("名字")) {
				return o1.getName().compareTo(o2.getName());
			} else if (condition.equals("性别")) {
				return o1.getSex() - o2.getSex();
			} else if (condition.equals("部门")) {
				return o1.getDepartment().compareTo(o2.getDepartment());
			} else if (condition.equals("工资")) {
				return o1.getSalary() - o2.getSalary();
			}
		} else {
			if (condition.equals("编号")) {
				return o2.getId() - o1.getId();
			} else if (condition.equals("名字")) {
				return o2.getName().compareTo(o1.getName());
			} else if (condition.equals("性别")) {
				return o2.getSex() - o1.getSex();
			} else if (condition.equals("部门")) {
				return o2.getDepartment().compareTo(o1.getDepartment());
			} else if (condition.equals("工资")) {
				return o2.getSalary() - o1.getSalary();
			}
		}
		return 0;
	}

}