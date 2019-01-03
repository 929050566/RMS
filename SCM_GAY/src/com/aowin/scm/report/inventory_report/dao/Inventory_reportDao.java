/**
 * 
 */
package com.aowin.scm.report.inventory_report.dao;

import java.util.List;

import com.aowin.scm.report.inventory_report.pojo.Inventory_report;
import com.aowin.scm.utils.BaseDao;

/**
 * @author 骆俊杰
 *date:2018年11月21日 上午11:42:10
 * 
 */
public interface Inventory_reportDao extends BaseDao {

	
	/**
	 * 获取商品总数
	 */
	public String REPORT_SELECT_COUNT_SQL = "select count(proID) total from storage";
	/**
	 * 分页查询商品信息
	 */
	public String REPORT_SELECT_ALL_SQL = "select proID,proName,presentNum from storage order by proID desc limit ?,?";
	
	/**
	 * 查询商品库存信息
	 */
	public String REPORT_SELECT_PRESENTNUM_SQL = "select presentNum from storage ";
	/**
	 * 查询商品库存信息
	 */
	public String REPORT_SELECT_NAME_BY_ID_SQL = "select proName from storage where proID=? ";
	/**
	 * 获得数据的总行数
	 * @return 数据的总行数
	 */
	public int getTotalLines();
	/**
	 * 得到所有商品库存数
	 * @return 商品库存数集合
	 */
	public List<Integer> gettotalpresentNum();
	/**
	 * 分页显示商品信息
	 * @param page 当前页
	 * @param size 每页显示行数
	 * @return Inventory_Report集合
	 */
	public List<Inventory_report> getInventory_Report(int page,int size);
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
	public List<Inventory_report> getInventoryBySql(String sql);
	/**
	 * 通过sql语句 查询采购单集合
	 * @param sql语句
	 * @return 查询采购单集合
	 */
	public List<Inventory_report> getInInventoryBySql(String sql);
	/**
	 * 通过商品ID 查询商品名字
	 * @param id
	 * @return 名字
	 */
	public String getNameById(int id);
}
