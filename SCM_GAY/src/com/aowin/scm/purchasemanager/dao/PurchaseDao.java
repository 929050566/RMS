package com.aowin.scm.purchasemanager.dao;

import java.util.List;

import com.aowin.scm.purchasemanager.pojo.Purchase;
import com.aowin.scm.purchasemanager.pojo.PurchaseAllInfo;
import com.aowin.scm.purchasemanager.pojo.PurchaseDet;
import com.aowin.scm.utils.BaseDao;

/**
 * @author 骆俊杰
 *date:2018年11月15日 下午12:13:24
 * 
 */
public interface PurchaseDao extends BaseDao {

	/**
	 * 添加采购单信息
	 */
	public String PURCHASE_INSERT_SQL = "insert into purchase(purchaseid,createtime,suppliername,createname,extramoney,totalproprices,advanceprice,totalprices,paystate,comment,disposestate) values (?,?,?,?,?,?,?,?,?,?,?)";
	/**
	 *根据purchaseid删除采购单信息
	 */
	public String PURCHASE_DELETE_SQL="delete from purchase where purchaseid=?";
	/**
	 *根据purchaseid修改采购单信息
	 */
	public String PURCHASE_UPDATE_SQL="update purchase set createtime=?,suppliername=?,createname=?,extramoney=?,totalproprices=?,advanceprice=?,totalprices=?,paystate=?,comment=?,closeDate=?,closeUser=?,disposestate=? where purchaseid=?";
	/**
	 * 分页查询采购单信息
	 */
	public String PURCHASE_SELECT_ALL_SQL = "select purchaseid,createtime,suppliername,createname,extramoney,totalproprices,advanceprice,totalprices,paystate,comment,closeDate,closeUser,disposestate from purchase order by purchaseid desc limit ?,?";
	/**
	 * 获取采购单总记录数
	 */
	public String PURCHASE_SELECT_COUNT_SQL = "select count(purchaseid) total from purchase";
	
	
	/**
	 * 添加采购单信息
	 * @param 采购单基本信息
	 * @return 是否添加成功
	 * */
	public boolean insertPurchase(Purchase purchase);
	/**
	 * 根据采购单编号删除采购单
	 * @param 采购单编号
	 * @return 是否删除成功
	 * */
	public boolean deletePurchaseid(String purchaseid);
	
	/**
	 * 修改采购单信息
	 * @param 采购单基本信息
	* @return 是否修改成功
	 */
	public boolean updatePurchase(Purchase purchase);
	/**
	 * 修改采购单处理状态
	 * @param 采购单编号 采购单处理状态
	* @return 是否修改成功
	 */
	public boolean updateDisposestate(String purchaseid,String disposestate,String closeUser);
	public String PURCHASE_UPDATE_DISPOSESTATE = "update purchase set disposestate = ?, closeDate=current_date(),closeUser=? where purchaseid = ?";
	/**
	 * 分页显示采购单信息
	 * @param pages 当前页
	 * @param pagesize 每页显示行数
	 * @return Purchase集合
	 */
	public List<Purchase> getSupplier(int pages,int pagesize);
	
	//=================================================
	/**
	 * 获得数据的总行数
	 * @return 数据的总行数
	 */
	public int getTotalLines();
	/**
	 * 通过sql语句 获取行数
	 * @param sql语句
	 * @return 行数
	 */
	public int getTotalLinesBySql(String sql);
	
	/**
	 * 通过sql语句 查询采购单集合
	 * @param sql语句
	 * @return 查询采购单集合
	 */
	public List<Purchase> getPurchaseBySql(String sql);
	/**
	 * 查询出可了结的采购单
	 * @return 返回可了结的采购单
	 */
	public List<Purchase> getPurchaseByCondition(int page,int size);
	public String PURCHASE_SELECT_FRO_FINISH = "select * from purchase where (paystate = 1 and disposestate = 3) or (paystate = 2 and disposestate = 2) or (paystate = 3 and disposestate = 3) order by purchaseid desc limit ?,?";
	
	/**
	 * 查询所有可了结的采购单总数
	 * @return 可了结采购单总数
	 */
	public int getPurchaseCount();;
	public String PURCHASE_SELECT_FRO_FINISH_ACCOUNT = "select count(purchaseid) as total from purchase where (paystate = 1 and disposestate = 3) or (paystate = 2 and disposestate = 2) or (paystate = 3 and disposestate = 3) ";
	
	/**
	 * 通过付款方式查询所有可了结的采购单总数
	 * @return 可了结采购单总数
	 */
	public  List<Purchase> getPurchaseConditionByPaystate(int page,int size,String paystate);
	public String PURCHASE_SELECT_FRO_FINISH_BY_PAYSTATE = "select * from purchase where ((paystate = 1 and disposestate = 3) or (paystate = 2 and disposestate = 2) or (paystate = 3 and disposestate = 3)) and( paystate = ?) order by purchaseid desc limit ?,?";
	
	/**
	 * 通过付款方式查询所有可了结的采购单总数数量
	 * @return 该处理转态下可了解单总数属性
	 */
	public  int getPurchaseConditionCountByPaystate(String paystate);
	public String PURCHASE_SELECT_FOR_FINISH_ACCOUNT_PAYSTATE = "select count(purchaseid) as total from purchase where ((paystate = 1 and disposestate = 3) or (paystate = 2 and disposestate = 2) or (paystate = 3 and disposestate = 3)) and( paystate = ?) ";
		
