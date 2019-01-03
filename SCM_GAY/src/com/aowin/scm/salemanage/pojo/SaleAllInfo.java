/**
 * 
 */
package com.aowin.scm.salemanage.pojo;

import java.io.Serializable;

/**
 * @author 葛金铭
 *销售表添加模块
 * date:2018年11月15日 上午11:04:55
 */
public class SaleAllInfo implements Serializable{
	private String saleid;//销售单编号
	private String createtime;  //创建时间
	private String customername;//	o客户显示
	private String createname; //创建用户
	private float extramoney; //额外费用
	private float totalproprices;//	o产品总价（根据所选明细信息而变化，不可编辑）
	private float  advanceprice;//	最低预付款金额
	private String comment; //	o备注
	private float totalprices;//销售单总价
	private String paystate;//	o付款方式(付款方式（1：货到付款 2：款到发货 3：预付款到发货）)
	private String disposestate;//订单状态(处理状态（1：新增 ，2：已收货 ，3：已付款，4：已了解，5：已预付）)
	private String closeDate;//了结时间
	private String closeUser;//了结用户
	private int userid;//用户id
	
	/** 
	 * 入库登记时间 和 经手人
	 */
	private String outStorageDate;
	private String outHandle;
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
