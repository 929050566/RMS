/**
 * 
 */
package com.aowin.scm.storagemanage.dao;

import java.util.List;

import com.aowin.scm.storagemanage.pojo.Storage;
import com.aowin.scm.utils.BaseDao;



/**
 * @author 李小龙
 * date:2018年11月15日 上午10:38:26
 * 
 */
public interface StorageDAO extends BaseDao {
	/** 
	 * 查询产品id，名称，当前库存，采购在途数，预销售数
	 */
	public String STOTRAGE_SELECT_SQL = "select proID,proName,proUnit,presentNum,onPurchaseNum,onPresaleNum from storage";
	/** 
	 * 根据产品编号查询产品id，名称，当前库存，采购在途数，预销售数
	 */
	public String STOTRAGE_SELECT_ALL_SQL = "select proID,proName,proUnit,presentNum,onPurchaseNum,onPresaleNum from storage where proID=?";

	/** 
	 * 库存盘点查询
	 */
	public String STOTRAGE_SELECT_PAN_SQL = "select proID,proName,presentNum,onPurchaseNum,onPresaleNum from storage ";
	/** 
	 * 增加一行产品
	 */
	public String STORAGE_INSERT_SQL = "insert into storage(proID,proName,proUnit,protypeid,presentNum,onPurchaseNum,onPresaleNum) values (?,?,?,?,?,?,?)";
	/** 
	 * 入库时减少采购在途数增加库存
	 */
	public String STORAGE_RKBYID_SQL = "update storage set onPurchaseNum=onPurchaseNum-? , presentNum=presentNum+? where proID=?";
	/** 
	 * 出库时减少预销售数和减少库存
	 */
	public String STORAGE_CKBYID_SQL ="update storage set onPresaleNum=onPresaleNum-?,presentNum=presentNum-? where proID=?";

	/** 
	 * 修改采购在途数
	 */
	public String STORAGE_UPDATE_ONPURCHASENUM_SQL ="update storage set onPurchaseNum=? where proID=?";
	
	/** 
	 * 修改预销售数
	 */
	public String STORAGE_UPDATE_ONPRESALENUM_SQL ="update storage set onPresaleNum=? where proID=?";
	/** 
	 * 根据产品编号修改库存
	 */
	public String STORAGE_UPDATE_PRESENTNUM_SQL = "update storage set presentNum =? where proID=?";
	/** 
	 * 盘点更新后修改库存
	 * @param proID 产品编号
	 * @param presentNum 当前库存
	 * @return 盘点后是否修改库存成功
	 */
	public boolean updaPersentNum(int proID,int presentNum);
	/** 
	 * 入库时减少采购在途数增加库存
	 * @param proid 产品编号
	 * @param presentNum 当前库存
	 * @param onPurchaseNum 采购在途数
	 * @return 是否入库时相应数据修改成功
	 */
	public boolean updaRKBID(int proid,int presentNum,int onPurchaseNum);
	/** 
	 * 根据产品编号修改采购在途数
	 * @param proID 产品编号
	 * @return 是否修改采购在途数成功
	 */
	public boolean updaPurByProID(int proID,String onPurchaseNum) ;
	/** 
	 * 出库时减少预销售数和减少库存
	 * @param proid 产品编号
	 * @param presentNum 要减少的库存数
	 * @param onPresaleNum 要减少的预销售数
	 * @return  出库时是否相应数据修改成功
	 */
	public boolean updaCKBYID(int proid,int presentNum,int onPresaleNum);
	/** 
	 * 根据产品编号修改预销售数
	 * @param proID 产品编号
	 * @return 是否修改预销售数成功
	 */
	public boolean updaSaleByProID(int proID,String onPresaleNum);
	/** 
	 * 添加库存信息
	 * @param storage 库存对象
	 * @return 是否添加库存信息成功
	 */
	public boolean insertStorage(Storage storage);
	
	/** 
	 * 查询产品id，名称，当前库存，采购在途数，预销售数
	 * @param proID 查询产品id
	 * @return 存放产品id，名称,单位，当前库存，采购在途数，预销售数组成的对象
	 */
	public Storage getStorageALL(int proID);
	/** 
	 * 查询产品id，名称，当前库存，采购在途数，预销售数
	 * @param proID
	 * @return 存放（产品id，名称,单位，当前库存，采购在途数，预销售数组成的）对象的集合
	 */
	public List<Storage> getStorage(int proID);
	/** 
	 * 库存盘点查询
	 * @return 存放（产品id，名称，当前库存，采购在途数，预销售数组成的）对象的集合
	 */
	public List<Storage> getPanStorage();
	
	/**
	 * 分页查询盘点库存信息
	 * @param pages 当前页
	 * @param pagesize 每页显示行数
	 * @return Storage集合
	 */
	public List<Storage> getCountStorage(int pages,int pagesize);
	
	/**
	 * 获取库存盘点总页数
	 * @param pagesize 每页显示行数
	 * @return 总页数
	 */
	public int getStorageTotalPages(int pagesize);
	/** 
	 * 获取库存盘点的总产品记录数
	 * @param pagesize
	 * @return 产品总记录数
	 */
	public int getNum(int pagesize);
	
	public List<Storage> getSelect(String sql);
	//=====================俊杰
	/**
	 * 修改商品在途数
	 */
	
	public String STOTRAGE_UPD_PIO_SQL = "update storage set onPurchaseNum=? where proID=?";
	/**
	 * 获取商品属性
	 */
	
	public String STOTRAGE_SELECT_PIO_SQL = "select proID,proName,proUnit from storage ";
	/**
	 * 查找商品信息
	 * 
	* @return 商品集合
	 */
	public List<Storage> getStorage();
	/**
	 * 根据商品ID修改明商品数量
	 * @param 商品ID 商品数量
	* @return 是否修改成功
	 */
	public boolean updateOnPurchaseNum(int proID,int num);
	
	
}
