package com.aowin.stuff.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.aowin.stuff.listener.ItmBtnListener;
import com.aowin.stuff.listener.MyWindowListener;
import com.aowin.stuff.model.Person;

public class ItmView {

	String name = null;
	private JTextField idField;
	private JTextField nameField;
	private JComboBox sexBox;
	private JComboBox deptBox;
	private JTextField salField;
	private JFrame jf;
	private ItmBtnListener itmBtnLintener;
	private PrimeView pView;
	private JComboBox extraBox;
	private JLabel salLab;
	//�����޸Ĳ���
	private int oldId;
	private int oldSal;
	
	public ItmView(String name,PrimeView pView) {
		this.name = name;
		this.pView = pView;
		this.itmBtnLintener = new ItmBtnListener(this.name,this,pView);
		getMessage();
	}

	private Person getMessage() {
		jf = new JFrame();
		jf.setTitle(name);
		Container con = jf.getContentPane();
		con.setLayout(new GridLayout(6, 2, 3, 10));

		JLabel idLab = new JLabel("��ţ�");
		idLab.setHorizontalAlignment(JLabel.CENTER);
		idField = new JTextField(10);
		con.add(idLab);
		con.add(idField);

		JLabel nameLab = new JLabel("������");
		nameLab.setHorizontalAlignment(JLabel.CENTER);
		nameField = new JTextField(10);
		con.add(nameLab);
		con.add(nameField);

		JLabel sexLab = new JLabel("�Ա�");
		sexLab.setHorizontalAlignment(JLabel.CENTER);
		sexBox = new JComboBox();
		sexBox.addItem("");
		sexBox.addItem("��");
		sexBox.addItem("Ů");
		con.add(sexLab);
		con.add(sexBox);

		JLabel deptLab = new JLabel("���ţ�");
		deptLab.setHorizontalAlignment(JLabel.CENTER);
		deptBox = new JComboBox();
		deptBox.addItem("");
		deptBox.addItem("�ϵ�");
		deptBox.addItem("�е�");
		deptBox.addItem("��Ұ");
		deptBox.addItem("����");
		deptBox.addItem("ADC");
		con.add(deptLab);
		con.add(deptBox);

		salLab = new JLabel("���ʣ�");
		salLab.setHorizontalAlignment(JLabel.CENTER);
		salField = new JTextField(10);
		con.add(salLab);
		con.add(salField);
		
		JButton confirmBtn = new JButton("ȷ��");
		con.add(confirmBtn);

		JButton cancelBtn = new JButton("ȡ��");
		con.add(cancelBtn);
		
		
		confirmBtn.addActionListener(itmBtnLintener);
		cancelBtn.addActionListener(itmBtnLintener);

		jf.setSize(250, 280);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.addWindowListener(new MyWindowListener(this,pView));
		//jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JTextField getIdField() {
		return idField;
	}

	public void setIdField(JTextField idField) {
		this.idField = idField;
	}


	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	public JComboBox getSexBox() {
		return sexBox;
	}

	public void setSexBox(JComboBox sexBox) {
		this.sexBox = sexBox;
	}

	public JComboBox getDeptBox() {
		return deptBox;
	}

	public void setDeptBox(JComboBox deptBox) {
		this.deptBox = deptBox;
	}

	public JTextField getSalField() {
		return salField;
	}

	public void setSalField(JTextField salField) {
		this.salField = salField;
	}

	public JFrame getJf() {
		return jf;
	}

	public void setJf(JFrame jf) {
		this.jf = jf;
	}

	public ItmBtnListener getItmBtnLintener() {
		return itmBtnLintener;
	}

	public void setItmBtnLintener(ItmBtnListener itmBtnLintener) {
		this.itmBtnLintener = itmBtnLintener;
	}

	public JTextField getNameField() {
		return nameField;
	}

	public PrimeView getpView() {
		return pView;
	}

	public void setpView(PrimeView pView) {
		this.pView = pView;
	}

	public JComboBox getExtraBox() {
		return extraBox;
	}

	public void setExtraBox(JComboBox extraBox) {
		this.extraBox = extraBox;
	}

	public int getOldId() {
		return oldId;
	}

	public void setOldId(int oldId) {
		this.oldId = oldId;
	}

	public JLabel getSalLab() {
		return salLab;
	}

	public void setSalLab(JLabel salLab) {
		this.salLab = salLab;
	}

	public int getOldSal() {
		return oldSal;
	}

	public void setOldSal(int oldSal) {
		this.oldSal = oldSal;
	}

}

