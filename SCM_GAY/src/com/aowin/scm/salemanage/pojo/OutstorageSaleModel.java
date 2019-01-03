/**

 *销售表内的出库人 出库信息 
 */
package com.aowin.scm.salemanage.pojo;

/**
 * @author 葛金铭
 *
 * date:2018年11月16日 上午10:49:19
 */
public class OutstorageSaleModel {
	//outStorageDate,outHandle
	private String outStorageDate;
	private String outHandle;
	/**
	 * 
	 */
	public OutstorageSaleModel() {
		// TODO 自动生成的构造函数存根
	}
	public String getOutStorageDate() {
		return outStorageDate;
	}
	public void setOutStorageDate(String outStorageDate) {
		this.outStorageDate = outStorageDate;
	}
	public String getOutHandle() {
		return outHandle;
	}
	public void setOutHandle(String outHandle) {
		this.outHandle = outHandle;
	}
	
}
