package com.aowin.scm.financemanage.pojo;

public class Finance {
	
	private int propertyid;
	private String date;
	private String theway;
	private String handle;
	private String purchaseid;
	private String salebillid;
	
	
	/**
	 * @return the propertyid
	 */
	public int getPropertyid() {
		return propertyid;
	}


	/**
	 * @param propertyid the propertyid to set
	 */
	public void setPropertyid(int propertyid) {
		this.propertyid = propertyid;
	}


	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}


	/**
	 * @return the theway
	 */
	public String getTheway() {
		return theway;
	}


	/**
	 * @param theway the theway to set
	 */
	public void setTheway(String theway) {
		this.theway = theway;
	}


	/**
	 * @return the handle
	 */
	public String getHandle() {
		return handle;
	}


	/**
	 * @param handle the handle to set
	 */
	public void setHandle(String handle) {
		this.handle = handle;
	}


	/**
	 * @return the purchaseid
	 */
	public String getPurchaseid() {
		return purchaseid;
	}


	/**
	 * @param purchaseid the purchaseid to set
	 */
	public void setPurchaseid(String purchaseid) {
		this.purchaseid = purchaseid;
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
		return "Finance [propertyid=" + propertyid + ", date=" + date + ", theway=" + theway + ", handle=" + handle
				+ ", purchaseid=" + purchaseid + ", salebillid=" + salebillid + "]";
	}


	public Finance() {
		// TODO Auto-generated constructor stub
	}

}
