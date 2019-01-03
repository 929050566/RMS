/**
 * 
 */
package com.aowin.scm.salemanage.dao;

import java.util.List;

import com.aowin.scm.salemanage.pojo.Sale;
import com.aowin.scm.utils.BaseDao;

/**
 * @author ��С��
 * date:2018��11��19�� ����11:50:49
 * 
 */
public interface SaleDetInfoDAO extends BaseDao {
	//������еĴ��������������Ϣ
	public String SALE_CK_ALL_SQL = "select salebillid,createtime,customername,createname,extramoney,totalproprices,totalprices,paystate,advanceprice,disposestate from sale where (disposestate=1 and paystate=1) or (disposestate=3 and paystate=2) or (disposestate=5 and paystate=3) order by purchaseid desc limit ?,?";
	public List<Sale> getSaleByCondition(int page,int size);
	/**
	 * ��ѯ���д��������۵�����
	 * @return ���۵�����
	 */
	public int getSaleCount();;
	public String SALE_SELECT__ACCOUNT = "select count(purchaseid) as total from purchase where (paystate = 1 and disposestate = 3) or (paystate = 2 and disposestate = 2) or (paystate = 3 and disposestate = 3) ";
	
}
