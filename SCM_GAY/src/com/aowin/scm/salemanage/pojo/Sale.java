/**
 * 
 */
package com.aowin.scm.salemanage.pojo;

import java.io.Serializable;

/**
 * @author 李小龙
 * date:2018年11月19日 下午11:40:15
 * 
 */
public class Sale implements Serializable {
	private String salebillid;// '销售单编号',salebillid
	private String  createtime;//  '创建时间（日期＋时间）',
	private String  customername;//  '客户姓名',
	private String  createname;//  '创建表的用户',
	private float  extramoney;//  '附加费用',
	private float  totalproprices;//  '产品总价',
	private float  advanceprice;//  '最低预付款金额',
	private float  totalprices;//  '采购单总价格',
	private String  paystate;//  '付款方式（1：货到付款 2：款到发货 3：预付款到发货）',
	private String comment;//  '备注',
	private String  disposestate;// '处理状态（1：新增 ，2：已收货 ，3：已付款，4：已了解，5：已预付）',
	
	/**
	 * 
	 */
	public Sale() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the salebillid
	 */
	public String getSalebillid() {
		return salebillid;
	}

	/**
	 * @param salebillid the salebillid to set
	 */
	public void setSalebillid(String salebillid) {
		this.salebillid = salebillid;
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
	 * @return the customername
	 */
	public String getCustomername() {
		return customername;
	}

	/**
	 * @param customername the customername to set
	 */
	public void setCustomername(String customername) {
		this.customername = customername;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sale [salebillid=" + salebillid + ", createtime=" + createtime + ", customername=" + customername
				+ ", createname=" + createname + ", extramoney=" + extramoney + ", totalproprices=" + totalproprices
				+ ", advanceprice=" + advanceprice + ", totalprices=" + totalprices + ", paystate=" + paystate
				+ ", comment=" + comment + ", disposestate=" + disposestate + "]";
	}
	
}
