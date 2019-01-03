/**
 * 
 */
package com.aowin.scm.salemanage.pojo;

import java.io.Serializable;

/**
 * @author ����� ���۱�������� date:2018��11��15�� ����11:04:55
 */
public class SaleManageDetModel implements Serializable {
	private int detid;
	private int product_id; // ��Ʒid
	private String product_name;// ��Ʒ����
	private String product_unit;// ��Ʒ������λ
	private int product_quantity;// ��Ʒ����
	private double product_unitprice;// ��Ʒ����
	private double product_dettotalprice;// ��ϸ�ܼ�
	private String sale_paystate;
	private String saleid; // ���۱�ID

	/**
	 * 
	 */
	public SaleManageDetModel() {
		// TODO �Զ����ɵĹ��캯�����
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
