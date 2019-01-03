/**
 * 
 */
package com.aowin.scm.storagemanage.pojo;

import java.io.Serializable;

/**
 * 出库登记表基本数据信息
 * @author Lenovo
 *
 */
public class OutStorage implements Serializable {
	
	private int outId;// 'id',
	private String outStorageDate;// '出库时间',  为什么不用date型
	private String outHandle;// '出库经手人',
	private int outNum;// '出库数量',
	private String outState;// '出库类型(2:销售出库,4:盘点出库)',char在java中是string？
	private String Reason;//'损耗原因',
	private int sale_detid;// '销售单明细主键',
	private String salebillid;// 销售单号
	private int proId;
	  
	/**
	 * 
	 */
	public OutStorage() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the proId
	 */
	public int getProId() {
		return proId;
	}

	/**
	 * @param proId the proId to set
	 */
	public void setProId(int proId) {
		this.proId = proId;
	}

	/**
	 * @return the outId
	 */
	public int getOutId() {
		return outId;
	}


	/**
	 * @param outId the outId to set
	 */
	public void setOutId(int outId) {
		this.outId = outId;
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
	 * @return the outHandle
	 */
	public String getOutHandle() {
		return outHandle;
	}


	/**
	 * @param outHandle the outHandle to set
	 */
	public void setOutHandle(String outHandle) {
		this.outHandle = outHandle;
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
	 * @return the outState
	 */
	public String getOutState() {
		return outState;
	}


	/**
	 * @param outState the outState to set
	 */
	public void setOutState(String outState) {
		this.outState = outState;
	}


	/**
	 * @return the reason
	 */
	public String getReason() {
		return Reason;
	}


	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		Reason = reason;
	}


	/**
	 * @return the sale_detid
	 */
	public int getSale_detid() {
		return sale_detid;
	}


	/**
	 * @param sale_detid the sale_detid to set
	 */
	public void setSale_detid(int sale_detid) {
		this.sale_detid = sale_detid;
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
		return "OutStorage [outId=" + outId + ", outStorageDate=" + outStorageDate + ", outHandle=" + outHandle
				+ ", outNum=" + outNum + ", outState=" + outState + ", Reason=" + Reason + ", sale_detid=" + sale_detid
				+ ", salebillid=" + salebillid + ", proId=" + proId + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	
	

}
