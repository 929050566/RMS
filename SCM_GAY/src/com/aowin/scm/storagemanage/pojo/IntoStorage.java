/**
 * 
 */
package com.aowin.scm.storagemanage.pojo;

import java.io.Serializable;


/** 
 * ���ǼǱ����������Ϣ ~���ģ��ҵ���߼�ʵ����
 * @author ��С��
 * date:2018��11��15�� ����10:07:08
 *
 */
 
 



public class IntoStorage implements Serializable {
	
	 private int inId;// ���id
	 private String inStorageDate;//���ʱ��(yyyy-mm-dd hh:mm:ss)',
	 private String inoHandle;// '��⾭����',
	 private int inNum;// '�������',
	 private String inState;// '������ͣ�1:�ֲɹ�����3:�̵���⣩',
	 private String Reason;// '����ԭ��',
	 private int purchase_detid;// '��زɹ���ϸ����',
	 private String purchaseid;// �ɹ�����
	 private int proId;
	 
	 
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
	 * 
	 */
	public IntoStorage() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the inId
	 */
	public int getInId() {
		return inId;
	}

	/**
	 * @param inId the inId to set
	 */
	public void setInId(int inId) {
		this.inId = inId;
	}

	/**
	 * @return the inStorageDate
	 */
	public String getInStorageDate() {
		return inStorageDate;
	}

	/**
	 * @param inStorageDate the inStorageDate to set
	 */
	public void setInStorageDate(String inStorageDate) {
		this.inStorageDate = inStorageDate;
	}

	/**
	 * @return the inoHandle
	 */
	public String getInoHandle() {
		return inoHandle;
	}

	/**
	 * @param inoHandle the inoHandle to set
	 */
	public void setInoHandle(String inoHandle) {
		this.inoHandle = inoHandle;
	}

	/**
	 * @return the inNum
	 */
	public int getInNum() {
		return inNum;
	}

	/**
	 * @param inNum the inNum to set
	 */
	public void setInNum(int inNum) {
		this.inNum = inNum;
	}

	/**
	 * @return the inState
	 */
	public String getInState() {
		return inState;
	}

	/**
	 * @param inState the inState to set
	 */
	public void setInState(String inState) {
		this.inState = inState;
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
	 * @return the purchase_detid
	 */
	public int getPurchase_detid() {
		return purchase_detid;
	}

	/**
	 * @param purchase_detid the purchase_detid to set
	 */
	public void setPurchase_detid(int purchase_detid) {
		this.purchase_detid = purchase_detid;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IntoStorage [inId=" + inId + ", inStorageDate=" + inStorageDate + ", inoHandle=" + inoHandle
				+ ", inNum=" + inNum + ", inState=" + inState + ", Reason=" + Reason + ", purchase_detid="
				+ purchase_detid + ", purchaseid=" + purchaseid + ", proId=" + proId + "]";
	}


	

}
