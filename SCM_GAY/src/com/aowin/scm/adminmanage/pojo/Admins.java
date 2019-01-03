package com.aowin.scm.adminmanage.pojo;

import java.sql.Date;

public class Admins {
	
	private int userid;
	private String account;
	private String realname;
	private String password;
	private Date createdate;
	private String lock_statu;
	private String po_permit = "0";
	private String depot_permit = "0";
	private String sale_permit = "0";
	private String finance_permit = "0";
	private String report_permit = "0";
	private String user_permit = "0";
	private String networksale_permit = "0";
	private String manager_permit = "0";
	
	
	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}


	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}


	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}


	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}


	/**
	 * @return the realname
	 */
	public String getRealname() {
		return realname;
	}


	/**
	 * @param realname the realname to set
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the createdate
	 */
	public Date getCreatedate() {
		return createdate;
	}


	/**
	 * @param createdate the createdate to set
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}


	/**
	 * @return the lock_statu
	 */
	public String getLock_statu() {
		return lock_statu;
	}


	/**
	 * @param lock_statu the lock_statu to set
	 */
	public void setLock_statu(String lock_statu) {
		this.lock_statu = lock_statu;
	}


	/**
	 * @return the po_permit
	 */
	public String getPo_permit() {
		return po_permit;
	}


	/**
	 * @param po_permit the po_permit to set
	 */
	public void setPo_permit(String po_permit) {
		this.po_permit = po_permit;
	}


	/**
	 * @return the depot_permit
	 */
	public String getDepot_permit() {
		return depot_permit;
	}


	/**
	 * @param depot_permit the depot_permit to set
	 */
	public void setDepot_permit(String depot_permit) {
		this.depot_permit = depot_permit;
	}


	/**
	 * @return the sale_permit
	 */
	public String getSale_permit() {
		return sale_permit;
	}


	/**
	 * @param sale_permit the sale_permit to set
	 */
	public void setSale_permit(String sale_permit) {
		this.sale_permit = sale_permit;
	}


	/**
	 * @return the finance_permit
	 */
	public String getFinance_permit() {
		return finance_permit;
	}


	/**
	 * @param finance_permit the finance_permit to set
	 */
	public void setFinance_permit(String finance_permit) {
		this.finance_permit = finance_permit;
	}


	/**
	 * @return the report_permit
	 */
	public String getReport_permit() {
		return report_permit;
	}


	/**
	 * @param report_permit the report_permit to set
	 */
	public void setReport_permit(String report_permit) {
		this.report_permit = report_permit;
	}


	/**
	 * @return the user_permit
	 */
	public String getUser_permit() {
		return user_permit;
	}


	/**
	 * @param user_permit the user_permit to set
	 */
	public void setUser_permit(String user_permit) {
		this.user_permit = user_permit;
	}


	/**
	 * @return the networksale_permit
	 */
	public String getNetworksale_permit() {
		return networksale_permit;
	}


	/**
	 * @param networksale_permit the networksale_permit to set
	 */
	public void setNetworksale_permit(String networksale_permit) {
		this.networksale_permit = networksale_permit;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Admins [userid=" + userid + ", account=" + account + ", realname=" + realname + ", password=" + password
				+ ", createdate=" + createdate + ", lock_statu=" + lock_statu + ", po_permit=" + po_permit
				+ ", depot_permit=" + depot_permit + ", sale_permit=" + sale_permit + ", finance_permit="
				+ finance_permit + ", report_permit=" + report_permit + ", user_permit=" + user_permit
				+ ", networksale_permit=" + networksale_permit + ", manager_permit=" + manager_permit + "]";
	}


	/**
	 * @return the manager_permit
	 */
	public String getManager_permit() {
		return manager_permit;
	}


	/**
	 * @param manager_permit the manager_permit to set
	 */
	public void setManager_permit(String manager_permit) {
		this.manager_permit = manager_permit;
	}


	public Admins() {
		// TODO Auto-generated constructor stub
	}

}
