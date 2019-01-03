package com.aowin.scm.report.pur.dao;



import java.util.List;

import com.aowin.scm.report.pur.pojo.Report;
import com.aowin.scm.utils.BaseDao;

/**
 * @author 骆俊杰
 *date:2018年11月20日 下午6:54:31
 * 
 */
public interface ReportDao extends BaseDao {
	
	/**
	 * 获取采购单总记录数
	 */
	public String PURCHASE_SELECT_COUNT_SQL = "select count(purchaseid) total from purchase";
	/**
	 * 获取已了结的采购单记录数
	 */
	public String PURCHASE_SELECT_COUNT_SQL_BY_DISPOSESTATE = "select count(purchaseid) total from purchase where disposestate=4";
	/**
	 * 查询所有采购单总价
	 */
	public String PURCHASE_SELECT_ALLTOTALPRICESE_SQL = "select totalprices from purchase";
	/**
	 * 查询处理状态为已付款和已了结的采购单总价
	 */
	public String PURCHASE_SELECT_TOTALPRICESE_BY_DISPOSESTATA_SQL = "select totalprices from purchase where disposestate=3 or disposestate=4";
	/**
	 * 查询处理状态为已付款和已了结的采购单总价
	 */
	public String PURCHASE_SELECT_ADVANCEPRICESE_BY_DISPOSESTATA_SQL = "select advanceprice from purchase where disposestate=5";
	/**
	 * 分页查询采购单信息
	 */
	public String PURCHASE_SELECT_ALL_SQL = "select purchaseid,createtime,suppliername,createname,advanceprice,totalprices,paystate,disposestate from purchase order by purchaseid desc limit ?,?";
	/**
	 * 获得数据的总行数
	 * @return 数据的总行数
	 */
	public int getTotalLines();
	/**
	 * 获得以了解数据的总行数
	 * @return 以了解数据的总行数
	 */
	public int getTotalLinesBydisposestate();
	/**
	 * 得到所有采购单总价
	 * @return 采购单总价集合
	 */
	public List<Float> gettotalprices();
	/**
	 * 得到所有状态为已付款和已了结的采购单总价
	 * @return 采购单总价集合
	 */
	public List<Float> gettotalpricesBydisposestate();
	/**
	 * 得到所有状态为已预付的采购单预付款
	 * @return 采购单预付款集合
	 */
	public List<Float> getadvancepriceBydisposestate();
	/**
	 * 分页显示采购单信息
	 * @param page 当前页
	 * @param size 每页显示行数
	 * @return Report集合
	 */
	public List<Report> getReport(int page,int size);
	/**
	 * 获取总页数
	 * @param pagesize 每页显示行数
	 * @return 总页数
	 */
	public int getTotalPages(int pagesize);
	/**
	 * 通过sql语句 查询采购单集合
	 * @param sql语句
	 * @return 查询采购单集合
	 */
	public List<Report> getReportBySql(String sql);
	
}
