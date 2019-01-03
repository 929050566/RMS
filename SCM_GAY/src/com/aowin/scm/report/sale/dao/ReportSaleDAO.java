/**
 * 
 */
package com.aowin.scm.report.sale.dao;

import java.util.ArrayList;

import com.aowin.scm.report.sale.pojo.Reportsalemodel;
import com.aowin.scm.utils.BaseDao;

/**
 * @author �����
 *
 * date:2018��11��20�� ����4:43:54
 */
public interface ReportSaleDAO extends BaseDao {
	/**
	 * ������ݿ��е�������Ϣ
	 * ����ʹ��
	 */
	public String GET_REPORT_SALE_SQL ="select count(salebillid) total from sale";

	/**
	 *   ������ݿ����۱�����
	 */
	public int getsalenum();
	
	/**
	 * ������ݿ����˽�����
	 */
	public String GET_REPORT_ENDSALE_SQL ="select count(salebillid) total from sale where disposestate=4";
	
	/**
	 * ������ݿ����˽�����
	 */
	public int getsaleendnum();
	/**
	 *�õ����۱����ݵ���ϸ��Ϣ
	 */
	public String GET_SALEDET_ALLMANAGE ="select salebillid,createtime,customername,createname,extramoney,totalproprices,advanceprice,totalprices,paystate,closeDate,closeUser,comment,disposestate from sale";
	/**
	 * ��ҳ���۱�
	 */
	public String GET_SALEDET_PAGEMANAGE ="select salebillid,createtime,customername,createname,extramoney,totalproprices,advanceprice,totalprices,paystate,closeDate,closeUser,comment,disposestate from sale order by salebillid desc limit ?,?";
	
	/**
	 * 
	 * @param page
	 * @param һҳ��ʾ������
	 * @return
	 */
	public ArrayList<Reportsalemodel> getallsale(int page,int size);
}
