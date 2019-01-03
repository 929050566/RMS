package com.aowin.scm.salemanage.dao;

import java.util.ArrayList;
import java.util.List;

import com.aowin.scm.salemanage.pojo.FinanceSaleModel;
import com.aowin.scm.salemanage.pojo.OutstorageSaleModel;
import com.aowin.scm.salemanage.pojo.SaleAllInfo;
import com.aowin.scm.salemanage.pojo.SaleManageDetModel;
import com.aowin.scm.salemanage.pojo.SaleMangeModel;
import com.aowin.scm.utils.BaseDao;

public interface SaleManageDAO extends BaseDao {
	/**
	 *得到销售表内容的详细信息
	 */
	public String GET_SALEDET_ALLMANAGE ="select salebillid,createtime,customername,createname,extramoney,totalproprices,advanceprice,totalprices,paystate,closeDate,closeUser,comment,disposestate from sale where salebillid = ?";
	/**
	 * 得到销售表内容的详细信息方法
	 */
	public SaleMangeModel getsaleByid(int saleid);
	
	/**
	 * 添加销售表
	 */
	public String INSERT_SALE_SQL ="insert into sale(salebillid,createtime,customername,createname,extramoney,totalproprices,paystate,advanceprice,totalprices,comment,disposestate) values (?,NOW(),?,?,?,?,?,?,?,?,'1')";
	/**
	 * 添加销售表
	 * @return
	 */
	public boolean insertsale(SaleMangeModel sale);
	
	/**
	 *获得销售详表SQL语句
	 */
	public String GET_SALEDET_BYSALEID_SQL ="select detid,proid,proname,pronum,prounit,unitprice,totalprice,salebillid from sale_det where salebillid = ?";
	
	/**
	 * 获得销售详表的方法
	 * @param sale_id
	 * @return
	 */
	public ArrayList<SaleManageDetModel> getsale_det(String salebillid);
	public String SALEDET_SELECT_SALEID = "select * from sale_det where salebillid = ?";
	/**
	 * 获得所有的销售表分页显示
	 */
	public String GET_SALE_FOREND_SQL ="select salebillid,createtime,customername,createname,extramoney,totalproprices,advanceprice,totalprices,paystate,closeDate,closeUser,comment,disposestate from sale limit ?,?";
	
	/**
	 * page 第几行0开始‘
	 * pa 第几页
	 */
	public ArrayList<SaleMangeModel> getsale(int page,int pa);
	
	/**
	 * 查询客户的信息
	 */
	public String GET_CUSTOMER_BYID_SQL ="select customerid,account,password,customername,callman,adress,postnumber,logindate,phone,fax from customer where customerid = ?";
	/**
	 * 查询客户的信息方法
	 */
	public String getCustomer(int customerid);
	
	/**
	 * 查询出库数据库中出库信息
	 */
	public String GETMANG_OUTSTORAGE_SALEMODE_SQL ="select outId,outStorageDate,outHandle,outNum,outState,Reason,sale_detid,salebillid from outstorage where salebillid = ?";
	/**
	 * 查询出库数据库中出库信息方法
	 */
	public OutstorageSaleModel getOutstorageForSale(int saleid);
	/**
	 * 查询数据库财务表内的信息
	 */
	public String GET_FINANCE_SALEMODE_SQL ="select propertyId,date,theway,handle,purchaseid,salebillid from finance where salebillid = ?";
	/**
	 * 查询数据库财务表内的信息方法
	 */
	public FinanceSaleModel getFinaceSale(int saleid);
	/**
	 * 根据销售表ID向销售详情表添加
	 */
	public String INSERT_SALEDEL_BYSALEID_SQL ="insert into sale_det (proid,proname,pronum,prounit,unitprice,totalprice,salebillid) values (?,?,?,?,?,?,?)";
	
	/**
	 * 根据销售表ID向销售详情表添加
	 */
	public boolean insertsaledel(SaleManageDetModel saledel);
	
	
	//====张豪：销售了结
	/**
	 * 得到全部的可付款和预付的销售数据 条数
	 * @return 条数
	 */
	public int getCountByConditionSale();
	public String SALE_SELECT_COUNT_CONDITION = "select count(salebillid) as total from sale where (paystate = 1 and disposestate = 3) or (paystate = 2 and disposestate = 2) or (paystate = 3 and disposestate = 3) ";                      
	
