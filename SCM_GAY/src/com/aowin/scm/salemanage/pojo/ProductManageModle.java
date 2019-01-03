/**
 * 
 */
package com.aowin.scm.salemanage.pojo;

import java.io.Serializable;

/**
 * @author 葛金铭
 *产品表
 * date:2018年11月15日 上午11:16:25
 */
public class ProductManageModle implements Serializable {
	private int product_id;
	private String product_name;
	private String product_unit;
	private String product_type;
	/**
	 * 
	 */
	public ProductManageModle() {
		// TODO 自动生成的构造函数存根
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
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	@Override
	public String toString() {
		return "ProductManageModle [product_id=" + product_id + ", product_name=" + product_name + ", product_unit="
				+ product_unit + ", product_type=" + product_type + "]";
	}
	
}
