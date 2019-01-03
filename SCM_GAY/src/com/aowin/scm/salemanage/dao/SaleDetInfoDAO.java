/**
 * 
 */
package com.aowin.scm.salemanage.dao;

import java.util.List;

import com.aowin.scm.salemanage.pojo.Sale;
import com.aowin.scm.utils.BaseDao;

/**
 * @author 李小龙
 * date:2018年11月19日 下午11:50:49
 * 
 */
public interface SaleDetInfoDAO extends BaseDao {
	//获得所有的待出库基本数据信息
	public String SALE_CK_ALL_SQL = "select salebillid,createtime,customername,createname,extramoney,totalproprices,totalprices,paystate,advanceprice,disposestate from sale where (disposestate=1 and paystate=1) or (disposestate=3 and paystate=2) or (disposestate=5 and paystate=3) order by purchaseid desc limit ?,?";
	public List<Sale> getSaleByCondition(int page,int size);
	/**
	 * 查询所有待出库销售单总数
	 * @return 销售单总数
	 */
	public int getSaleCount();;
	public String SALE_SELECT__ACCOUNT = "select count(purchaseid) as total from purchase where (paystate = 1 and disposestate = 3) or (paystate = 2 and disposestate = 2) or (paystate = 3 and disposestate = 3) ";
	
}
