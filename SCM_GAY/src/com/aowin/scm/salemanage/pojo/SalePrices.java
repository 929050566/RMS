/**
 * 
 */
package com.aowin.scm.salemanage.pojo;

/**
 * @author �����
 * ��Ʒ������ۼ۸����ϸ��Ϣ
 * date:2018��11��18�� ����2:42:31
 */
public class SalePrices {
	private int proid;
	private double prosaleprices;
	private String procommnet;
	/**
	 * 
	 */
	public SalePrices() {
		// TODO �Զ����ɵĹ��캯�����
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
