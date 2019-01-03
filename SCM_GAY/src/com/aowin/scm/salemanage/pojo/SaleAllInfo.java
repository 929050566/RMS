/**
 * 
 */
package com.aowin.scm.salemanage.pojo;

import java.io.Serializable;

/**
 * @author �����
 *���۱����ģ��
 * date:2018��11��15�� ����11:04:55
 */
public class SaleAllInfo implements Serializable{
	private String saleid;//���۵����
	private String createtime;  //����ʱ��
	private String customername;//	o�ͻ���ʾ
	private String createname; //�����û�
	private float extramoney; //�������
	private float totalproprices;//	o��Ʒ�ܼۣ�������ѡ��ϸ��Ϣ���仯�����ɱ༭��
	private float  advanceprice;//	���Ԥ������
	private String comment; //	o��ע
	private float totalprices;//���۵��ܼ�
	private String paystate;//	o���ʽ(���ʽ��1���������� 2������� 3��Ԥ���������)
	private String disposestate;//����״̬(����״̬��1������ ��2�����ջ� ��3���Ѹ��4�����˽⣬5����Ԥ����)
	private String closeDate;//�˽�ʱ��
	private String closeUser;//�˽��û�
	private int userid;//�û�id
	
	/** 
	 * ���Ǽ�ʱ�� �� ������
	 */
	private String outStorageDate;
	private String outHandle;
	/**
	 * ����Ǽ�ʱ�� �� ������
	 */
	private String payDate;
	private String payHandle;
	/**
	 * Ԥ����Ǽ�ʱ�� �� ������
	 */
	private String advanceDate;
	private String advanceHandle;
	/**
	 * @return the purchaseid
	 */
	
	public SaleAllInfo() {
		super();
	}
	
	
	/**
	 * @return the outStorageDate
	 */
	public String getOutStorageDate() {
		return outStorageDate;
	}


	/**
	 * @param outStorageDate the outStorageDate to set
	 */
	public void setOutStorageDate(String outStorageDate) {
		this.outStorageDate = outStorageDate;
	}


	/**
	 * @return the outHandle
	 */
	public String getOutHandle() {
		return outHandle;
	}


	/**
	 * @param outHandle the outHandle to set
	 */
	public void setOutHandle(String outHandle) {
		this.outHandle = outHandle;
	}


	/**
	 * @return the payDate
	 */
	public String getPayDate() {
		return payDate;
	}


	/**
	 * @param payDate the payDate to set
	 */
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}


	/**
	 * @return the payHandle
	 */
	public String getPayHandle() {
		return payHandle;
	}


	/**
	 * @param payHandle the payHandle to set
	 */
	public void setPayHandle(String payHandle) {
		this.payHandle = payHandle;
	}


	/**
	 * @return the advanceDate
	 */
	public String getAdvanceDate() {
		return advanceDate;
	}


	/**
	 * @param advanceDate the advanceDate to set
	 */
	public void setAdvanceDate(String advanceDate) {
		this.advanceDate = advanceDate;
	}


	/**
	 * @return the advanceHandle
	 */
	public String getAdvanceHandle() {
		return advanceHandle;
	}


	/**
	 * @param advanceHandle the advanceHandle to set
	 */
	public void setAdvanceHandle(String advanceHandle) {
		this.advanceHandle = advanceHandle;
	}


	public String getSaleid() {
		return saleid;
	}
	public void setSaleid(String saleid) {
		this.saleid = saleid;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCreatename() {
		return createname;
	}
	public void setCreatename(String createname) {
		this.createname = createname;
	}
	public float getExtramoney() {
		return extramoney;
	}
	public void setExtramoney(float extramoney) {
		this.extramoney = extramoney;
	}
	public float getTotalproprices() {
		return totalproprices;
	}
	public void setTotalproprices(float totalproprices) {
		this.totalproprices = totalproprices;
	}
	public float getAdvanceprice() {
		return advanceprice;
	}
	public void setAdvanceprice(float advanceprice) {
		this.advanceprice = advanceprice;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public float getTotalprices() {
		return totalprices;
	}
	public void setTotalprices(float totalprices) {
		this.totalprices = totalprices;
	}
	public String getPaystate() {
		return paystate;
	}
	public void setPaystate(String paystate) {
		this.paystate = paystate;
	}
	public String getDisposestate() {
		return disposestate;
	}
	public void setDisposestate(String disposestate) {
		this.disposestate = disposestate;
	}
	public String getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}
	public String getCloseUser() {
		return closeUser;
	}
	public void setCloseUser(String closeUser) {
		this.closeUser = closeUser;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SaleAllInfo [saleid=" + saleid + ", createtime=" + createtime + ", customername=" + customername
				+ ", createname=" + createname + ", extramoney=" + extramoney + ", totalproprices=" + totalproprices
				+ ", advanceprice=" + advanceprice + ", comment=" + comment + ", totalprices=" + totalprices
				+ ", paystate=" + paystate + ", disposestate=" + disposestate + ", closeDate=" + closeDate
				+ ", closeUser=" + closeUser + ", userid=" + userid + ", outStorageDate=" + outStorageDate
				+ ", outHandle=" + outHandle + ", payDate=" + payDate + ", payHandle=" + payHandle + ", advanceDate="
				+ advanceDate + ", advanceHandle=" + advanceHandle + "]";
	}

}
