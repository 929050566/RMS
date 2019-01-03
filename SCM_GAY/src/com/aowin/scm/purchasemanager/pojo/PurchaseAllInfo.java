package com.aowin.scm.purchasemanager.pojo;

public class PurchaseAllInfo {

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
	 * 入库登记时间 和 经手人
	 */
	private String inStorageDate;
	private String inoHandle;
	/**
	 * 付款登记时间 和 经手人
	 */
	private String payDate;
	private String payHandle;
	/**
	 * 预付款登记时间 和 经手人
	 */
	private String advanceDate;
	private String advanceHandle;
	/**
	 * @return the purchaseid
	 */
	
	public String getPurchaseid() {
		return purchaseid;
	}
	public PurchaseAllInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param purchaseid the purchaseid to set
	 */
	public void setPurchaseid(String purchaseid) {
		this.purchaseid = purchaseid;
	}
	/**
	 * @return the createtime
	 */
	public String getCreatetime() {
		return createtime;
	}
	/**
	 * @param createtime the createtime to set
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	/**
	 * @return the suppliername
	 */
	public String getSuppliername() {
		return suppliername;
	}
	/**
	 * @param suppliername the suppliername to set
	 */
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	/**
	 * @return the createname
	 */
	public String getCreatename() {
		return createname;
	}
	/**
	 * @param createname the createname to set
	 */
	public void setCreatename(String createname) {
		this.createname = createname;
	}
	/**
	 * @return the extramoney
	 */
	public float getExtramoney() {
		return extramoney;
	}
	/**
	 * @param extramoney the extramoney to set
	 */
	public void setExtramoney(float extramoney) {
		this.extramoney = extramoney;
	}
	/**
	 * @return the totalproprices
	 */
	public float getTotalproprices() {
		return totalproprices;
	}
	/**
	 * @param totalproprices the totalproprices to set
	 */
	public void setTotalproprices(float totalproprices) {
		this.totalproprices = totalproprices;
	}
	/**
	 * @return the advanceprice
	 */
	public float getAdvanceprice() {
		return advanceprice;
	}
	/**
	 * @param advanceprice the advanceprice to set
	 */
	public void setAdvanceprice(float advanceprice) {
		this.advanceprice = advanceprice;
	}
	/**
	 * @return the totalprices
	 */
	public float getTotalprices() {
		return totalprices;
	}
	/**
	 * @param totalprices the totalprices to set
	 */
	public void setTotalprices(float totalprices) {
		this.totalprices = totalprices;
	}
	/**
	 * @return the paystate
	 */
	public String getPaystate() {
		return paystate;
	}
	/**
	 * @param paystate the paystate to set
	 */
	public void setPaystate(String paystate) {
		this.paystate = paystate;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return the disposestate
	 */
	public String getDisposestate() {
		return disposestate;
	}
	/**
	 * @param disposestate the disposestate to set
	 */
	public void setDisposestate(String disposestate) {
		this.disposestate = disposestate;
	}
	/**
	 * @return the closeDate
	 */
	public String getCloseDate() {
		return closeDate;
	}
	/**
	 * @param closeDate the closeDate to set
	 */
	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}
	/**
	 * @return the closeUser
	 */
	public String getCloseUser() {
		return closeUser;
	}
	/**
	 * @param closeUser the closeUser to set
	 */
	public void setCloseUser(String closeUser) {
		this.closeUser = closeUser;
	}
	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}
	/**
	 * @return the inStorageDate
	 */
	public String getInStorageDate() {
		return inStorageDate;
	}
	/**
	 * @param inStorageDate the inStorageDate to set
	 */
	public void setInStorageDate(String inStorageDate) {
		this.inStorageDate = inStorageDate;
	}
	/**
	 * @return the inoHandle
	 */
	public String getInoHandle() {
		return inoHandle;
	}
	/**
	 * @param inoHandle the inoHandle to set
	 */
	public void setInoHandle(String inoHandle) {
		this.inoHandle = inoHandle;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PurchaseAllInfo [purchaseid=" + purchaseid + ", createtime=" + createtime + ", suppliername="
				+ suppliername + ", createname=" + createname + ", extramoney=" + extramoney + ", totalproprices="
				+ totalproprices + ", advanceprice=" + advanceprice + ", totalprices=" + totalprices + ", paystate="
				+ paystate + ", comment=" + comment + ", disposestate=" + disposestate + ", closeDate=" + closeDate
				+ ", closeUser=" + closeUser + ", userid=" + userid + ", inStorageDate=" + inStorageDate
				+ ", inoHandle=" + inoHandle + ", payDate=" + payDate + ", payHandle=" + payHandle + ", advanceDate="
				+ advanceDate + ", advanceHandle=" + advanceHandle + "]";
	}
	
}
