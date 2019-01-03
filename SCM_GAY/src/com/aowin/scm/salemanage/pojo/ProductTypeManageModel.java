/**
 * 
 */
package com.aowin.scm.salemanage.pojo;

import java.io.Serializable;

/**
 * @author 葛金铭
 *产品类别表
 * date:2018年11月15日 上午11:16:59
 */
public class ProductTypeManageModel implements Serializable {
	private int product_id;
	private String product_typename;
	private String product_typecomment;
	/**
	 * 
	 */
	public ProductTypeManageModel() {
		// TODO 自动生成的构造函数存根
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_typename() {
		return product_typename;
	}
	public void setProduct_typename(String product_typename) {
		this.product_typename = product_typename;
	}
	public String getProduct_typecomment() {
		return product_typecomment;
	}
	public void setProduct_typecomment(String product_typecomment) {
		this.product_typecomment = product_typecomment;
	}
	@Override
	public String toString() {
		return "ProductTypeManageModel [product_id=" + product_id + ", product_typename=" + product_typename
				+ ", product_typecomment=" + product_typecomment + "]";
	}
	
}
