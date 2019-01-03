package com.aowin.scm.purchasemanager.pojo;


import java.io.Serializable;

/** 
 * �ɹ���������Ϣ
 * @author �濡��
 *date:2018��11��15�� ����10:07:08
 *
 */
 
public class Purchase implements Serializable {
	private String purchaseid;
	private String createtime;
	private String suppliername;
	private String createname;
	private float extramoney;
	private float totalproprices;
	private float advanceprice;
	private float totalprices;
	private String paystate;
	private String comment;
	private String disposestate;
	private String closeDate;
	private String closeUser;
	private int userid;
	/**
	 * 
	 */
	public Purchase() {
		// TODO �Զ����ɵĹ��캯�����
	}
	/**
	 * @return purchaseid
	 */
	public String getPurchaseid() {
		return purchaseid;
	}
	/**
	 * @param purchaseid Ҫ���õ� purchaseid
	 */
	public void setPurchaseid(String purchaseid) {
		this.purchaseid = purchaseid;
	}
	/**
	 * @return createtime
	 */
	public String getCreatetime() {
		return createtime;
	}
	/**
	 * @param createtime Ҫ���õ� createtime
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	/**
	 * @return suppliername
	 */
	public String getSuppliername() {
		return suppliername;
	}
	/**
	 * @param suppliername Ҫ���õ� suppliername
	 */
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
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
	/**
	 * @return extramoney
	 */
	public float getExtramoney() {
		return extramoney;
	}
	/**
	 * @param extramoney Ҫ���õ� extramoney
	 */
	public void setExtramoney(float extramoney) {
		this.extramoney = extramoney;
	}
	/**
	 * @return totalproprices
	 */
	public float getTotalproprices() {
		return totalproprices;
	}
	/**
	 * @param totalproprices Ҫ���õ� totalproprices
	 */
	public void setTotalproprices(float totalproprices) {
		this.totalproprices = totalproprices;
	}
	/**
	 * @return advanceprice
	 */
	public float getAdvanceprice() {
		return advanceprice;
	}
	/**
	 * @param advanceprice Ҫ���õ� advanceprice
	 */
	public void setAdvanceprice(float advanceprice) {
		this.advanceprice = advanceprice;
	}
	/**
	 * @return totalprices
	 */
	public float getTotalprices() {
		return totalprices;
	}
	/**
	 * @param totalprices Ҫ���õ� totalprices
	 */
	public void setTotalprices(float totalprices) {
		this.totalprices = totalprices;
	}
	/**
	 * @return paystate
	 */
	public String getPaystate() {
		return paystate;
	}
	/**
	 * @param paystate Ҫ���õ� paystate
	 */
	public void setPaystate(String paystate) {
		this.paystate = paystate;
	}
	/**
	 * @return comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment Ҫ���õ� comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return disposestate
	 */
	public String getDisposestate() {
		return disposestate;
	}
	/**
	 * @param disposestate Ҫ���õ� disposestate
	 */
	public void setDisposestate(String disposestate) {
		this.disposestate = disposestate;
	}
	/**
	 * @return userid
	 */
	public int getUserid() {
		return userid;
	}
	/**
	 * @param userid Ҫ���õ� userid
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}
	/**
	 * @return closeDate
	 */
	public String getCloseDate() {
		return closeDate;
	}
	/**
	 * @param closeDate Ҫ���õ� closeDate
	 */
	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}
	/**
	 * @return closeUser
	 */
	public String getCloseUser() {
		return closeUser;
	}
	/**
	 * @param closeUser Ҫ���õ� closeUser
	 */
	public void setCloseUser(String closeUser) {
		this.closeUser = closeUser;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Purchase [purchaseid=" + purchaseid + ", createtime=" + createtime + ", suppliername=" + suppliername
				+ ", createname=" + createname + ", extramoney=" + extramoney + ", totalproprices=" + totalproprices
				+ ", advanceprice=" + advanceprice + ", totalprices=" + totalprices + ", paystate=" + paystate
				+ ", comment=" + comment + ", disposestate=" + disposestate + ", closeDate=" + closeDate
				+ ", closeUser=" + closeUser + ", userid=" + userid + "]";
	}
	
}
