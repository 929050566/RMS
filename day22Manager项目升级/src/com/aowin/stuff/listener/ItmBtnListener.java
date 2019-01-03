package com.aowin.stuff.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.aowin.stuff.dbconnection.PersonDao;
import com.aowin.stuff.exception.IdIsExistException;
import com.aowin.stuff.exception.IdIsIlliegalException;
import com.aowin.stuff.exception.ListIsZeroException;
import com.aowin.stuff.exception.MessNotNullException;
import com.aowin.stuff.exception.SQLIsNullException;
import com.aowin.stuff.model.Person;
import com.aowin.stuff.utils.UtilsDemo;
import com.aowin.stuff.view.ItmView;
import com.aowin.stuff.view.PrimeView;

public class ItmBtnListener implements ActionListener {

	private String title;
	private ItmView itmView;
	private Person person;
	private PersonDao personDao;
	private PrimeView pView;

	private String id;
	private String name;
	private String sex;
	private String department;
	private String salary;
	private String operator;
	private MyTableModelListener modelListener;
	//用于修改操作
	
	public ItmBtnListener(String title, ItmView itmView, PrimeView pView) {
		super();
		this.title = title;
		this.itmView = itmView;
		this.pView = pView;
		personDao = new PersonDao();
		modelListener = pView.getModelListener();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		id = itmView.getIdField().getText();
		name = itmView.getNameField().getText();
		sex = (String) itmView.getSexBox().getSelectedItem();
		department = (String) itmView.getDeptBox().getSelectedItem();
		salary = itmView.getSalField().getText();
		
		if (title.equals("增加")) {
			if (e.getActionCommand().equals("确定")) {
				try {
					if(id.length() == 0 || name.length() == 0 || sex.length() == 0 || department.length() == 0 ) {
						throw new MessNotNullException();
					}
					if(!id.matches("[0-9]{1,4}")) {//id必须是1到4位的数字
						throw new IdIsIlliegalException();
					}
						
					packetPerson("增加");
					personDao.add(person);
					// 更新表格
					String[] arr = { id, name, sex, department, salary };
					pView.getDm().addRow(arr);
					JOptionPane.showMessageDialog(null, "添加成功");
					itmView.getJf().setVisible(false);
					concelBtn();
				} catch (MessNotNullException e1) {
					if(pView.getDepOrEmpOrTalk() == pView.emp) {
						JOptionPane.showMessageDialog(null, "除了工资都不能为空！");
					}else if (pView.getDepOrEmpOrTalk() == pView.dep) {
						JOptionPane.showMessageDialog(null, "不能为空！");
					}
				} catch (IdIsExistException e1) {
					JOptionPane.showMessageDialog(null, "添加失败id="+e1.getId()+"重复！");
				} catch (IdIsIlliegalException e1) {
					JOptionPane.showMessageDialog(null, "id必须是1到4位的数字");
				}
			} else if (e.getActionCommand().equals("取消")) {
				concelBtn();
			}
		} else if (title.equals("查询")) {
			operator = (String) itmView.getExtraBox().getSelectedItem();
			String sql = null;
			if (e.getActionCommand().equals("确定")) {
				try {
					sql = createSQL();
					ArrayList<Person> list = personDao.getPersonBySQL(sql);
					// 显示查询结果
				
					pView.getDm().setRowCount(0);
					if(pView.getDepOrEmpOrTalk() == pView.emp) {
						pView.setDm(new DefaultTableModel(UtilsDemo.getAllData(list),
								new String[] { "编号", "名字", "性别", "部门", "工资" }));
					}else if (pView.getDepOrEmpOrTalk() == pView.dep) {
						pView.setDm(new DefaultTableModel(UtilsDemo.getAllData(list),
								new String[] { "编号", "名字", "性别", "部门"}));
					}
					pView.getDm().addTableModelListener(modelListener);
					pView.getTable().setModel(pView.getDm());
					// 关闭(取消)
					concelBtn();
					JOptionPane.showMessageDialog(null, "查询完成！");
					// 关闭
					concelBtn();
				} catch (SQLIsNullException e1) {
					JOptionPane.showMessageDialog(null, "请输入查询条件！");
				} catch (ListIsZeroException e1) {
					JOptionPane.showMessageDialog(null, "查无此人！");
				}
			} else if (e.getActionCommand().equals("取消")) {
				concelBtn();
			}
		} else if (title.equals("修改")) {
			if (e.getActionCommand().equals("确定")) {
				// 封装person
				packetPerson("修改");
				try {
					personDao.update(person,itmView.getOldId());
					JOptionPane.showMessageDialog(null, "修改成功!");
					// 刷新
					refreshData();
					// 关闭
					concelBtn();
				} catch (IdIsExistException e1) {
					int id = e1.getPerson().getId();
					JOptionPane.showMessageDialog(null, "id="+id+"重复了！");
				}
			} else if (e.getActionCommand().equals("取消")) {
				// 关闭
				concelBtn();
			}
		}

	}
	
