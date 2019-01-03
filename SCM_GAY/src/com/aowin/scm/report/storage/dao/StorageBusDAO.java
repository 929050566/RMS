/**
 * 
 */
package com.aowin.scm.report.storage.dao;

import java.util.List;

import com.aowin.scm.report.storage.pojo.StorageBus;
import com.aowin.scm.utils.BaseDao;

/**
 * 库月季业务报表
 * @author 李小龙
 * date:2018年11月20日 下午8:24:49
 */
public interface StorageBusDAO extends BaseDao {
	/** 
	 * 
	 * @param sd
	 * @param ed
	 * @param page
	 * @param size
	 * @return 采购单号，入库日期
	 */
	public List<StorageBus> getPurchasebytime(String sd,String ed);
	public String INSTORAGE_SELCETID_BYTIM_SQL = "select purchaseid,inStorageDate from intostorage where inStorageDate>=? and inStorageDate<=? and inState='1' ";
	/** 
	 * 
	 * @param sd
	 * @param ed
	 * @param page
	 * @param size
	 * @return 盘点入库单号，入库日期
	 */
	public List<StorageBus> getPurchasePANbytime(String sd,String ed);
	public String INSTORAGE_PANSELCETID_BYTIM_SQL = "select proid,inStorageDate,inNum from intostorage where inStorageDate>=? and inStorageDate<=? and inState='3' ";
	/** 
	 * 根据采购单号查询对应明细表
	 * @param purchaseid
	 * @return 产品编号，产品名称，产品数，产品总金额
	 */
	public List<StorageBus>  getdetBYtime(String purchaseid,String intodate);
	public String INSTORAGE_SELECTMINGXIBYID_SQL = "select purchaseid,proid,proname,pronum,totalprice,unitprice from purchase_det where purchaseid=? ";
	/** 
	 * 根据销售单号查询对应明细表
	 * @param saleid
	 * @return
	 */
	public List<StorageBus> getSaleDetByTime(String saleid,String outdate);
	public String INSTORAGE_SELECTMINGXISALE = "select salebillid,proid,proname,pronum,totalprice,unitprice from sale_det where salebillid=?";

	//出库业务表
	/** 
	 * 
	 * @param sd
	 * @param ed
	 * @param page
	 * @param size
	 * @return 销售单号，出库日期
	 */
	public List<StorageBus> getSalebytime(String sd,String ed);
	public String Sale_SELCETID_BYTIM_SQL = "select  salebillid,outStorageDate from outstorage where outStorageDate>=? and outStorageDate<=? and outState='2' ";
	/** 
	 * 
	 * @param sd
	 * @param ed
	 * @param page
	 * @param size
	 * @return 盘点出库单号，出库日期
	 */
	public List<StorageBus> getPANSalebytime(String sd,String ed);
	public String Sale_SELCETIDPAN_BYTIM_SQL = "select proid,outStorageDate,outnum from outstorage where outStorageDate>=? and outStorageDate<=? and outState='4' ";
	
	
	public String getName(int proid);
	public String STORAGE_PRONAME_SQL = "select proName from storage where proid = ?";
	
	public String PURCHASE_SELECT_PRICE_SQL ="select totalprices from purchase where purchaseid = ?";
	public float getPtotalprices(String purchaseid);
	
	public float getStotalprices(String salebillid);
	public String SALE_SELECT_PRICES_SQL ="select totalprices from sale where salebillid = ?";

}
