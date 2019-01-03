package com.aowin.stuff.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientView {
	private Socket s;
	private JPanel jp;
	private String name ;
	public ClientView(String name) {
		this.name = name ;
		try {
			s = new Socket("192.168.43.65", 6667);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init();
	}

	private void init() {
		jp = new JPanel();

		jp.setLayout(new FlowLayout());

		JTextArea area = new JTextArea(20, 40);
		jp.add(area);

		JTextField field = new JTextField(25);
		jp.add(field);

		JButton btn = new JButton("发送");
		jp.add(btn);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ("发送".equals(e.getActionCommand())) {
					String message = field.getText();
					message = name + ":" + message;
					PrintWriter pw;
					try {
						pw = new PrintWriter(s.getOutputStream());
						pw.println(message);
						pw.flush();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					field.setText("");
				}
			}
		});
		// 不断接受服务器的信息
		new Thread() {
			public void run() {
				try {
					boolean flag = true;
					while (true) {
						BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
						String str = br.readLine();
						if (flag) {
							area.setText(str);
							flag = false;
						} else {
							area.setText(area.getText() + "\n" + str);
						}
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			};
		}.start();

	}

	public JPanel getJp() {
		return jp;
	}

	public void setJp(JPanel jp) {
		this.jp = jp;
	}

}