/**
 * 
 */
package com.aowin.scm.report.inventory_report.pojo;

import java.io.Serializable;

/**
 * @author �濡��
 *date:2018��11��21�� ����11:35:38
 * 
 */
public class Inventory_report implements Serializable {
	private int proID;// '��Ʒid',
	private String proName;// '��Ʒ����',
	private int presentNum;
	private int num;//�������
	private String createname;
	/**
	 * 
	 */
	public Inventory_report() {
		// TODO �Զ����ɵĹ��캯�����
	}
	/**
	 * @return proID
	 */
	public int getProID() {
		return proID;
	}
	/**
	 * @param proID Ҫ���õ� proID
	 */
	public void setProID(int proID) {
		this.proID = proID;
	}
	/**
	 * @return proName
	 */
	public String getProName() {
		return proName;
	}
	/**
	 * @param proName Ҫ���õ� proName
	 */
	public void setProName(String proName) {
		this.proName = proName;
	}
	/**
	 * @return presentNum
	 */
	public int getPresentNum() {
		return presentNum;
	}
	/**
	 * @param presentNum Ҫ���õ� presentNum
	 */
	public void setPresentNum(int presentNum) {
		this.presentNum = presentNum;
	}
	
	
	/**
	 * @return num
	 */
	public int getNum() {
		return num;
	}
	/**
	 * @param num Ҫ���õ� num
	 */
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * @return createname
	 */
	public String getCreatename() {
		return createname;
	}
	/**
	 * @param createname Ҫ���õ� createname
	 */
	public void setCreatename(String createname) {
		this.createname = createname;
	}
	/* ���� Javadoc��
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Inventory_report [proID=" + proID + ", proName=" + proName + ", presentNum=" + presentNum + ", num="
				+ num + ", createname=" + createname + "]";
	}
	
	
	
	
	
}
