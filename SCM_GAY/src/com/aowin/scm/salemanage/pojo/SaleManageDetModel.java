/**
 * 
 */
package com.aowin.scm.salemanage.pojo;

import java.io.Serializable;

/**
 * @author 葛金铭 销售表销售详表 date:2018年11月15日 上午11:04:55
 */
public class SaleManageDetModel implements Serializable {
	private int detid;
	private int product_id; // 产品id
	private String product_name;// 产品名字
	private String product_unit;// 产品数量单位
	private int product_quantity;// 产品数量
	private double product_unitprice;// 产品单价
	private double product_dettotalprice;// 明细总价
	private String sale_paystate;
	private String saleid; // 销售表ID

	/**
	 * 
	 */
	public SaleManageDetModel() {
		// TODO 自动生成的构造函数存根
	}

	/**
	 * @return the detid
	 */
	public int getDetid() {
		return detid;
	}

	/**
	 * @param detid
	 *            the detid to set
	 */
	public void setDetid(int detid) {
		this.detid = detid;
	}

	public String getSaleid() {
		return saleid;
	}

	public void setSaleid(String saleid) {
		this.saleid = saleid;
	}

	public String getSale_paystate() {
		return sale_paystate;
	}

	public void setSale_paystate(String sale_paystate) {
		this.sale_paystate = sale_paystate;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_unit() {
		return product_unit;
	}

	public void setProduct_unit(String product_unit) {
		this.product_unit = product_unit;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public double getProduct_unitprice() {
		return product_unitprice;
	}

	public void setProduct_unitprice(double product_unitprice) {
		this.product_unitprice = product_unitprice;
	}

	public double getProduct_dettotalprice() {
		return product_dettotalprice;
	}

	public void setProduct_dettotalprice(double product_dettotalprice) {
		this.product_dettotalprice = product_dettotalprice;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SaleManageDetModel [detid=" + detid + ", product_id=" + product_id + ", product_name=" + product_name
				+ ", product_unit=" + product_unit + ", product_quantity=" + product_quantity + ", product_unitprice="
				+ product_unitprice + ", product_dettotalprice=" + product_dettotalprice + ", sale_paystate="
				+ sale_paystate + ", saleid=" + saleid + "]";
	}

}
