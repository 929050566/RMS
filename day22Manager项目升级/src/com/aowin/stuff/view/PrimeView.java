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
	// 游客权限 标志
	public static final int visitorPermission = 5;
	// 管理者权限标志
	public static final int managerPermission = 1;
	private int depOrEmpOrTalk;
	// 部门部门标志
	public static final int dep = 5;
	// 员工管理标志
	public static final int emp = 1;
	// 问题讨论标志
	public static final int talk = 10;

	private MyTableModelListener modelListener;
	
	
	//功能按钮
	private JButton addBtn;
	private JButton deleteBtn;
	private JButton updateBtn;
	private JButton	refreshBtn;
	private JButton queryBtn;
	
	//条目
	private JMenuItem addMenuItem;
	private JMenuItem updateItem;
	private JMenuItem queryItem;
	
	public PrimeView(int permission) {
		personDao = new PersonDao();
		// 设置权限
		this.permission = permission;
		// 默认为员工管理
		this.depOrEmpOrTalk = emp;
		loginLab = new JLabel();
		if (permission == visitorPermission) {
			loginLab.setText("您好！游客");
		} else if (permission == managerPermission) {
			loginLab.setText("您好！admin");
		}
		init();
	}

	private void init() {
		// new 一个监听器
		BtnListener btnListener = new BtnListener(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);

		addMenuItem = new JMenuItem("增加");
		mnNewMenu.add(addMenuItem);

		updateItem = new JMenuItem("修改");
		mnNewMenu.add(updateItem);

		queryItem = new JMenuItem("查询");
		mnNewMenu.add(queryItem);

		mnNewMenu.addSeparator();

		JMenuItem inMenuItem = new JMenuItem("导入");
		mnNewMenu.add(inMenuItem);

		JMenuItem outMenuItem = new JMenuItem("导出");
		mnNewMenu.add(outMenuItem);

		JMenuItem exitMenuItem = new JMenuItem("退出");
		mnNewMenu.add(exitMenuItem);

		JMenu heloNewMenu = new JMenu("help");
		menuBar.add(heloNewMenu);

		// 给条目添加监听器
		addMenuItem.addActionListener(btnListener);
		updateItem.addActionListener(btnListener);
		queryItem.addActionListener(btnListener);
		// 导出导入监听
		outMenuItem.addActionListener(btnListener);
		inMenuItem.addActionListener(btnListener);
		// 退出条目监听
		exitMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		contentPane = getContentPane();
		// 设置布局
		contentPane.setLayout(new BorderLayout());

		JLabel label = new JLabel("人事管理系统");
		label.setFont(new Font("宋体", Font.BOLD, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER); // 水平位置
		label.setVerticalAlignment(SwingConstants.CENTER); // 垂直位置设置
		contentPane.add(label, BorderLayout.NORTH);

		dm = new DefaultTableModel(UtilsDemo.getAllData(personDao.getAll()),
				new String[] { "编号", "名字", "性别", "部门", "工资" });
		table = new JTable(dm);
		table.setBackground(SystemColor.control);
		scollPanel = new JScrollPane(table);
		jpScolOrClient = new JPanel();
		jpScolOrClient.setLayout(new CardLayout());
		//添加表格
		jpScolOrClient.add(scollPanel);
		JPanel cJp = null;
		if(permission == managerPermission) {
			cJp =  new ClientView("admin").getJp();
		}else if(permission == visitorPermission) {
			cJp =  new ClientView("游客").getJp();
		}
		jpScolOrClient.add(cJp);
		contentPane.add(jpScolOrClient, BorderLayout.CENTER);
		
		// JPanel jp1 = new JPanel();
		// jp1.setLayout(new FlowLayout());
		JPanel jp1_1 = new JPanel();
		jp1_1.setLayout(new GridLayout(8, 1, 40, 20));

		loginLab.setBackground(SystemColor.control);
		JButton empBtn = new JButton("员工管理");
		JButton depBtn = new JButton("部门管理");
		JButton talkBtn = new JButton("问题讨论");
		jp1_1.add(loginLab);
		jp1_1.add(empBtn);
		jp1_1.add(depBtn);
		jp1_1.add(talkBtn);
		contentPane.add(jp1_1, BorderLayout.WEST);

		// 给左边按键注册监听器
		empBtn.addActionListener(btnListener);
		depBtn.addActionListener(btnListener);
		talkBtn.addActionListener(btnListener);

		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout());
		contentPane.add(jp2, BorderLayout.SOUTH);

		addBtn = new JButton("增加");
		jp2.add(addBtn);

		deleteBtn = new JButton("删除");
		jp2.add(deleteBtn);

		updateBtn = new JButton("修改");
		jp2.add(updateBtn);

		refreshBtn = new JButton("更新");
		jp2.add(refreshBtn);

		queryBtn = new JButton("查询");
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
		// 注册监听器
		addBtn.addActionListener(btnListener);
		deleteBtn.addActionListener(btnListener);
		updateBtn.addActionListener(btnListener);
		refreshBtn.addActionListener(btnListener);
		queryBtn.addActionListener(btnListener);
		// 注册鼠标监听
		table.addMouseListener(new MyMouseListener(this));
		scollPanel.addMouseListener(new MyMouseListener(this));
		// 保存原有的oldDm
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
