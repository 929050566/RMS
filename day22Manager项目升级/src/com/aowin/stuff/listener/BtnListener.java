package com.aowin.stuff.listener;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.dom4j.DocumentException;

import com.aowin.stuff.dbconnection.PersonDao;
import com.aowin.stuff.exception.AddMoreException;
import com.aowin.stuff.server.Server;
import com.aowin.stuff.utils.UtilsDemo;
import com.aowin.stuff.view.ClientView;
import com.aowin.stuff.view.ItmView;
import com.aowin.stuff.view.PrimeView;

public class BtnListener implements ActionListener {

	private PrimeView pView;
	private PersonDao personDao;
	private MyTableModelListener modelListener;
	private ClientView cView = null;

	public BtnListener(PrimeView pView) {
		this.pView = pView;
		personDao = new PersonDao();
		modelListener = pView.getModelListener();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("部门管理")) {
			if(pView.getPermission() == PrimeView.managerPermission) {
				closeOrOpen_BtnAndItm(true);
			}
			//切换卡片
			CardLayout card = (CardLayout) pView.getJpScolOrClient().getLayout();
			card.first(pView.getJpScolOrClient());
		
			pView.getContentPane().revalidate();
			//pView.getContentPane().remove(cView.getJp());
			pView.setDepOrEmpOrTalk(pView.dep);
			// 将工资那一列去掉
			pView.getDm().setRowCount(0);
			pView.setDm(new DefaultTableModel(UtilsDemo.getAllData(personDao.getAll()),
					new String[] { "编号", "名字", "性别", "部门" }));
			pView.getDm().addTableModelListener(modelListener);
			pView.getTable().setModel(pView.getDm());
		} else if (e.getActionCommand().equals("员工管理")) {
			if(pView.getPermission() == PrimeView.managerPermission) {
				closeOrOpen_BtnAndItm(true);
			}
			//切换卡片
			CardLayout card = (CardLayout) pView.getJpScolOrClient().getLayout();
			card.first(pView.getJpScolOrClient());
			
			pView.getContentPane().revalidate();
			pView.setDepOrEmpOrTalk(pView.emp);
			pView.getDm().setRowCount(0);
			pView.setDm(new DefaultTableModel(UtilsDemo.getAllData(personDao.getAll()),
					new String[] { "编号", "名字", "性别", "部门", "工资" }));
			pView.getDm().addTableModelListener(modelListener);
			pView.getTable().setModel(pView.getDm());
		} else if (e.getActionCommand().equals("问题讨论")) {
			pView.setDepOrEmpOrTalk(pView.talk);
			closeOrOpen_BtnAndItm(false);
			CardLayout card = (CardLayout) pView.getJpScolOrClient().getLayout();
			card.last( pView.getJpScolOrClient());
		}
		
		
		// 如果权限为manager
		if (pView.getPermission() == pView.managerPermission) {
			
			if (pView.getDepOrEmpOrTalk() == pView.dep) {
				managerAndDep(e);
			} else if (pView.getDepOrEmpOrTalk() == pView.emp) {
				managerAndEmp(e);
			}
		// 如果权限为visitor
		} else if (pView.getPermission() == pView.visitorPermission) {
			if (pView.getDepOrEmpOrTalk() == pView.dep) {
				visitorAndEmp(e);
			} else if (pView.getDepOrEmpOrTalk() == pView.emp) {
				visitorAndDep(e);
			}
		}
		// 导入和导出
		inAndOut(e);
		pView.getDm().addTableModelListener(new MyTableModelListener(pView));

	}

	private void closeOrOpen_BtnAndItm(boolean state) {
		pView.getAddBtn().setVisible(state);
		pView.getDeleteBtn().setVisible(state);
		pView.getUpdateBtn().setVisible(state);
		//pView.getRefreshBtn().setVisible(state);
		//pView.getQueryBtn().setVisible(state);
		pView.getAddMenuItem().setEnabled(state);
		pView.getUpdateItem().setEnabled(state);
		//pView.getQueryItem().setEnabled(state);
	}

	private void managerAndEmp(ActionEvent e) {
		if (e.getActionCommand().equals("增加")) {
			ItmView itm = new ItmView("增加", pView);
			pView.setEnabled(false);
		} else if (e.getActionCommand().equals("删除")) {
			boolean flag = true;
			int[] countArr = pView.getTable().getSelectedRows();
			if (countArr.length == 0) {
				JOptionPane.showMessageDialog(null, "请选中您要删除的数据！");
			} else {
				// 得到选中的id和姓名
				for (int index = countArr.length - 1; index >= 0; index--) {
					int count = countArr[index];
					int id = Integer.valueOf((String) pView.getDm().getValueAt(count, 0));
					String name = (String) pView.getDm().getValueAt(count, 1);
					// 删除数据库中和 表中的哪一行数据
					try {
						personDao.delByIdAndName(name, id);
						pView.getDm().removeRow(count);
						// 如果最后一列也被删除
						if (index == 0) {
							flag = false;
						}
						// JOptionPane.showMessageDialog(null, "删除成功！");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "删除失败！");
						return;
					}
				}
				if (!flag) {
					JOptionPane.showMessageDialog(null, "删除成功！");
				}
			}
		} else if (e.getActionCommand().equals("修改")) {

			DefaultTableModel dm = pView.getDm();
			int count = pView.getTable().getSelectedRow();
			if (count == -1)
				JOptionPane.showMessageDialog(null, "请选中您要修改的数据！");
			else {
				ItmView itm = new ItmView("修改", pView);
				itm.getIdField().setText((String) dm.getValueAt(count, 0));
				itm.getNameField().setText((String) dm.getValueAt(count, 1));
				itm.getSexBox().setSelectedItem(dm.getValueAt(count, 2));
				itm.getDeptBox().setSelectedItem(dm.getValueAt(count, 3));
				itm.getSalField().setText((String) dm.getValueAt(count, 4));
				// 设置选中的id值
				itm.setOldId(Integer.valueOf((String) dm.getValueAt(count, 0)));
				pView.setEnabled(false);
			}
		} else if (e.getActionCommand().equals("更新")) {
			pView.getDm().setRowCount(0);
			pView.setDm(new DefaultTableModel(UtilsDemo.getAllData(personDao.getAll()),
					new String[] { "编号", "名字", "性别", "部门", "工资" }));
			pView.getDm().addTableModelListener(modelListener);
			pView.getTable().setModel(pView.getDm());
		} else if (e.getActionCommand().equals("查询")) {
			ItmView itm = new ItmView("查询", pView);
			pView.setEnabled(false);
			// 重新设置布局 加一行
			itm.getJf().setLayout(new GridLayout(7, 2, 3, 10));
			// 添加条件选择栏
			JLabel lab = new JLabel("请选择查询条件：");
			lab.setHorizontalAlignment(JLabel.CENTER);
			JComboBox<String> extraBox = new JComboBox<String>();
			extraBox.addItem("and");
			extraBox.addItem("or");
			itm.getJf().add(lab, 10);
			itm.getJf().add(extraBox, 11);
			itm.setExtraBox(extraBox);
		}

	}

	private void managerAndDep(ActionEvent e) {
		if (e.getActionCommand().equals("增加")) {
			ItmView itm = new ItmView("增加", pView);
			itm.getJf().remove(itm.getSalField());
			itm.getJf().remove(itm.getSalLab());
			itm.getJf().setSize(250, 250);

			pView.setEnabled(false);
		} else if (e.getActionCommand().equals("删除")) {
			boolean flag = true;
			int[] countArr = pView.getTable().getSelectedRows();
			if (countArr.length == 0) {
				JOptionPane.showMessageDialog(null, "请选中您要删除的数据！");
			} else {
				// 得到选中的id和姓名
				for (int index = countArr.length - 1; index >= 0; index--) {
					int count = countArr[index];
					int id = Integer.valueOf((String) pView.getDm().getValueAt(count, 0));
					String name = (String) pView.getDm().getValueAt(count, 1);
					// 删除数据库中和 表中的哪一行数据
					try {
						personDao.delByIdAndName(name, id);
						pView.getDm().removeRow(count);
						// 如果最后一列也被删除
						if (index == 0) {
							flag = false;
						}
						// JOptionPane.showMessageDialog(null, "删除成功！");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "删除失败！");
						return;
					}
				}
				if (!flag) {
					JOptionPane.showMessageDialog(null, "删除成功！");
				}
			}
		} else if (e.getActionCommand().equals("修改")) {

			DefaultTableModel dm = pView.getDm();
			int count = pView.getTable().getSelectedRow();
			if (count == -1)
				JOptionPane.showMessageDialog(null, "请选中您要修改的数据！");
			else {
				ItmView itm = new ItmView("修改", pView);

				itm.getIdField().setText((String) dm.getValueAt(count, 0));
				itm.getNameField().setText((String) dm.getValueAt(count, 1));
				itm.getSexBox().setSelectedItem(dm.getValueAt(count, 2));
				itm.getDeptBox().setSelectedItem(dm.getValueAt(count, 3));
				// itm.getSalField().setText((String) dm.getValueAt(count, 4));

				itm.getJf().remove(itm.getSalField());
				itm.getJf().remove(itm.getSalLab());
				// 设置选中的id值
				itm.setOldSal(personDao.getSalById(Integer.valueOf((String) dm.getValueAt(count, 0))));
				itm.setOldId(Integer.valueOf((String) dm.getValueAt(count, 0)));
				pView.setEnabled(false);
			}
		} else if (e.getActionCommand().equals("更新")) {
			pView.getDm().setRowCount(0);
			pView.setDm(new DefaultTableModel(UtilsDemo.getAllData(personDao.getAll()),
					new String[] { "编号", "名字", "性别", "部门" }));
			pView.getDm().addTableModelListener(modelListener);
			pView.getTable().setModel(pView.getDm());
		} else if (e.getActionCommand().equals("查询")) {
			ItmView itm = new ItmView("查询", pView);
			// 删除薪水栏
			itm.getJf().remove(itm.getSalField());
			itm.getJf().remove(itm.getSalLab());

			pView.setEnabled(false);
			// 重新设置布局 加一行
			itm.getJf().setLayout(new GridLayout(7, 2, 3, 10));
			// 添加条件选择栏
			JLabel lab = new JLabel("请选择查询条件：");
			lab.setHorizontalAlignment(JLabel.CENTER);
			JComboBox<String> extraBox = new JComboBox<String>();
			extraBox.addItem("and");
			extraBox.addItem("or");
			itm.getJf().add(lab, 8);
			itm.getJf().add(extraBox, 9);
			itm.setExtraBox(extraBox);
		}
	}

	private void visitorAndDep(ActionEvent e) {
		if (e.getActionCommand().equals("更新")) {
			pView.getDm().setRowCount(0);
			pView.setDm(new DefaultTableModel(UtilsDemo.getAllData(personDao.getAll()),
					new String[] { "编号", "名字", "性别", "部门", "工资" }));
			pView.getDm().addTableModelListener(modelListener);
			pView.getTable().setModel(pView.getDm());
		} else if (e.getActionCommand().equals("查询")) {
			ItmView itm = new ItmView("查询", pView);
			pView.setEnabled(false);
			// 重新设置布局 加一行
			itm.getJf().setLayout(new GridLayout(7, 2, 3, 10));
			// 添加条件选择栏
			JLabel lab = new JLabel("请选择查询条件：");
			lab.setHorizontalAlignment(JLabel.CENTER);
			JComboBox<String> extraBox = new JComboBox<String>();
			extraBox.addItem("and");
			extraBox.addItem("or");
			itm.getJf().add(lab, 10);
			itm.getJf().add(extraBox, 11);
			itm.setExtraBox(extraBox);
		}
	}

	private void visitorAndEmp(ActionEvent e) {
		if (e.getActionCommand().equals("更新")) {
			pView.getDm().setRowCount(0);
			pView.setDm(new DefaultTableModel(UtilsDemo.getAllData(personDao.getAll()),
					new String[] { "编号", "名字", "性别", "部门" }));
			pView.getDm().addTableModelListener(modelListener);
			pView.getTable().setModel(pView.getDm());
		} else if (e.getActionCommand().equals("查询")) {
			ItmView itm = new ItmView("查询", pView);
			pView.setEnabled(false);

			// 删除薪水栏
			itm.getJf().remove(itm.getSalField());
			itm.getJf().remove(itm.getSalLab());

			// 重新设置布局 加一行
			itm.getJf().setLayout(new GridLayout(7, 2, 3, 10));
			// 添加条件选择栏
			JLabel lab = new JLabel("请选择查询条件：");
			lab.setHorizontalAlignment(JLabel.CENTER);
			JComboBox<String> extraBox = new JComboBox<String>();
			extraBox.addItem("and");
			extraBox.addItem("or");
			itm.getJf().add(lab, 8);
			itm.getJf().add(extraBox, 9);
			itm.setExtraBox(extraBox);
		}
	}

	private void inAndOut(ActionEvent e) {
		if (e.getActionCommand().equals("导出")) {
			JFileChooser fc = new JFileChooser();
			// 文件存储对话库
			int stateFile = fc.showSaveDialog(null);// 保存表示0，取消表示1
			File file = fc.getSelectedFile();
			if (stateFile == 0 && !file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "目的文件创建失败！");
				}
			}
			try {
				UtilsDemo.databaseToXML(file);
				JOptionPane.showMessageDialog(null, "文件保存成功！");
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "文件保存失败！");
			}
		} else if (e.getActionCommand().equals("导入")) {
			JFileChooser fc = new JFileChooser();
			// 文件打开对话库
			int OpenState = fc.showOpenDialog(null);
			if (OpenState == 0) {
				File openFile = fc.getSelectedFile();
				try {
					UtilsDemo.setXmlToDatabase(openFile);
					JOptionPane.showMessageDialog(null, "导入成功");
				} catch (DocumentException e1) {
					JOptionPane.showMessageDialog(null, "请选择正确的xml文件");
				} catch (AddMoreException e1) {
					int id = e1.getPerson().getId();
					JOptionPane.showMessageDialog(null, "id为" + id + "以及后面的数据导入失败");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "id不可重复！");
				}
			}
		}
	}
}
