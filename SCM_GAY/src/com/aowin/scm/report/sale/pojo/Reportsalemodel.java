/**
 * 
 */
package com.aowin.scm.report.sale.pojo;

import java.io.Serializable;

/**
 * @author 葛金铭
 *	销售报表
 * date:2018年11月20日 下午4:27:40
 */
public class Reportsalemodel implements Serializable {

	/**
	 * 报表
	 * 销售单编号
	客户名称
	销售日期
	经手人
	销售单总金额
	未付款金额
	处理状态
	 */
	public Reportsalemodel() {
		// TODO 自动生成的构造函数存根
	}
	private String saleid;//销售单编号
	private String customername;//客户名称
	private String saletime;//销售日期即是销售表创建日期
	private String createsaleper;//经手人
	private float  totalsaleprice;//销售单总金额
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

