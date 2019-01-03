/**
 * 
 */
package com.aowin.scm.report.storage.pojo;

import java.io.Serializable;

/**
 * @author 李小龙
 * date:2018年11月21日 上午10:30:20
 * 
 * 
 */
public class StorageBus implements Serializable {

	private String purchaseid;
	private String outStorageDate;
	private String inStorageDate;
	private float totalprices;
	private int proid;
	private String proname;
	private int inNum;
	private int pronum;
	private int outNum;
	private String prounit;
	private float unitprice;
	private float totalprice;
	private String salebillid;// '销售单编号',salebillid
	
	
	/**
	 * 
	 */
	public StorageBus() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @return the outNum
	 */
	public int getOutNum() {
		return outNum;
	}


	/**
	 * @param outNum the outNum to set
	 */
	public void setOutNum(int outNum) {
		this.outNum = outNum;
	}


	/**
	 * @return the inNum
	 */
	public int getInNum() {
		return inNum;
	}


	/**
	 * @param inNum the inNum to set
	 */
	public void setInNum(int inNum) {
		this.inNum = inNum;
	}


	/**
	 * @return the purchaseid
	 */
	public String getPurchaseid() {
		return purchaseid;
	}


	/**
	 * @param purchaseid the purchaseid to set
	 */
	public void setPurchaseid(String purchaseid) {
		this.purchaseid = purchaseid;
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
	 * @return the proid
	 */
	public int getProid() {
		return proid;
	}


	/**
	 * @param proid the proid to set
	 */
	public void setProid(int proid) {
		this.proid = proid;
	}


	/**
	 * @return the proname
	 */
	public String getProname() {
		return proname;
	}


	/**
	 * @param proname the proname to set
	 */
	public void setProname(String proname) {
		this.proname = proname;
	}


	/**
	 * @return the pronum
	 */
	public int getPronum() {
		return pronum;
	}


	/**
	 * @param pronum the pronum to set
	 */
	public void setPronum(int pronum) {
		this.pronum = pronum;
	}


	/**
	 * @return the prounit
	 */
	public String getProunit() {
		return prounit;
	}


	/**
	 * @param prounit the prounit to set
	 */
	public void setProunit(String prounit) {
		this.prounit = prounit;
	}


	/**
	 * @return the unitprice
	 */
	public float getUnitprice() {
		return unitprice;
	}


	/**
	 * @param unitprice the unitprice to set
	 */
	public void setUnitprice(float unitprice) {
		this.unitprice = unitprice;
	}


	/**
	 * @return the totalprice
	 */
	public float getTotalprice() {
		return totalprice;
	}


	/**
	 * @param totalprice the totalprice to set
	 */
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StorageBus [purchaseid=" + purchaseid + ", outStorageDate=" + outStorageDate + ", inStorageDate="
				+ inStorageDate + ", totalprices=" + totalprices + ", proid=" + proid + ", proname=" + proname
				+ ", pronum=" + pronum + ", prounit=" + prounit + ", unitprice=" + unitprice + ", totalprice="
				+ totalprice + ", salebillid=" + salebillid + "]";
	}
}
