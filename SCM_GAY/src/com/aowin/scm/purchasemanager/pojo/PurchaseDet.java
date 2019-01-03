package com.aowin.scm.purchasemanager.pojo;



import java.io.Serializable;

/**
 * �ɹ�����ϸ������Ϣ
 * @author �濡��
 *date:2018��11��15�� ����10:08:53
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
		// TODO �Զ����ɵĹ��캯�����
	}
	/**
	 * @return detid
	 */
	public int getDetid() {
		return detid;
	}
	/**
	 * @param detid Ҫ���õ� detid
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
	 * @param proid Ҫ���õ� proid
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
	 * @param proname Ҫ���õ� proname
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
	 * @param pronum Ҫ���õ� pronum
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
	 * @param prounit Ҫ���õ� prounit
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
	 * @param unitprice Ҫ���õ� unitprice
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
	 * @param totalprice Ҫ���õ� totalprice
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
	 * @param purchaseid Ҫ���õ� purchaseid
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
