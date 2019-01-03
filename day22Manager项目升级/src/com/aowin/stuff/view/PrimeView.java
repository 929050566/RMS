package com.aowin.stuff.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.aowin.stuff.dbconnection.PersonDao;
import com.aowin.stuff.listener.BtnListener;
import com.aowin.stuff.listener.MyMouseListener;
import com.aowin.stuff.listener.MyTableModelListener;
import com.aowin.stuff.listener.MyWindowListener;
import com.aowin.stuff.model.Person;
import com.aowin.stuff.utils.UtilsDemo;

public class PrimeView extends JFrame {

	private Container contentPane;
	private JTable table;
	private PersonDao personDao;
	private DefaultTableModel dm;
	private JLabel loginLab;
	private JScrollPane scollPanel;
	private ClientView cView;
	private JPanel jpScolOrClient;
	
	private int permission;
	// �ο�Ȩ�� ��־
	public static final int visitorPermission = 5;
	// ������Ȩ�ޱ�־
	public static final int managerPermission = 1;
	private int depOrEmpOrTalk;
	// ���Ų��ű�־
	public static final int dep = 5;
	// Ա�������־
	public static final int emp = 1;
	// �������۱�־
	public static final int talk = 10;

	private MyTableModelListener modelListener;
	
	
	//���ܰ�ť
	private JButton addBtn;
	private JButton deleteBtn;
	private JButton updateBtn;
	private JButton	refreshBtn;
	private JButton queryBtn;
	
	//��Ŀ
	private JMenuItem addMenuItem;
	private JMenuItem updateItem;
	private JMenuItem queryItem;
	
	public PrimeView(int permission) {
		personDao = new PersonDao();
		// ����Ȩ��
		this.permission = permission;
		// Ĭ��ΪԱ������
		this.depOrEmpOrTalk = emp;
		loginLab = new JLabel();
		if (permission == visitorPermission) {
			loginLab.setText("���ã��ο�");
		} else if (permission == managerPermission) {
			loginLab.setText("���ã�admin");
		}
		init();
	}

