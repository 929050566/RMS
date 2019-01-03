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
	//�����޸Ĳ���
	
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
		
		if (title.equals("����")) {
			if (e.getActionCommand().equals("ȷ��")) {
				try {
					if(id.length() == 0 || name.length() == 0 || sex.length() == 0 || department.length() == 0 ) {
						throw new MessNotNullException();
					}
					if(!id.matches("[0-9]{1,4}")) {//id������1��4λ������
						throw new IdIsIlliegalException();
					}
						
					packetPerson("����");
					personDao.add(person);
					// ���±��
					String[] arr = { id, name, sex, department, salary };
					pView.getDm().addRow(arr);
					JOptionPane.showMessageDialog(null, "��ӳɹ�");
					itmView.getJf().setVisible(false);
					concelBtn();
				} catch (MessNotNullException e1) {
					if(pView.getDepOrEmpOrTalk() == pView.emp) {
						JOptionPane.showMessageDialog(null, "���˹��ʶ�����Ϊ�գ�");
					}else if (pView.getDepOrEmpOrTalk() == pView.dep) {
						JOptionPane.showMessageDialog(null, "����Ϊ�գ�");
					}
				} catch (IdIsExistException e1) {
					JOptionPane.showMessageDialog(null, "���ʧ��id="+e1.getId()+"�ظ���");
				} catch (IdIsIlliegalException e1) {
					JOptionPane.showMessageDialog(null, "id������1��4λ������");
				}
			} else if (e.getActionCommand().equals("ȡ��")) {
				concelBtn();
			}
		} else if (title.equals("��ѯ")) {
			operator = (String) itmView.getExtraBox().getSelectedItem();
			String sql = null;
			if (e.getActionCommand().equals("ȷ��")) {
				try {
					sql = createSQL();
					ArrayList<Person> list = personDao.getPersonBySQL(sql);
					// ��ʾ��ѯ���
				
					pView.getDm().setRowCount(0);
					if(pView.getDepOrEmpOrTalk() == pView.emp) {
						pView.setDm(new DefaultTableModel(UtilsDemo.getAllData(list),
								new String[] { "���", "����", "�Ա�", "����", "����" }));
					}else if (pView.getDepOrEmpOrTalk() == pView.dep) {
						pView.setDm(new DefaultTableModel(UtilsDemo.getAllData(list),
								new String[] { "���", "����", "�Ա�", "����"}));
					}
					pView.getDm().addTableModelListener(modelListener);
					pView.getTable().setModel(pView.getDm());
					// �ر�(ȡ��)
					concelBtn();
					JOptionPane.showMessageDialog(null, "��ѯ��ɣ�");
					// �ر�
					concelBtn();
				} catch (SQLIsNullException e1) {
					JOptionPane.showMessageDialog(null, "�������ѯ������");
				} catch (ListIsZeroException e1) {
					JOptionPane.showMessageDialog(null, "���޴��ˣ�");
				}
			} else if (e.getActionCommand().equals("ȡ��")) {
				concelBtn();
			}
		} else if (title.equals("�޸�")) {
			if (e.getActionCommand().equals("ȷ��")) {
				// ��װperson
				packetPerson("�޸�");
				try {
					personDao.update(person,itmView.getOldId());
					JOptionPane.showMessageDialog(null, "�޸ĳɹ�!");
					// ˢ��
					refreshData();
					// �ر�
					concelBtn();
				} catch (IdIsExistException e1) {
					int id = e1.getPerson().getId();
					JOptionPane.showMessageDialog(null, "id="+id+"�ظ��ˣ�");
				}
			} else if (e.getActionCommand().equals("ȡ��")) {
				// �ر�
				concelBtn();
			}
		}

	}
	
	//ȡ����ť����
	private void concelBtn() {
		itmView.getJf().setVisible(false);
		pView.setVisible(true);
		pView.setEnabled(true);
	}

	private void refreshData() {
		pView.getDm().setRowCount(0);
		pView.setDm(new DefaultTableModel(UtilsDemo.getAllData(personDao.getAll()),
				new String[] { "���", "����", "�Ա�", "����", "����" }));
		pView.getDm().addTableModelListener(modelListener);
		pView.getTable().setModel(pView.getDm());
	}
	
	//��װPerson 
	private void packetPerson(String function) {
		person = new Person();
		person.setId(Integer.valueOf(id));
		person.setName(name);
		if (sex.equals("��")) {
			person.setSex(1);
		} else if (sex.equals("Ů")) {
			person.setSex(0);
		}
		person.setDepartment(department);
		//���û��salaryֵ ��Ϊ���Ź���ģʽ �޸ĵ�ʱ��
		if(pView.getDepOrEmpOrTalk() == pView.dep ) {
			if(function.equals("�޸�")) {
				person.setSalary(itmView.getOldSal());
			}else if (function.equals("����")) {
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
			if (sex.equals("��")) {
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
		// ������Ϊ�� ��ʾ�û� ��������
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
