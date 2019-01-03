/**
 * 
 */
package com.aowin.scm.storagemanage.dao;

import java.util.List;

import com.aowin.scm.storagemanage.pojo.OutStorage;
import com.aowin.scm.utils.BaseDao;

/**
 * 出库管理模块业务逻辑接口 
 * @author 李小龙
 * date:2018年11月15日 下午3:36:28
 * 
 */
public interface OutStorageDAO extends BaseDao {
	/** 
	 * 查询出库表信息
	 */
	public String OUTSTORAGE_SELECT_SQL = "select outId,outStorageDate,outHandle,outNum,outState,Reason,sale_detid,salebillid from outStorage";
	
	/** 
	 * 根据产品编号查看库存变更信息
	 */
	public String OUTSTORAGE_BIAN_SELECT_BYPURID_SQL = "select outStorageDate,salebillid,outHandle,outNum,outState from outStorage where sale_detid=?";
	/**
	 * 根据销售单号查询
	 */
	public String OUTSTORAGE_SELECL_BYSALEID_SQL = "select outStorageDate,outHandle,outNum from outStorage where salebillid = ?";
	/** 
	 * 每月盘点 时对应 产品变化的类型数量原因
	 * 加入一行盘点信息
	 */
	public String OUTSTORAGE_INSERT_SQL = "insert into outstorage(outNum,outstate,outHandle,Reason,proId,outStorageDate) values(?,'4',?,?,?,NOW())";
	/** 
	 * 增加一行出库信息
	 */
	public String OUTSTORAGE_INSERT_ALL_SQL = "insert into outstorage(outStorageDate,outHandle,outNum,outstate,sale_detid,salebillid) values(NOW(),?,?,'2',?,?)";
	
	/** 
	 * 查询出库表基本数据信息
	 * @return 查询出库表集合
	 */
	public List<OutStorage> getOutStorage();
	/** 
	 * 根据产品编号获得相关库存变更信息
	 * @param sale_detid
	 * @return
	 */
	public List<OutStorage> getOutStorageByid(int sale_detid);
	/** 
	 *  查询出库表基本数据信息
	 * @return 带有出库时间，出库数量，出库登记人的对象
	 */
	public OutStorage getOut(String salebillid);
	/** 
	 *  加入一行盘点信息
	 * @return
	 */
	public boolean insertOutPandian(OutStorage storage);
	/** 
	 *  增加一行出库信息
	 * @return
	 */
	public boolean insertOutStorage(OutStorage storage);
}