	private void init() {
		// new һ��������
		BtnListener btnListener = new BtnListener(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);

		addMenuItem = new JMenuItem("����");
		mnNewMenu.add(addMenuItem);

		updateItem = new JMenuItem("�޸�");
		mnNewMenu.add(updateItem);

		queryItem = new JMenuItem("��ѯ");
		mnNewMenu.add(queryItem);

		mnNewMenu.addSeparator();

		JMenuItem inMenuItem = new JMenuItem("����");
		mnNewMenu.add(inMenuItem);

		JMenuItem outMenuItem = new JMenuItem("����");
		mnNewMenu.add(outMenuItem);

		JMenuItem exitMenuItem = new JMenuItem("�˳�");
		mnNewMenu.add(exitMenuItem);

		JMenu heloNewMenu = new JMenu("help");
		menuBar.add(heloNewMenu);

		// ����Ŀ��Ӽ�����
		addMenuItem.addActionListener(btnListener);
		updateItem.addActionListener(btnListener);
		queryItem.addActionListener(btnListener);
		// �����������
		outMenuItem.addActionListener(btnListener);
		inMenuItem.addActionListener(btnListener);
		// �˳���Ŀ����
		exitMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		contentPane = getContentPane();
		// ���ò���
		contentPane.setLayout(new BorderLayout());

		JLabel label = new JLabel("���¹���ϵͳ");
		label.setFont(new Font("����", Font.BOLD, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER); // ˮƽλ��
		label.setVerticalAlignment(SwingConstants.CENTER); // ��ֱλ������
		contentPane.add(label, BorderLayout.NORTH);

		dm = new DefaultTableModel(UtilsDemo.getAllData(personDao.getAll()),
				new String[] { "���", "����", "�Ա�", "����", "����" });
		table = new JTable(dm);
		table.setBackground(SystemColor.control);
		scollPanel = new JScrollPane(table);
		jpScolOrClient = new JPanel();
		jpScolOrClient.setLayout(new CardLayout());
		//��ӱ��
		jpScolOrClient.add(scollPanel);
		JPanel cJp = null;
		if(permission == managerPermission) {
			cJp =  new ClientView("admin").getJp();
		}else if(permission == visitorPermission) {
			cJp =  new ClientView("�ο�").getJp();
		}
		jpScolOrClient.add(cJp);
		contentPane.add(jpScolOrClient, BorderLayout.CENTER);
		
		// JPanel jp1 = new JPanel();
		// jp1.setLayout(new FlowLayout());
		JPanel jp1_1 = new JPanel();
		jp1_1.setLayout(new GridLayout(8, 1, 40, 20));

		loginLab.setBackground(SystemColor.control);
		JButton empBtn = new JButton("Ա������");
		JButton depBtn = new JButton("���Ź���");
		JButton talkBtn = new JButton("��������");
		jp1_1.add(loginLab);
		jp1_1.add(empBtn);
		jp1_1.add(depBtn);
		jp1_1.add(talkBtn);
		contentPane.add(jp1_1, BorderLayout.WEST);

		// ����߰���ע�������
		empBtn.addActionListener(btnListener);
		depBtn.addActionListener(btnListener);
		talkBtn.addActionListener(btnListener);

		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout());
		contentPane.add(jp2, BorderLayout.SOUTH);

		addBtn = new JButton("����");
		jp2.add(addBtn);

		deleteBtn = new JButton("ɾ��");
		jp2.add(deleteBtn);

		updateBtn = new JButton("�޸�");
		jp2.add(updateBtn);

		refreshBtn = new JButton("����");
		jp2.add(refreshBtn);

		queryBtn = new JButton("��ѯ");
		jp2.add(queryBtn);
		
		if (permission == visitorPermission) {
			addMenuItem.setEnabled(false);
			updateItem.setEnabled(false);
			//queryItem.setEnabled(false);
			addBtn.setVisible(false);
			deleteBtn.setVisible(false);
			updateBtn.setVisible(false);
			
			table.setEnabled(false);
		} else if (permission == managerPermission) {
			addMenuItem.setEnabled(true);
			updateItem.setEnabled(true);
			queryItem.setEnabled(true);
			addBtn.setVisible(true);
			deleteBtn.setVisible(true);
			updateBtn.setVisible(true);
			table.setEnabled(true);
		}
		// ע�������
		addBtn.addActionListener(btnListener);
		deleteBtn.addActionListener(btnListener);
		updateBtn.addActionListener(btnListener);
		refreshBtn.addActionListener(btnListener);
		queryBtn.addActionListener(btnListener);
		// ע��������
		table.addMouseListener(new MyMouseListener(this));
		scollPanel.addMouseListener(new MyMouseListener(this));
		// ����ԭ�е�oldDm
		modelListener = new MyTableModelListener(this);
		dm.addTableModelListener(modelListener);
		setSize(700, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public DefaultTableModel getDm() {
		return dm;
	}

	public void setDm(DefaultTableModel dm) {
		this.dm = dm;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}


	public int getDepOrEmpOrTalk() {
		return depOrEmpOrTalk;
	}

	public void setDepOrEmpOrTalk(int depOrEmpOrTalk) {
		this.depOrEmpOrTalk = depOrEmpOrTalk;
	}

	public MyTableModelListener getModelListener() {
		return modelListener;
	}

	public void setModelListener(MyTableModelListener modelListener) {
		this.modelListener = modelListener;
	}

	public JScrollPane getScollPanel() {
		return scollPanel;
	}

	public void setScollPanel(JScrollPane scollPanel) {
		this.scollPanel = scollPanel;
	}

	public JPanel getJpScolOrClient() {
		return jpScolOrClient;
	}

	public void setJpScolOrClient(JPanel jpScolOrClient) {
		this.jpScolOrClient = jpScolOrClient;
	}

	public JButton getAddBtn() {
		return addBtn;
	}

	public void setAddBtn(JButton addBtn) {
		this.addBtn = addBtn;
	}

	public JButton getDeleteBtn() {
		return deleteBtn;
	}

	public void setDeleteBtn(JButton deleteBtn) {
		this.deleteBtn = deleteBtn;
	}

	public JButton getUpdateBtn() {
		return updateBtn;
	}

	public void setUpdateBtn(JButton updateBtn) {
		this.updateBtn = updateBtn;
	}

	public JButton getRefreshBtn() {
		return refreshBtn;
	}

	public void setRefreshBtn(JButton refreshBtn) {
		this.refreshBtn = refreshBtn;
	}

	public JButton getQueryBtn() {
		return queryBtn;
	}

	public void setQueryBtn(JButton queryBtn) {
		this.queryBtn = queryBtn;
	}

	public JMenuItem getAddMenuItem() {
		return addMenuItem;
	}

	public void setAddMenuItem(JMenuItem addMenuItem) {
		this.addMenuItem = addMenuItem;
	}

	public JMenuItem getUpdateItem() {
		return updateItem;
	}

	public void setUpdateItem(JMenuItem updateItem) {
		this.updateItem = updateItem;
	}

	public JMenuItem getQueryItem() {
		return queryItem;
	}

	public void setQueryItem(JMenuItem queryItem) {
		this.queryItem = queryItem;
	}

}
