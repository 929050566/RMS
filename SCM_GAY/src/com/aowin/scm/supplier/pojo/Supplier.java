/**
 * 
 */
package com.aowin.scm.supplier.pojo;

import java.io.Serializable;

/**
 * ��Ӧ�̻�����Ϣ
 * @author �濡��
 *date:2018��11��15�� ����10:09:21
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
		// TODO �Զ����ɵĹ��캯�����
	}
	/**
	 * @return supplieid
	 */
	public int getSupplieid() {
		return supplieid;
	}
	/**
	 * @param supplieid Ҫ���õ� supplieid
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
	 * @param suppliername Ҫ���õ� suppliername
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
	 * @param velaname Ҫ���õ� velaname
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
	 * @param supplierpassword Ҫ���õ� supplierpassword
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
	 * @param address Ҫ���õ� address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**��Ӧ�̻�����Ϣ
	 * @return mailnumber
	 */
	public String getMailnumber() {
		return mailnumber;
	}
	/**
	 * @param mailnumber Ҫ���õ� mailnumber
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
	 * @param createdate Ҫ���õ� createdate
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
	 * @param phone Ҫ���õ� phone
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
	 * @param faxes Ҫ���õ� faxes
	 */
	public void setFaxes(String faxes) {
		this.faxes = faxes;
	}
	/* ���� Javadoc��
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Supplier [supplieid=" + supplieid + ", suppliername=" + suppliername + ", velaname=" + velaname
				+ ", supplierpassword=" + supplierpassword + ", address=" + address + ", mailnumber=" + mailnumber
				+ ", createdate=" + createdate + ", phone=" + phone + ", faxes=" + faxes + "]";
	}
	
}
