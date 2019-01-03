/**
 * 
 */
package com.aowin.scm.salemanage.pojo;

/**
 * @author 葛金铭
 * 产品表的销售价格和详细信息
 * date:2018年11月18日 下午2:42:31
 */
public class SalePrices {
	private int proid;
	private double prosaleprices;
	private String procommnet;
	/**
	 * 
	 */
	public SalePrices() {
		// TODO 自动生成的构造函数存根
	}
	
	public int getProid() {
		return proid;
	}

	public void setProid(int proid) {
		this.proid = proid;
	}

	public double getProsaleprices() {
		return prosaleprices;
	}
	public void setProsaleprices(double prosaleprices) {
		this.prosaleprices = prosaleprices;
	}
	public String getProcommnet() {
		return procommnet;
	}
	public void setProcommnet(String procommnet) {
		this.procommnet = procommnet;
	}

	@Override
	public String toString() {
		return "SalePrices [proid=" + proid + ", prosaleprices=" + prosaleprices + ", procommnet=" + procommnet + "]";
	}
	
}
