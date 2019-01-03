/**
 * 
 */
package com.aowin.scm.storagemanage.pojo;

import java.io.Serializable;

/**
 * 库存表基本数据信息
 * @author Lenovo
 *
 */
public class Storage implements Serializable {
	private int proID;// '产品id',
	private String proName;// '产品名称',
	private String proUnit;// '产品单位',
	private int protypeid;// 产品类别id
	private int presentNum;// '当前库存',
	private int onPurchaseNum;// '采购在途数',
	private int onPresaleNum;// '预销售数',
	  
	/**
	 * 
	 */
	public Storage() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the proID
	 */
	public int getProID() {
		return proID;
	}

	/**
	 * @param proID the proID to set
	 */
	public void setProID(int proID) {
		this.proID = proID;
	}

	/**
	 * @return the proName
	 */
	public String getProName() {
		return proName;
	}

	/**
	 * @param proName the proName to set
	 */
	public void setProName(String proName) {
		this.proName = proName;
	}

	/**
	 * @return the proUnit
	 */
	public String getProUnit() {
		return proUnit;
	}

	/**
	 * @param proUnit the proUnit to set
	 */
	public void setProUnit(String proUnit) {
		this.proUnit = proUnit;
	}

	/**
	 * @return the protypeid
	 */
	public int getProtypeid() {
		return protypeid;
	}

	/**
	 * @param protypeid the protypeid to set
	 */
	public void setProtypeid(int protypeid) {
		this.protypeid = protypeid;
	}

	/**
	 * @return the presentNum
	 */
	public int getPresentNum() {
		return presentNum;
	}

	/**
	 * @param presentNum the presentNum to set
	 */
	public void setPresentNum(int presentNum) {
		this.presentNum = presentNum;
	}

	/**
	 * @return the onPurchaseNum
	 */
	public int getOnPurchaseNum() {
		return onPurchaseNum;
	}

	/**
	 * @param onPurchaseNum the onPurchaseNum to set
	 */
	public void setOnPurchaseNum(int onPurchaseNum) {
		this.onPurchaseNum = onPurchaseNum;
	}

	/**
	 * @return the onPresaleNum
	 */
	public int getOnPresaleNum() {
		return onPresaleNum;
	}

	/**
	 * @param onPresaleNum the onPresaleNum to set
	 */
	public void setOnPresaleNum(int onPresaleNum) {
		this.onPresaleNum = onPresaleNum;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Storage [proID=" + proID + ", proName=" + proName + ", proUnit=" + proUnit + ", protypeid=" + protypeid
				+ ", presentNum=" + presentNum + ", onPurchaseNum=" + onPurchaseNum + ", onPresaleNum=" + onPresaleNum
				+ "]";
	}
	
	
	
}
