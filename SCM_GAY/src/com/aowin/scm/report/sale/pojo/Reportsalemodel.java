/**
 * 
 */
package com.aowin.scm.report.sale.pojo;

import java.io.Serializable;

/**
 * @author �����
 *	���۱���
 * date:2018��11��20�� ����4:27:40
 */
public class Reportsalemodel implements Serializable {

	/**
	 * ����
	 * ���۵����
	�ͻ�����
	��������
	������
	���۵��ܽ��
	δ������
	����״̬
	 */
	public Reportsalemodel() {
		// TODO �Զ����ɵĹ��캯�����
	}
	private String saleid;//���۵����
	private String customername;//�ͻ�����
	private String saletime;//�������ڼ������۱�������
	private String createsaleper;//������
	private float  totalsaleprice;//���۵��ܽ��
	private float  notpayprice;
	private String paystate;
	private String disposestate;

	public String getSaleid() {
		return saleid;
	}
	public void setSaleid(String saleid) {
		this.saleid = saleid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getSaletime() {
		return saletime;
	}
	public void setSaletime(String saletime) {
		this.saletime = saletime;
	}
	public String getCreatesaleper() {
		return createsaleper;
	}
	public void setCreatesaleper(String createsaleper) {
		this.createsaleper = createsaleper;
	}
	public float getTotalsaleprice() {
		return totalsaleprice;
	}
	public void setTotalsaleprice(float totalsaleprice) {
		this.totalsaleprice = totalsaleprice;
	}
	public float getNotpayprice() {
		return notpayprice;
	}
	public void setNotpayprice(float notpayprice) {
		this.notpayprice = notpayprice;
	}
	public String getPaystate() {
		return paystate;
	}
	public void setPaystate(String paystate) {
		this.paystate = paystate;
	}
	public String getDisposestate() {
		return disposestate;
	}
	public void setDisposestate(String disposestate) {
		this.disposestate = disposestate;
	}
	@Override
	public String toString() {
		return "Reportsalemodel [saleid=" + saleid + ", customername=" + customername + ", saletime=" + saletime
				+ ", createsaleper=" + createsaleper + ", totalsaleprice=" + totalsaleprice + ", notpayprice="
				+ notpayprice + ", paystate=" + paystate + ", disposestate=" + disposestate + "]";
	}
	
}

