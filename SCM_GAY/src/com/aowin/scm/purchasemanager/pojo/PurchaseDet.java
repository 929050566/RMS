package com.aowin.scm.purchasemanager.pojo;



import java.io.Serializable;

/**
 * 采购单明细基本信息
 * @author 骆俊杰
 *date:2018年11月15日 上午10:08:53
 *
 */
public class PurchaseDet implements Serializable {
	private int detid;
	private int proid;
	private String proname;
	private int pronum;
	private String prounit;
	private float unitprice;
	private float totalprice;
	private String purchaseid;
	/**
	 * 
	 */
	public PurchaseDet() {
		// TODO 自动生成的构造函数存根
	}
	/**
	 * @return detid
	 */
	public int getDetid() {
		return detid;
	}
	/**
	 * @param detid 要设置的 detid
	 */
	public void setDetid(int detid) {
		this.detid = detid;
	}
	/**
	 * @return proid
	 */
	public int getProid() {
		return proid;
	}
	/**
	 * @param proid 要设置的 proid
	 */
	public void setProid(int proid) {
		this.proid = proid;
	}
	/**
	 * @return proname
	 */
	public String getProname() {
		return proname;
	}
	/**
	 * @param proname 要设置的 proname
	 */
	public void setProname(String proname) {
		this.proname = proname;
	}
	/**
	 * @return pronum
	 */
	public int getPronum() {
		return pronum;
	}
	/**
	 * @param pronum 要设置的 pronum
	 */
	public void setPronum(int pronum) {
		this.pronum = pronum;
	}
	/**
	 * @return prounit
	 */
	public String getProunit() {
		return prounit;
	}
	/**
	 * @param prounit 要设置的 prounit
	 */
	public void setProunit(String prounit) {
		this.prounit = prounit;
	}
	/**
	 * @return unitprice
	 */
	public float getUnitprice() {
		return unitprice;
	}
	/**
	 * @param unitprice 要设置的 unitprice
	 */
	public void setUnitprice(float unitprice) {
		this.unitprice = unitprice;
	}
	/**
	 * @return totalprice
	 */
	public float getTotalprice() {
		return totalprice;
	}
	/**
	 * @param totalprice 要设置的 totalprice
	 */
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PurchaseDet [detid=" + detid + ", proid=" + proid + ", proname=" + proname + ", pronum=" + pronum
				+ ", prounit=" + prounit + ", unitprice=" + unitprice + ", totalprice=" + totalprice + ", purchaseid="
				+ purchaseid + "]";
	}
	
}
