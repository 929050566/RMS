package com.aowin.scm.financemanage.dao;

import java.util.List;

import com.aowin.scm.financemanage.pojo.Finance;
import com.aowin.scm.financemanage.pojo.FinanceInfo;
import com.aowin.scm.purchasemanager.pojo.Purchase;
import com.aowin.scm.salemanage.pojo.SaleMangeModel;
import com.aowin.scm.utils.BaseDao;

public interface FinanceDao extends BaseDao{
	/**
	 * 添加一行采购单的收入记录
	 * @param 收支记录对象 finance
	 * @return  是否添加成功
	 */
	public boolean insertPurchase(Finance finance);
	public String FINANCE_INSERT_PURCHASE = "insert into finance (date,theway,handle,purchaseid) values (NOW(),?,?,?)";
	
	/**
	 * 添加一行销售单的支出记录
	 * @param 收支记录对象 finance
	 * @return  是否添加成功
	 */
	public boolean insertSale(Finance finance);
	public String FINANCE_INSERT_SALE = "insert into finance (date,theway,handle,salebillid) values (NOW(),?,?,?)";	
	
	/**
	 * 通过采购单编号 修改 采购单 状态为已付款
	 * @param purchaseid 采购单编号
	 * @return 是否修改成功
	 */
	public boolean updatePurchase(String purchaseid,String disposestate);
	public String PURCHASE_UPDATE_DISPOSESTATE = "update purchase set disposestate = ? where purchaseid = ? ";
	
	/**
	 * 通过 销售单编号 修改销售单状态为 已付款
	 * @param salebillid 销售单编号
	 * @return 是否修改成功
	 */
	public boolean updateSale(String salebillid,String disposestate);
	public String SALE_UPDATE_DISPOSESTATE = "update sale set disposestate = ? where salebillid = ? ";
	
	//=============================付款登记 
	/**
	 * 得到全部的可付款和预付的数据条数
	 * @return 条数
	 */
	public int getCountByCondition();
	public String PURCHASE_SELECT_COUNT_CONDITION = "select count(purchaseid) as total from purchase where (paystate = 1 and disposestate = 2) or (paystate = 2 and disposestate = 1) or (paystate = 3 and disposestate = 1) or (paystate = 3 and disposestate = 2) ";                      
	
	/**
	 * 得到全部的可付款和可预付的 采购单数据
	 * @param start 起始行
	 * @param size  行数
	 * @return 采购单集合List
	 */
	public List<Purchase> getListByCondition(int start,int size);
	public String PURCHASE_SELECT_LIST_CONDITION = "select *  from purchase where (paystate = 1 and disposestate = 2) or (paystate = 2 and disposestate = 1) or (paystate = 3 and disposestate = 1) or (paystate = 3 and disposestate = 2) order by purchaseid desc limit ?,? ";                      
	
	/**
	 * 通过付款状态 得到全部的可付款和可预付的 采购单数据 条数
	 * @param paystate 支付方式
	 * @return 条数
	 */
	public int getCountByConditionAndPaystate(String paystate);
	public String PURCHASE_SELECT_COUNT_CONDITION_PAYSTATE = "select count(purchaseid) as total from purchase where ((paystate = 1 and disposestate = 2) or (paystate = 2 and disposestate = 1) or (paystate = 3 and disposestate = 1) or (paystate = 3 and disposestate = 2)) and (paystate = ?) ";                      
	
	/**
	 * 通过付款状态 得到全部的可付款和可预付的 采购单数据
	 * @param start 起始行数
	 * @param size  行数
	 * @param paystate 付款状态
	 * @return  采购单集合 list
	 */
	public List<Purchase> getListByConditionAndPaystate(int start,int size,String paystate);
	public String PURCHASE_SELECT_LIST_CONDITION_PAYSTATE = "select * from purchase where ((paystate = 1 and disposestate = 2) or (paystate = 2 and disposestate = 1) or (paystate = 3 and disposestate = 1) or (paystate = 3 and disposestate = 2)) and (paystate = ?)  order by purchaseid desc limit ?,?";                      
	//==================================================收款登记
	/**
	 * 得到全部的可付款和预付的销售数据 条数
	 * @return 条数
	 */
	public int getCountByConditionSale();
	public String SALE_SELECT_COUNT_CONDITION = "select count(salebillid) as total from sale where (paystate = 1 and disposestate = 2) or (paystate = 2 and disposestate = 1) or (paystate = 3 and disposestate = 1) or (paystate = 3 and disposestate = 2) ";                      
	
	/**
	 * 得到全部的可付款和可预付的 销售单数据
	 * @param start 起始行
	 * @param size  行数
	 * @return 采购单集合List
	 */
	public List<SaleMangeModel> getListByConditionSale(int start,int size);
	public String SALE_SELECT_LIST_CONDITION = "select *  from sale where (paystate = 1 and disposestate = 2) or (paystate = 2 and disposestate = 1) or (paystate = 3 and disposestate = 1) or (paystate = 3 and disposestate = 2) order by salebillid desc limit ?,? ";                      
	
	/**
	 * 通过付款状态 得到全部的可付款和可预付的 销售单数据 条数
	 * @param paystate 支付方式
	 * @return 条数
	 */
	public int getCountByConditionAndPaystateSale(String paystate);
	public String SALE_SELECT_COUNT_CONDITION_PAYSTATE = "select count(salebillid) as total from sale where ((paystate = 1 and disposestate = 2) or (paystate = 2 and disposestate = 1) or (paystate = 3 and disposestate = 1) or (paystate = 3 and disposestate = 2)) and (paystate = ?) ";                      
	
	/**
	 * 通过付款状态 得到全部的可付款和可预付的 销售单数据
	 * @param start 起始行数
	 * @param size  行数
	 * @param paystate 付款状态
	 * @return  采购单集合 list
	 */
	public List<SaleMangeModel> getListByConditionAndPaystateSale(int start,int size,String paystate);
	public String SALE_SELECT_LIST_CONDITION_PAYSTATE = "select * from sale where ((paystate = 1 and disposestate = 2) or (paystate = 2 and disposestate = 1) or (paystate = 3 and disposestate = 1) or (paystate = 3 and disposestate = 2)) and (paystate = ?)  order by salebillid desc limit ?,?";                      
	
	/**
	 * 通过sql语句得到全部list
	 * @param sql语句
	 * @return FinanceInfo对象
	 */
	public List<FinanceInfo> getFinInfoListBySql(String sql);
	/**
	 * 通过sql 得到行数
	 * @param sql
	 * @return 行数
	 */
	public int getFinInfoCountBySql(String sql);
}
