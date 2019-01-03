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
		if (e.getActionCommand().equals("���Ź���")) {
			if(pView.getPermission() == PrimeView.managerPermission) {
				closeOrOpen_BtnAndItm(true);
			}
			//�л���Ƭ
			CardLayout card = (CardLayout) pView.getJpScolOrClient().getLayout();
			card.first(pView.getJpScolOrClient());
		
			pView.getContentPane().revalidate();
			//pView.getContentPane().remove(cView.getJp());
			pView.setDepOrEmpOrTalk(pView.dep);
			// ��������һ��ȥ��
			pView.getDm().setRowCount(0);
			pView.setDm(new DefaultTableModel(UtilsDemo.getAllData(personDao.getAll()),
					new String[] { "���", "����", "�Ա�", "����" }));
			pView.getDm().addTableModelListener(modelListener);
			pView.getTable().setModel(pView.getDm());
		} else if (e.getActionCommand().equals("Ա������")) {
			if(pView.getPermission() == PrimeView.managerPermission) {
				closeOrOpen_BtnAndItm(true);
			}
			//�л���Ƭ
			CardLayout card = (CardLayout) pView.getJpScolOrClient().getLayout();
			card.first(pView.getJpScolOrClient());
			
			pView.getContentPane().revalidate();
			pView.setDepOrEmpOrTalk(pView.emp);
			pView.getDm().setRowCount(0);
			pView.setDm(new DefaultTableModel(UtilsDemo.getAllData(personDao.getAll()),
					new String[] { "���", "����", "�Ա�", "����", "����" }));
			pView.getDm().addTableModelListener(modelListener);
			pView.getTable().setModel(pView.getDm());
		} else if (e.getActionCommand().equals("��������")) {
			pView.setDepOrEmpOrTalk(pView.talk);
			closeOrOpen_BtnAndItm(false);
			CardLayout card = (CardLayout) pView.getJpScolOrClient().getLayout();
			card.last( pView.getJpScolOrClient());
		}
		
		
		// ���Ȩ��Ϊmanager
		if (pView.getPermission() == pView.managerPermission) {
			
			if (pView.getDepOrEmpOrTalk() == pView.dep) {
				managerAndDep(e);
			} else if (pView.getDepOrEmpOrTalk() == pView.emp) {
				managerAndEmp(e);
			}
		// ���Ȩ��Ϊvisitor
		} else if (pView.getPermission() == pView.visitorPermission) {
			if (pView.getDepOrEmpOrTalk() == pView.dep) {
				visitorAndEmp(e);
			} else if (pView.getDepOrEmpOrTalk() == pView.emp) {
				visitorAndDep(e);
			}
		}
		// ����͵���
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
		if (e.getActionCommand().equals("����")) {
			ItmView itm = new ItmView("����", pView);
			pView.setEnabled(false);
		} else if (e.getActionCommand().equals("ɾ��")) {
			boolean flag = true;
			int[] countArr = pView.getTable().getSelectedRows();
			if (countArr.length == 0) {
				JOptionPane.showMessageDialog(null, "��ѡ����Ҫɾ�������ݣ�");
			} else {
				// �õ�ѡ�е�id������
				for (int index = countArr.length - 1; index >= 0; index--) {
					int count = countArr[index];
					int id = Integer.valueOf((String) pView.getDm().getValueAt(count, 0));
					String name = (String) pView.getDm().getValueAt(count, 1);
					// ɾ�����ݿ��к� ���е���һ������
					try {
						personDao.delByIdAndName(name, id);
						pView.getDm().removeRow(count);
						// ������һ��Ҳ��ɾ��
						if (index == 0) {
							flag = false;
						}
						// JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
						return;
					}
				}
				if (!flag) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
				}
			}
		} else if (e.getActionCommand().equals("�޸�")) {

			DefaultTableModel dm = pView.getDm();
			int count = pView.getTable().getSelectedRow();
			if (count == -1)
				JOptionPane.showMessageDialog(null, "��ѡ����Ҫ�޸ĵ����ݣ�");
			else {
				ItmView itm = new ItmView("�޸�", pView);
				itm.getIdField().setText((String) dm.getValueAt(count, 0));
				itm.getNameField().setText((String) dm.getValueAt(count, 1));
				itm.getSexBox().setSelectedItem(dm.getValueAt(count, 2));
				itm.getDeptBox().setSelectedItem(dm.getValueAt(count, 3));
				itm.getSalField().setText((String) dm.getValueAt(count, 4));
				// ����ѡ�е�idֵ
				itm.setOldId(Integer.valueOf((String) dm.getValueAt(count, 0)));
				pView.setEnabled(false);
			}
		} else if (e.getActionCommand().equals("����")) {
			pView.getDm().setRowCount(0);
			pView.setDm(new DefaultTableModel(UtilsDemo.getAllData(personDao.getAll()),
					new String[] { "���", "����", "�Ա�", "����", "����" }));
			pView.getDm().addTableModelListener(modelListener);
			pView.getTable().setModel(pView.getDm());
		} else if (e.getActionCommand().equals("��ѯ")) {
			ItmView itm = new ItmView("��ѯ", pView);
			pView.setEnabled(false);
			// �������ò��� ��һ��
			itm.getJf().setLayout(new GridLayout(7, 2, 3, 10));
			// �������ѡ����
			JLabel lab = new JLabel("��ѡ���ѯ������");
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
		if (e.getActionCommand().equals("����")) {
			ItmView itm = new ItmView("����", pView);
			itm.getJf().remove(itm.getSalField());
			itm.getJf().remove(itm.getSalLab());
			itm.getJf().setSize(250, 250);

			pView.setEnabled(false);
		} else if (e.getActionCommand().equals("ɾ��")) {
			boolean flag = true;
			int[] countArr = pView.getTable().getSelectedRows();
			if (countArr.length == 0) {
				JOptionPane.showMessageDialog(null, "��ѡ����Ҫɾ�������ݣ�");
			} else {
				// �õ�ѡ�е�id������
				for (int index = countArr.length - 1; index >= 0; index--) {
					int count = countArr[index];
					int id = Integer.valueOf((String) pView.getDm().getValueAt(count, 0));
					String name = (String) pView.getDm().getValueAt(count, 1);
					// ɾ�����ݿ��к� ���е���һ������
					try {
						personDao.delByIdAndName(name, id);
						pView.getDm().removeRow(count);
						// ������һ��Ҳ��ɾ��
						if (index == 0) {
							flag = false;
						}
						// JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
						return;
					}
				}
				if (!flag) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
				}
			}
		} else if (e.getActionCommand().equals("�޸�")) {

			DefaultTableModel dm = pView.getDm();
			int count = pView.getTable().getSelectedRow();
			if (count == -1)
				JOptionPane.showMessageDialog(null, "��ѡ����Ҫ�޸ĵ����ݣ�");
			else {
				ItmView itm = new ItmView("�޸�", pView);

				itm.getIdField().setText((String) dm.getValueAt(count, 0));
				itm.getNameField().setText((String) dm.getValueAt(count, 1));
				itm.getSexBox().setSelectedItem(dm.getValueAt(count, 2));
				itm.getDeptBox().setSelectedItem(dm.getValueAt(count, 3));
				// itm.getSalField().setText((String) dm.getValueAt(count, 4));

				itm.getJf().remove(itm.getSalField());
				itm.getJf().remove(itm.getSalLab());
				// ����ѡ�е�idֵ
				itm.setOldSal(personDao.getSalById(Integer.valueOf((String) dm.getValueAt(count, 0))));
				itm.setOldId(Integer.valueOf((String) dm.getValueAt(count, 0)));
				pView.setEnabled(false);
			}
		} else if (e.getActionCommand().equals("����")) {
			pView.getDm().setRowCount(0);
			pView.setDm(new DefaultTableModel(UtilsDemo.getAllData(personDao.getAll()),
					new String[] { "���", "����", "�Ա�", "����" }));
			pView.getDm().addTableModelListener(modelListener);
			pView.getTable().setModel(pView.getDm());
		} else if (e.getActionCommand().equals("��ѯ")) {
			ItmView itm = new ItmView("��ѯ", pView);
			// ɾ��нˮ��
			itm.getJf().remove(itm.getSalField());
			itm.getJf().remove(itm.getSalLab());

			pView.setEnabled(false);
			// �������ò��� ��һ��
			itm.getJf().setLayout(new GridLayout(7, 2, 3, 10));
			// �������ѡ����
			JLabel lab = new JLabel("��ѡ���ѯ������");
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
		if (e.getActionCommand().equals("����")) {
			pView.getDm().setRowCount(0);
			pView.setDm(new DefaultTableModel(UtilsDemo.getAllData(personDao.getAll()),
					new String[] { "���", "����", "�Ա�", "����", "����" }));
			pView.getDm().addTableModelListener(modelListener);
			pView.getTable().setModel(pView.getDm());
		} else if (e.getActionCommand().equals("��ѯ")) {
			ItmView itm = new ItmView("��ѯ", pView);
			pView.setEnabled(false);
			// �������ò��� ��һ��
			itm.getJf().setLayout(new GridLayout(7, 2, 3, 10));
			// �������ѡ����
			JLabel lab = new JLabel("��ѡ���ѯ������");
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
		if (e.getActionCommand().equals("����")) {
			pView.getDm().setRowCount(0);
			pView.setDm(new DefaultTableModel(UtilsDemo.getAllData(personDao.getAll()),
					new String[] { "���", "����", "�Ա�", "����" }));
			pView.getDm().addTableModelListener(modelListener);
			pView.getTable().setModel(pView.getDm());
		} else if (e.getActionCommand().equals("��ѯ")) {
			ItmView itm = new ItmView("��ѯ", pView);
			pView.setEnabled(false);

			// ɾ��нˮ��
			itm.getJf().remove(itm.getSalField());
			itm.getJf().remove(itm.getSalLab());

			// �������ò��� ��һ��
			itm.getJf().setLayout(new GridLayout(7, 2, 3, 10));
			// �������ѡ����
			JLabel lab = new JLabel("��ѡ���ѯ������");
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
		if (e.getActionCommand().equals("����")) {
			JFileChooser fc = new JFileChooser();
			// �ļ��洢�Ի���
			int stateFile = fc.showSaveDialog(null);// �����ʾ0��ȡ����ʾ1
			File file = fc.getSelectedFile();
			if (stateFile == 0 && !file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Ŀ���ļ�����ʧ�ܣ�");
				}
			}
			try {
				UtilsDemo.databaseToXML(file);
				JOptionPane.showMessageDialog(null, "�ļ�����ɹ���");
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "�ļ�����ʧ�ܣ�");
			}
		} else if (e.getActionCommand().equals("����")) {
			JFileChooser fc = new JFileChooser();
			// �ļ��򿪶Ի���
			int OpenState = fc.showOpenDialog(null);
			if (OpenState == 0) {
				File openFile = fc.getSelectedFile();
				try {
					UtilsDemo.setXmlToDatabase(openFile);
					JOptionPane.showMessageDialog(null, "����ɹ�");
				} catch (DocumentException e1) {
					JOptionPane.showMessageDialog(null, "��ѡ����ȷ��xml�ļ�");
				} catch (AddMoreException e1) {
					int id = e1.getPerson().getId();
					JOptionPane.showMessageDialog(null, "idΪ" + id + "�Լ���������ݵ���ʧ��");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "id�����ظ���");
				}
			}
		}
	}
}
