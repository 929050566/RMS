/**
 * 
 */
package com.aowin.scm.salemanage.dao;

import java.util.List;

import com.aowin.scm.salemanage.pojo.Sale;
import com.aowin.scm.salemanage.pojo.SaleDet;
import com.aowin.scm.utils.BaseDao;

/**
 * @author ��С��
 * date:2018��11��20�� ����6:14:28
 * 
 */
public interface SaleDAO extends BaseDao {
	
		/** 
		 * ������еĴ��������������Ϣ
		 */
		public List<Sale> getSaleByCondition(int page,int size);
		public String SALE_CK_ALL_SQL = "select salebillid,createtime,customername,createname,extramoney,totalproprices,totalprices,paystate,advanceprice,disposestate from sale where (disposestate=1 and paystate=1) or (disposestate=3 and paystate=2) or (disposestate=5 and paystate=3) order by salebillid desc limit ?,?";
		
		/**
		 * ��ѯ���д��������۵�����
		 * @return ���۵�����
		 */
		public int getSaleCount();;
		public String SALE_SELECT__ACCOUNT = "select count(salebillid) as total from sale where (paystate = 1 and disposestate = 1) or (paystate = 2 and disposestate = 3) or (paystate = 3 and disposestate = 5) ";
		 
		/** 
		 * 
		 * @param page
		 * @param size
		 * @return ���Ӧ֧�����������������Ϣ
		 */
		public List<Sale> getSaleByState(int page,int size,String paystate);
		public String SALE_CK_SELECTBYSTATE_SQL = "select salebillid,createtime,customername,createname,extramoney,totalproprices,totalprices,paystate,advanceprice,disposestate from sale where ((disposestate=1 and paystate=1) or (disposestate=3 and paystate=2) or (disposestate=5 and paystate=3))and paystate=? order by salebillid desc limit ?,?";
		/**
		 * ��ѯ���д��������۵�����
		 * @return ���۵�����
		 */
		public int getSaleStateCount(String paystate);;
		public String SALE_SELECTBYSTATE__ACCOUNT = "select count(salebillid) as total from sale where ((disposestate = 1 and paystate=1) or (disposestate=3 and paystate=2) or (disposestate=5 and paystate=3)) and paystate=?";
		
		/** 
		 * �������۵����޸����۱�Ĵ���״̬
		 * @param salebillid
		 * @return
		 */
		public boolean updaid(String salebillid,String disposestate);
		public String SALEDET_UPDASELECTBY_SQL ="update sale set disposestate=? where salebillid=?"; 
		
		/** 
		 * �������۵����ڲ�Ʒ��ϸ���ѯ��һϵ���ڵĲ�Ʒ����
		 */
		public String SALEDET_PROIDSELECT_SQL = "select proid,pronum,detid from sale_det where salebillid=?";
		/** 
		 * �������۵����ڲ�Ʒ��ϸ���ѯ��һϵ���ڵĲ�Ʒ����
		 * @param saleid
		 * @return
		 */
		public List<SaleDet> getproid(String saleid);
		
		
}
