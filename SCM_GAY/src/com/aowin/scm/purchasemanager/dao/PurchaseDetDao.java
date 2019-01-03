package com.aowin.scm.purchasemanager.dao;
import java.util.List;

import com.aowin.scm.purchasemanager.pojo.PurchaseDet;
import com.aowin.scm.utils.BaseDao;

/**
 * @author 骆俊杰
 *date:2018年11月15日 下午4:21:38
 * 
 */
public interface PurchaseDetDao extends BaseDao {

	/**
	 * 添加采购单信息
	 */
	public String PURCHASEDET_INSERT_SQL = "insert into purchase_det(proid,proname,pronum,prounit,unitprice,totalprice,purchaseid) values (?,?,?,?,?,?,?)";
	/**
	 *根据purchaseid删除采购单信息
	 */
	public String PURCHASEDET_DELETE_SQL="delete from purchase_det where purchaseid=?";
	/**
	 *根据purchaseid修改采购单信息
	 */
	public String PURCHASEDET_UPDATE_SQL="update purchase_det set proid=?,proname=?,pronum=?,prounit=?,unitprice=?,totalprice=? where purchaseid=?";
	/**
	 *根据purchaseid查询采购明细单信息
	 */
	public String PURCHASEDET_SELECT_SQL = "select detid,proid,proname,pronum,prounit,unitprice,totalprice from purchase_det where purchaseid=?";
	/**
	 * 添加明细单信息
	 * @param 明细单基本信息
	 * @return 是否添加成功
	 * */
	public boolean insertPurchaseDet(PurchaseDet purchasedet);
	/**
	 * 根据采购单编号删除明细表
	 * @param 采购单编号
	 * @return 是否删除成功
	 * */
	public boolean deletePurchaseDet(String purchaseid);
	
	/**
	 * 修改明细表信息
	 * @param 明细表基本信息
	* @return 是否修改成功
	 */
	public boolean updatePurchaseDet(PurchaseDet purchasedet);
	
	/**
	 * 根据采购单编号查询明细表
	 * @param 采购单编号
	 * @return 明细表信息
	 * */
	public List<PurchaseDet> selectPurchaseDet(String purchaseid);
	
	//==================================================
	/**
	 * 通过采购明细对象 减少 相应的采购在途数
	 * @param purchaseDet对象
	 * @return 是否修改成功
	 */
	public boolean updateStorageByPurchaseDet(PurchaseDet purchaseDet);
	public String  SEORAGE_UPDATE_BY_PURCHASEID = "update storage set onPurchaseNum = onPurchaseNum - ? where proID = ?";
	
	/**
	 * 删除采购单明细 通过采购单id
	 * @param detid
	 * @return 是否删除成功
	 */
	public boolean deletePurchaseDetByDetid(int detid);
	public String PURDET_DELETE_DETID = "delete from purchase_det where detid = ?";
}