	/**
	 * 得到全部的可付款和可预付的 销售单数据
	 * @param start 起始行
	 * @param size  行数
	 * @return 采购单集合List
	 */
	public List<SaleMangeModel> getListByConditionSale(int start,int size);
	public String SALE_SELECT_LIST_CONDITION = "select *  from sale where (paystate = 1 and disposestate = 3) or (paystate = 2 and disposestate = 2) or (paystate = 3 and disposestate =3)  order by salebillid desc limit ?,? ";                      
	
	/**
	 * 通过付款状态 得到全部的可付款和可预付的 销售单数据 条数
	 * @param paystate 支付方式
	 * @return 条数
	 */
	public int getCountByConditionAndPaystateSale(String paystate);
	public String SALE_SELECT_COUNT_CONDITION_PAYSTATE = "select count(salebillid) as total from sale where ((paystate = 1 and disposestate = 3) or (paystate = 2 and disposestate = 2) or (paystate = 3 and disposestate =3) ) and (paystate = ?) ";                      
	
	/**
	 * 通过付款状态 得到全部的可付款和可预付的 销售单数据
	 * @param start 起始行数
	 * @param size  行数
	 * @param paystate 付款状态
	 * @return  采购单集合 list
	 */
	public List<SaleMangeModel> getListByConditionAndPaystateSale(int start,int size,String paystate);
	public String SALE_SELECT_LIST_CONDITION_PAYSTATE = "select * from sale where ((paystate = 1 and disposestate = 3) or (paystate = 2 and disposestate = 2) or (paystate = 3 and disposestate =3) ) and (paystate = ?)  order by salebillid desc limit ?,?";                      
	
	/**
	 * 通过销售单编号 修改销售单状态
	 * @param salebillid 销售单编号
	 * @param disposestate 销售单状态
	 * @return 是否修改成功 boolean
	 */
	public boolean updateDisposestate(String salebillid,String disposestate,String username);
	public String SALE_UPDATE_DISPOSESTATE = "update sale set disposestate = ?,closeDate=NOW(),closeUser=? where salebillid = ?";
	
	/**
	 * 通过sql语句得到查询出的销售单的 数量
	 * @param sql语句
	 * @return 查询出的数量int
	 */
	public int getCountBySql(String sql);
	
	/**
	 * 通过sql语句得到查询虎的销售单集合
	 * @param sql语句
	 * @return 销售单集合list
	 */
	public List<SaleMangeModel> getListBySql(String sql);
	
	/**
	 * 得到所有销售单中的客户名称
	 */
	public List<String> getAllCustomerName();
	public String SALE_SELECT_CUSTOMERNAME = "select customername from sale";
	
	/**
	 * 通过销售单编号删除销售单
	 * @param salebillid销售单编号
	 * @return 是否删除成功
	 */
	public boolean deleteSale(String salebillid);
	String SALE_DELETE_SALEBILLID  = "delete from sale where salebillid  = ?";
	/**
	 * 通过销售单编号删除销售明细
	 * @param salebillid销售单编号
 	 * @return 是否删除成功
	 */
	public boolean deleteSaleDet(String salebillid);
	String SALEDET_DELETE_SALEBILLID = "delete from sale_det where salebillid = ? ";
	
	/**
	 * 通过销售单编号得到 销售单相关所有信息
	 * @param salebillid  销售单编号
	 * @return  SaleAllInfo集合 
	 */
	public SaleAllInfo getSaleAllInfoBySaleid(String salebillid);
	public String SALEALLINFO_SELECT_SALEID = "select * from sale left join outstorage on sale.salebillid = outstorage.salebillid left join finance on sale.salebillid = finance.salebillid where sale.salebillid = ?";
	
	/**
	 * 修改产品表 
	 * @param sale产品表对象
	 * @return 是否修改成功
	 */
	public boolean updateSale(SaleMangeModel sale);
	public String  SALE_UPDATE_SALEMODEL = "update sale set paystate=?,extramoney=?,totalproprices=?,totalproprices=?,totalprices=?,comment=?,disposestate=? where  salebillid = ?";
	
	/**
	 * 修改产品明细表
	 * @param saleDet  产品明细对象
	 * @return 是否修改成功
	 */
	public boolean updateSaleDet(SaleManageDetModel saleDet);
	public String SALEDET_UPDATE_SALEDETMODEL = "update sale_det set pronum = ?,unitprice= ?,totalprice=? where detid = ?";
	
	public boolean deleteSaleDetByDetid(int detid);
	public String SALEDET_DELETE_DETID = "delete from sale_det where detid = ?";
}
