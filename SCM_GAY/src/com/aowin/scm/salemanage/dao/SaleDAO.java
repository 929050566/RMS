/**
 * 
 */
package com.aowin.scm.salemanage.dao;

import java.util.List;

import com.aowin.scm.salemanage.pojo.Sale;
import com.aowin.scm.salemanage.pojo.SaleDet;
import com.aowin.scm.utils.BaseDao;

/**
 * @author 李小龙
 * date:2018年11月20日 上午6:14:28
 * 
 */
public interface SaleDAO extends BaseDao {
	
		/** 
		 * 获得所有的待出库基本数据信息
		 */
		public List<Sale> getSaleByCondition(int page,int size);
		public String SALE_CK_ALL_SQL = "select salebillid,createtime,customername,createname,extramoney,totalproprices,totalprices,paystate,advanceprice,disposestate from sale where (disposestate=1 and paystate=1) or (disposestate=3 and paystate=2) or (disposestate=5 and paystate=3) order by salebillid desc limit ?,?";
		
		/**
		 * 查询所有待出库销售单总数
		 * @return 销售单总数
		 */
		public int getSaleCount();;
		public String SALE_SELECT__ACCOUNT = "select count(salebillid) as total from sale where (paystate = 1 and disposestate = 1) or (paystate = 2 and disposestate = 3) or (paystate = 3 and disposestate = 5) ";
		 
		/** 
		 * 
		 * @param page
		 * @param size
		 * @return 获对应支付待出库基本数据信息
		 */
		public List<Sale> getSaleByState(int page,int size,String paystate);
		public String SALE_CK_SELECTBYSTATE_SQL = "select salebillid,createtime,customername,createname,extramoney,totalproprices,totalprices,paystate,advanceprice,disposestate from sale where ((disposestate=1 and paystate=1) or (disposestate=3 and paystate=2) or (disposestate=5 and paystate=3))and paystate=? order by salebillid desc limit ?,?";
		/**
		 * 查询所有待出库销售单总数
		 * @return 销售单总数
		 */
		public int getSaleStateCount(String paystate);;
		public String SALE_SELECTBYSTATE__ACCOUNT = "select count(salebillid) as total from sale where ((disposestate = 1 and paystate=1) or (disposestate=3 and paystate=2) or (disposestate=5 and paystate=3)) and paystate=?";
		
		/** 
		 * 根据销售单号修改销售表的处理状态
		 * @param salebillid
		 * @return
		 */
		public boolean updaid(String salebillid,String disposestate);
		public String SALEDET_UPDASELECTBY_SQL ="update sale set disposestate=? where salebillid=?"; 
		
		/** 
		 * 根据销售单号在产品明细表查询了一系列内的产品集合
		 */
		public String SALEDET_PROIDSELECT_SQL = "select proid,pronum,detid from sale_det where salebillid=?";
		/** 
		 * 根据销售单号在产品明细表查询了一系列内的产品集合
		 * @param saleid
		 * @return
		 */
		public List<SaleDet> getproid(String saleid);
		
		
}
