/**
 * 
 */
package com.aowin.scm.storagemanage.dao;

import java.util.List;

import com.aowin.scm.storagemanage.pojo.IntoStorage;
import com.aowin.scm.utils.BaseDao;

/**
 * 入库管理模块业务逻辑接口 
 * @author 李小龙
 * date:2018年11月15日 下午2:13:48
 * 
 */
public interface IntoStorageDAO extends BaseDao {
	/** 
	 * 查询入库表信息
	 */
	public String INTOSTORAGE_SELECT_SQL = "select inId,inStorageDate,inoHandle,inNum,inState,Reason,purchase_detid,purchaseid from intoStorage";
	/** 
	 * 根据采购单查询入库表的个别信息
	 */
	public String INTOSTORAGE_SELECT_BYPURID_SQL = "select inStorageDate,inoHandle,inNum from intoStorage where purchaseid=?";
	/** 
	 * 根据产品编号查看库存变更信息
	 */
	public String INTOSTORAGE_BIAN_SELECT_BYPURID_SQL = "select inStorageDate,purchaseid,inoHandle,inNum,inState from intoStorage where purchase_detid=?";
	/** 
	 * 根据产品编号查看产品明细编号
	 */
	public String INTOSTORAGE_PURD_ETID_BYPURID ="select purchase_detid from intoStorage where purchaseid=?";
	/** 
	 * 每月盘点 时对应 产品变化的类型数量原因
	 * 加入一行盘点信息
	 */
	public String INTOSTORAGE_INSERT_SQL = "insert into intostorage(inNum,inoHandle,instate,Reason,proId,inStorageDate) values(?,?,'3',?,?,NOW())";
	/** 
	 * 通过产品查看库存变更
	 */
	public String INTO_STORAGEPAN_SELECT_SQL = "select inStorageDate,inoHandle,inNum,Reason,purchase_detid from intoStorage where purchase_detid=? and instate=3";
	/** 
	 * 增加一行入库信息
	 */
	public String INTOSTORAGE_INSERT_ALL_SQL = "insert into intostorage(inStorageDate,inoHandle,inNum,instate,purchase_detid,purchaseid ) values(NOW(),?,?,'1',?,?)";
	
	/** 
	 * 查询入库表基本数据信息
	 * @return 入库表集合
	 */
	public List<IntoStorage> getIntoStorage();
	/** 
	 * 根据产品编号获得相关库存变更信息
	 * @param purchase_detid
	 * @return
	 */
	public List<IntoStorage> getIntoStorageByid(int purchase_detid);
	/** 
	 * 根据采购单号查询入库表的入库时间，入库数量，入库经手人
	 * @param purchaseid
	 * @return 带有个别信息的入库对象
	 */
	public IntoStorage getInto(String purchaseid);
	/** 
	 * 通过产品标号查看库存变更
	 * @return 产品变更基本数据信息的集合
	 */
	public List<IntoStorage> getPAN(int purchase_detid);
	/** 
	 *  加入一行盘点信息
	 * @return
	 */
	public boolean insertPandian(IntoStorage storage);
	/** 
	 *  增加一行入库信息
	 * @return
	 */
	public boolean insertIntoStorage(IntoStorage storage);
}
