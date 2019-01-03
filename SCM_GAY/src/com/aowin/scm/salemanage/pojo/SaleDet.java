/**
 * 
 */
package com.aowin.scm.salemanage.pojo;

import java.io.Serializable;

/**
 * @author 李小龙
 * date:2018年11月19日 下午11:46:25
 * 
 */
public class SaleDet implements Serializable {
	private int detid;// int(20) NOT NULL AUTO_INCREMENT COMMENT '条目id',
	private int  proid;// int(20) DEFAULT NULL COMMENT '产品编号',
	private String  proname;// varchar(20) DEFAULT NULL COMMENT '产品名称',
	private int  pronum;// int(20) DEFAULT NULL COMMENT '产品数量',
	private String  prounit;// varchar(20) DEFAULT NULL COMMENT '产品单位',
	private float  unitprice;// float(20,2) DEFAULT NULL COMMENT '单价',
	private float  totalprice;// float(20,2) DEFAULT NULL COMMENT '产品明细总价',
	private String  saleid;// varchar(30) DEFAULT NULL COMMENT '外键，连接sale表',
	
	/**
	 * 
	 */
	public SaleDet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the detid
	 */
	public int getDetid() {
		return detid;
	}

	/**
	 * @param detid the detid to set
	 */
	public void setDetid(int detid) {
		this.detid = detid;
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
	 * @return the saleid
	 */
	public String getSaleid() {
		return saleid;
	}

	/**
	 * @param saleid the saleid to set
	 */
	public void setSaleid(String saleid) {
		this.saleid = saleid;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SaleDet [detid=" + detid + ", proid=" + proid + ", proname=" + proname + ", pronum=" + pronum
				+ ", prounit=" + prounit + ", unitprice=" + unitprice + ", totalprice=" + totalprice + ", saleid="
				+ saleid + "]";
	}
	
}
