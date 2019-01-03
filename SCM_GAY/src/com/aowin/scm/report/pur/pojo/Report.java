/**
 * 
 */
package com.aowin.scm.report.pur.pojo;

import java.io.Serializable;

/**
 * @author �濡��
 *date:2018��11��20�� ����6:58:18
 * 
 */
public class Report implements Serializable {
	private String purchaseid;
	private String createtime;
	private String suppliername;
	private String createname;
	private float totalprices;
	private String paystate;
	private String disposestate;
	private float advanceprice;
	private float nopuy;
	
	private float extramoney;
	private float totalproprices;
	
	
	
	
	/**
	 * 
	 */
	public Report() {
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
	 * @return nopuy
	 */
	public float getNopuy() {
		return nopuy;
	}
	/**
	 * @param nopuy Ҫ���õ� nopuy
	 */
	public void setNopuy(float nopuy) {
		this.nopuy = nopuy;
	}
	/* ���� Javadoc��
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Report [purchaseid=" + purchaseid + ", createtime=" + createtime + ", suppliername=" + suppliername
				+ ", createname=" + createname + ", totalprices=" + totalprices + ", paystate=" + paystate
				+ ", disposestate=" + disposestate + ", advanceprice=" + advanceprice + ", nopuy=" + nopuy
				+ ", extramoney=" + extramoney + ", totalproprices=" + totalproprices + "]";
	}
	

	
}
