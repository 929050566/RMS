package com.aowin.stuff.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.aowin.stuff.dbconnection.UserDao;
import com.aowin.stuff.exception.PasswordisErrorException;
import com.aowin.stuff.exception.UsernameIsErrorException;
import com.aowin.stuff.model.User;
import com.aowin.stuff.server.Server;

//ʵ��һ���û���½����
public class LoginView extends JFrame {

	private UserDao userDao;
	
	public LoginView(String title) throws HeadlessException {
		userDao = new UserDao();
		setTitle(title);
		init();
	}

	private void init() {
		// ȡ�����ֹ�����
		this.setLayout(new GridLayout(3, 2,20,5));
		
		JLabel labelUsername = new JLabel("�˺�:");
		labelUsername.setHorizontalAlignment(JLabel.CENTER);
		JLabel labelPassword = new JLabel("����:");
		labelPassword.setHorizontalAlignment(JLabel.CENTER);
		JTextField testUsername = new JTextField(10);
		JTextField testPassword = new JPasswordField(10);
		JButton butLogin = new JButton("��¼");
		JButton butRegister = new JButton("���");
		butLogin.addActionListener(new ActionListener() {

			private User user;

			@Override
			public void actionPerformed(ActionEvent e) {
				user = new User();
				user.setUsername(testUsername.getText());
				user.setPassword(testPassword.getText());
				try {
					
					int permission = userDao.login(user);
					//��Ȩ�����ý�ȥ
					if(permission == PrimeView.managerPermission) {
						new PrimeView(PrimeView.managerPermission);
					}else if(permission == PrimeView.visitorPermission) {
						new PrimeView(PrimeView.visitorPermission);
					}
					setVisible(false);
				} catch (UsernameIsErrorException e1) {
					JOptionPane.showMessageDialog(null, "�û�������");
				} catch (PasswordisErrorException e1) {
					JOptionPane.showMessageDialog(null, "�������");
				}
			}
		});
		butRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				testUsername.setText("");
				testPassword.setText("");
			}
		});
		Container panel1 = this.getContentPane();
		panel1.add(labelUsername);
		panel1.add(testUsername);

		panel1.add(labelPassword);
		panel1.add(testPassword);

		panel1.add(butLogin);
		panel1.add(butRegister);

		setLocationRelativeTo(null); // �ô��������ʾ
		setSize(280, 180);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
