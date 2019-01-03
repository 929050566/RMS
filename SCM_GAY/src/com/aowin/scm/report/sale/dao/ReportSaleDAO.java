/**
 * 
 */
package com.aowin.scm.report.sale.dao;

import java.util.ArrayList;

import com.aowin.scm.report.sale.pojo.Reportsalemodel;
import com.aowin.scm.utils.BaseDao;

/**
 * @author 葛金铭
 *
 * date:2018年11月20日 下午4:43:54
 */
public interface ReportSaleDAO extends BaseDao {
	/**
	 * 获得数据库中的销售信息
	 * 报表使用
	 */
	public String GET_REPORT_SALE_SQL ="select count(salebillid) total from sale";

	/**
	 *   获得数据库销售表数量
	 */
	public int getsalenum();
	
	/**
	 * 获得数据库已了结数量
	 */
	public String GET_REPORT_ENDSALE_SQL ="select count(salebillid) total from sale where disposestate=4";
	
	/**
	 * 获得数据库已了结数量
	 */
	public int getsaleendnum();
	/**
	 *得到销售表内容的详细信息
	 */
	public String GET_SALEDET_ALLMANAGE ="select salebillid,createtime,customername,createname,extramoney,totalproprices,advanceprice,totalprices,paystate,closeDate,closeUser,comment,disposestate from sale";
	/**
	 * 分页销售表
	 */
	public String GET_SALEDET_PAGEMANAGE ="select salebillid,createtime,customername,createname,extramoney,totalproprices,advanceprice,totalprices,paystate,closeDate,closeUser,comment,disposestate from sale order by salebillid desc limit ?,?";
	
	/**
	 * 
	 * @param page
	 * @param 一页显示的数量
	 * @return
	 */
	public ArrayList<Reportsalemodel> getallsale(int page,int size);
}
