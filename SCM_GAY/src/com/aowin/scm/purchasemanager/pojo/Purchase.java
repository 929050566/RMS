package com.aowin.scm.purchasemanager.pojo;


import java.io.Serializable;

/** 
 * 采购单基本信息
 * @author 骆俊杰
 *date:2018年11月15日 上午10:07:08
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
		// TODO 自动生成的构造函数存根
	}
	/**
	 * @return purchaseid
	 */
	public String getPurchaseid() {
		return purchaseid;
	}
	/**
	 * @param purchaseid 要设置的 purchaseid
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
	 * @param createtime 要设置的 createtime
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
	 * @param suppliername 要设置的 suppliername
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
	 * @param createname 要设置的 createname
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
	 * @param extramoney 要设置的 extramoney
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
	 * @param totalproprices 要设置的 totalproprices
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
	 * @param advanceprice 要设置的 advanceprice
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
	 * @param totalprices 要设置的 totalprices
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
	 * @param paystate 要设置的 paystate
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
	 * @param comment 要设置的 comment
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
	 * @param disposestate 要设置的 disposestate
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
	 * @param userid 要设置的 userid
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
	 * @param closeDate 要设置的 closeDate
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
	 * @param closeUser 要设置的 closeUser
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
