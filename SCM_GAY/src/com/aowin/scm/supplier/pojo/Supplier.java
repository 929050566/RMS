/**
 * 
 */
package com.aowin.scm.supplier.pojo;

import java.io.Serializable;

/**
 * 供应商基本信息
 * @author 骆俊杰
 *date:2018年11月15日 上午10:09:21
 *
 */
public class Supplier implements Serializable {
	private int supplieid;
	private String suppliername;
	private String velaname;
	private String supplierpassword;
	private String address;  
	private String mailnumber;
	private String createdate;
	private String phone;
	private String faxes;
	/**
	 * 
	 */
	public Supplier() {
		// TODO 自动生成的构造函数存根
	}
	/**
	 * @return supplieid
	 */
	public int getSupplieid() {
		return supplieid;
	}
	/**
	 * @param supplieid 要设置的 supplieid
	 */
	public void setSupplieid(int supplieid) {
		this.supplieid = supplieid;
	}
	/**
	 * @return suppliername
	 */
	public String getSuppliername() {
		return suppliername;
	}
	/**
	 * @param suppliername 要设置的 suppliername
	 */
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	/**
	 * @return velaname
	 */
	public String getVelaname() {
		return velaname;
	}
	/**
	 * @param velaname 要设置的 velaname
	 */
	public void setVelaname(String velaname) {
		this.velaname = velaname;
	}
	/**
	 * @return supplierpassword
	 */
	public String getSupplierpassword() {
		return supplierpassword;
	}
	/**
	 * @param supplierpassword 要设置的 supplierpassword
	 */
	public void setSupplierpassword(String supplierpassword) {
		this.supplierpassword = supplierpassword;
	}
	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address 要设置的 address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**供应商基本信息
	 * @return mailnumber
	 */
	public String getMailnumber() {
		return mailnumber;
	}
	/**
	 * @param mailnumber 要设置的 mailnumber
	 */
	public void setMailnumber(String mailnumber) {
		this.mailnumber = mailnumber;
	}
	/**
	 * @return createdate
	 */
	public String getCreatedate() {
		return createdate;
	}
	/**
	 * @param createdate 要设置的 createdate
	 */
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	/**
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone 要设置的 phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return faxes
	 */
	public String getFaxes() {
		return faxes;
	}
	/**
	 * @param faxes 要设置的 faxes
	 */
	public void setFaxes(String faxes) {
		this.faxes = faxes;
	}
	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Supplier [supplieid=" + supplieid + ", suppliername=" + suppliername + ", velaname=" + velaname
				+ ", supplierpassword=" + supplierpassword + ", address=" + address + ", mailnumber=" + mailnumber
				+ ", createdate=" + createdate + ", phone=" + phone + ", faxes=" + faxes + "]";
	}
	
}
