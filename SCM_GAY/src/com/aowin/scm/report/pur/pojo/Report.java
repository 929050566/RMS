/**
 * 
 */
package com.aowin.scm.report.pur.pojo;

import java.io.Serializable;

/**
 * @author 骆俊杰
 *date:2018年11月20日 下午6:58:18
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
	 * @return nopuy
	 */
	public float getNopuy() {
		return nopuy;
	}
	/**
	 * @param nopuy 要设置的 nopuy
	 */
	public void setNopuy(float nopuy) {
		this.nopuy = nopuy;
	}
	/* （非 Javadoc）
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
