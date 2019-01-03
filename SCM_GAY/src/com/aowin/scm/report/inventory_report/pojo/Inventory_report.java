/**
 * 
 */
package com.aowin.scm.report.inventory_report.pojo;

import java.io.Serializable;

/**
 * @author 骆俊杰
 *date:2018年11月21日 上午11:35:38
 * 
 */
public class Inventory_report implements Serializable {
	private int proID;// '产品id',
	private String proName;// '产品名称',
	private int presentNum;
	private int num;//入库数量
	private String createname;
	/**
	 * 
	 */
	public Inventory_report() {
		// TODO 自动生成的构造函数存根
	}
	/**
	 * @return proID
	 */
	public int getProID() {
		return proID;
	}
	/**
	 * @param proID 要设置的 proID
	 */
	public void setProID(int proID) {
		this.proID = proID;
	}
	/**
	 * @return proName
	 */
	public String getProName() {
		return proName;
	}
	/**
	 * @param proName 要设置的 proName
	 */
	public void setProName(String proName) {
		this.proName = proName;
	}
	/**
	 * @return presentNum
	 */
	public int getPresentNum() {
		return presentNum;
	}
	/**
	 * @param presentNum 要设置的 presentNum
	 */
	public void setPresentNum(int presentNum) {
		this.presentNum = presentNum;
	}
	
	
	/**
	 * @return num
	 */
	public int getNum() {
		return num;
	}
	/**
	 * @param num 要设置的 num
	 */
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * @return createname
	 */
	public String getCreatename() {
		return createname;
	}
	/**
	 * @param createname 要设置的 createname
	 */
	public void setCreatename(String createname) {
		this.createname = createname;
	}
	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Inventory_report [proID=" + proID + ", proName=" + proName + ", presentNum=" + presentNum + ", num="
				+ num + ", createname=" + createname + "]";
	}
	
	
	
	
	
}