	/**
	 * 通过Purchaseid 得到 PurchaseAllInfo 
	 * @param purchaseid
	 * @return 返回采购单相关联全部信息
	 */
	public  PurchaseAllInfo getPurPurchaseAllInfoByPurchaseid(String purchaseid);
	
	//======小龙======小龙======小龙======小龙======小龙======小龙======小龙======小龙======小龙======小龙
	/** 
	 * 获得所有待入库的采购单基本数据信息
	 */
	public String PURCHASE_RK_ALL_SQL = "select purchaseid,createtime,suppliername,createname,extramoney,totalproprices,totalprices,paystate,advanceprice,disposestate from Purchase where (disposestate=1 and paystate=1) or (disposestate=3 and paystate=2) or (disposestate=5 and paystate=3) order by purchaseid desc limit ?,?";
	/** 
	 * 1：货到付款 
	 */
	public String PURCHASE_HD_ALL_SQL ="select purchaseid,createtime,suppliername,createname,extramoney,totalproprices,totalprices,paystate,advanceprice,disposestate from Purchase where disposestate=1 and paystate=1 order by purchaseid desc limit ?,?";
	/** 
	 * 2：款到发货 
	 */
	public String PURCHASE_KD_ALL_SQL ="select purchaseid,createtime,suppliername,createname,extramoney,totalproprices,totalprices,paystate,advanceprice,disposestate from Purchase where disposestate=3 and paystate=2 order by purchaseid desc limit ?,?";
	/** 
	 * 3：预付款到发货
	 */
	public String PURCHASE_YF_ALL_SQL ="select purchaseid,createtime,suppliername,createname,extramoney,totalproprices,totalprices,paystate,advanceprice,disposestate from Purchase where disposestate=5 and paystate=3 order by purchaseid desc limit ?,?";
	/** 
	 * 根据采购单号修改采购表处理状态 
	 */
	public String PURCHASE_UPDA_SQL = "update Purchase set disposestate=? where purchaseid=? ";
	/** 
	 * 获得所有待入库的采购单基本数据信息
	 * 分页查询盘点库存信息
	 * @param pages 当前页
	 * @param pagesize 每页显示行数
	 * @return Purchase集合
	 */
	public List<Purchase> getPurchaseBYDisposestate(int pages,int pagesize);
	/**
	 * 获取库存盘点总页数
	 * @param pagesize 每页显示行数
	 * @return 总页数
	 */
	public int getPurchaseAllTotalPages(int pagesize);
	public int getALL(int pagesize);
	
	/** 
	 * 获得货到付款 的所有采购单基本数据信息
	 * 分页查询盘点库存信息
	 * @param pages 当前页
	 * @param pagesize 每页显示行数
	 * @return Purchase集合
	 */
	public List<Purchase> getPurchaseBYPaystate1(int pages,int pagesize);
	/**
	 * 获取库存盘点总页数
	 * @param pagesize 每页显示行数
	 * @return 总页数
	 */
	public int getPurchasePaystate1TotalPages(int pagesize);
	public int getPaystate1ALL(int pagesize);
	
	/** 
	 * 获得款到发货 的所有采购单基本数据信息
	 * 分页查询盘点库存信息
	 * @param pages 当前页
	 * @param pagesize 每页显示行数
	 * @return Purchase集合
	 */
	public List<Purchase> getPurchaseBYPaystate2(int pages,int pagesize);
	/**
	 * 获取库存盘点总页数
	 * @param pagesize 每页显示行数
	 * @return 总页数
	 */
	public int getPurchasePaystate2TotalPages(int pagesize);
	public int getPaystate2ALL(int pagesize);
	
	/** 
	 * 获得预付款到发货 的所有采购单基本数据信息
	 分页查询盘点库存信息
	 * @param pages 当前页
	 * @param pagesize 每页显示行数
	 * @return Purchase集合
	 */
	public List<Purchase> getPurchaseBYPaystate3(int pages,int pagesize);
	/**
	 * 获取库存盘点总页数
	 * @param pagesize 每页显示行数
	 * @return 总页数
	 */
	public int getPurchasePaystate3TotalPages(int pagesize);
	public int getPaystate3ALL(int pagesize);
	/** 
	 * 根据采购单修改处理状态
	 * @param purchaseid
	 * @return
	 */
	public boolean updaBYID(String purchaseid ,String disposestate);
	
	public String PURCHAASEDET_SELECT_BYTWOID_SQL = "select pronum from Purchase_Det where proid=? and purchaseid=?";
	public int getDet(int proid, String purchaseid);
	
	public String PURCHAASEDET_SELECTPROID_BYID_SQL = "select proid from Purchase_Det where purchaseid=?";
	public int getDet(String purchaseid);
	
	/** 
	 * 根据采购单号在产品明细表查询了一系列内的产品集合
	 */
	public String PUREDET_PROIDSELECT_SQL = "select proid,pronum,detid from Purchase_Det where purchaseid=?";
	public String PURCHASE_UPDATE = "update purchase set paystate=?,extramoney=?,totalproprices=?,advanceprice=?,totalprices?,comment=?,disposestate=? where purchaseid = ?";
	/** 
	 * 根据采购单号在产品明细表查询了一系列内的产品集合
	 * @param saleid
	 * @return
	 */
	public List<PurchaseDet> getproid(String saleid);
	public String PURCHASE_SELECT = "select purchaseid,createtime,suppliername,createname,extramoney,totalproprices,totalprices,paystate,advanceprice,disposestate from Purchase where disposestate=5 and paystate=3";
}