	//取消按钮操作
	private void concelBtn() {
		itmView.getJf().setVisible(false);
		pView.setVisible(true);
		pView.setEnabled(true);
	}

	private void refreshData() {
		pView.getDm().setRowCount(0);
		pView.setDm(new DefaultTableModel(UtilsDemo.getAllData(personDao.getAll()),
				new String[] { "编号", "名字", "性别", "部门", "工资" }));
		pView.getDm().addTableModelListener(modelListener);
		pView.getTable().setModel(pView.getDm());
	}
	
	//封装Person 
	private void packetPerson(String function) {
		person = new Person();
		person.setId(Integer.valueOf(id));
		person.setName(name);
		if (sex.equals("男")) {
			person.setSex(1);
		} else if (sex.equals("女")) {
			person.setSex(0);
		}
		person.setDepartment(department);
		//如果没有salary值 及为部门管理模式 修改的时候
		if(pView.getDepOrEmpOrTalk() == pView.dep ) {
			if(function.equals("修改")) {
				person.setSalary(itmView.getOldSal());
			}else if (function.equals("增加")) {
				person.setSalary(0);
			}
		}else if(pView.getDepOrEmpOrTalk() == pView.emp){
			if(salary.length() != 0) {
				person.setSalary(Integer.valueOf(salary));
			}else {
				person.setSalary(0);
			}
		}
		
	}

	private String createSQL() throws SQLIsNullException {
		String sql = "select * from person where ";
		if (operator.equals("and")) {
			sql = createSqlAnd(sql, "and");
		} else if (operator.equals("or")) {
			sql = createSqlAnd(sql, "or");
		}
		return sql;
	}

	private String createSqlAnd(String sql, String condition) throws SQLIsNullException {
		String con = null;
		if (condition.equals("and")) {
			con = " and ";
		} else if (condition.equals("or")) {
			con = " or ";
		}
		boolean flag = true;
		if (name.length() != 0) {
			if (flag == false) {
				sql = sql + con;
			}
			sql = sql + "name like '%" + name + "%' ";
			flag = false;
		}
		if (id.length() != 0) {
			if (flag == false) {
				sql = sql + con;
			}
			sql = sql + "id = " + Integer.valueOf(id) + " ";
			flag = false;
		}
		if (sex.length() != 0) {
			if (flag == false) {
				sql = sql + con;
			}
			if (sex.equals("男")) {
				sql = sql + "sex = " + 1 + " ";
			} else {
				sql = sql + "sex = " + 0;
			}
			flag = false;
		}
		if (department.length() != 0) {
			if (flag == false) {
				sql = sql + con;
			}
			sql = sql + "department = '" + department + "' ";
			flag = false;
		}
		if (salary.length() != 0) {
			if (flag == false) {
				sql = sql + con;
			}
			sql = sql + "salary = " + Integer.valueOf(salary) + " ";
			flag = false;
		}
		// 如果添加为空 提示用户 输入条件
		if (flag) {
			throw new SQLIsNullException();
		}
		return sql;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ItmView getItmView() {
		return itmView;
	}

	public void setItmView(ItmView itmView) {
		this.itmView = itmView;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
