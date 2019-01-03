/**
 * 销售表中的 财务信息
 */
package com.aowin.scm.salemanage.pojo;

public class FinanceSaleModel {
	/**
	 * @author 葛金铭
	 *
	 * date:2018年11月16日 上午10:49:19
	 */
	private String date;
	private String theway;
	private String handle;
	public FinanceSaleModel() {
		// date,theway,handle
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTheway() {
		return theway;
	}
	public void setTheway(String theway) {
		this.theway = theway;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
	
	
}
