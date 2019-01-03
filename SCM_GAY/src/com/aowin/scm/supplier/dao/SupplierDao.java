/**
 * 
 */
package com.aowin.scm.supplier.dao;

import java.util.List;


import com.aowin.scm.supplier.pojo.Supplier;
import com.aowin.scm.utils.BaseDao;

/**
 * @author 骆俊杰
 *date:2018年11月15日 上午11:12:41
 * 
 */
public interface SupplierDao extends BaseDao {
	
	/**
	 * 添加供应商信息
	 */
	public String SUPPLIER_INSERT_SQL = "insert into supplier(supplieid,suppliername,velaname,supplierpassword,address,mailnumber,createdate,phone,faxes) values (?,?,?,?,?,?,current_date,?,?)";
	/**
	 *根据supplierid删除供应商信息
	 */
	public String SUPPLIER_DELETE_SQL="delete from supplier where supplieid=?";
	/**
	 *根据supplierid修改供应商信息
	 */
	public String SUPPLIER_UPDATE_SQL="update supplier set suppliername=?,velaname=?,supplierpassword=?,address=?,mailnumber=?,phone=?,faxes=? where supplieid=?";
	/**
	 * 查询全部供应商信息
	 */
	public String SUPPLIER_SELECT_ALL_SQL = "select supplieid,suppliername,velaname,supplierpassword,address,mailnumber,createdate,phone,faxes from supplier ";
	/**
	 * 查询全部供应商信息
	 */
	public String SUPPLIER_SELECT_SQL_BY_ID = "select supplieid,suppliername,velaname,supplierpassword,address,mailnumber,createdate,phone,faxes from supplier where supplieid=? ";
	
	/**
	 * 添加供应商信息
	 * @param supplier 供应商基本信息
	 * @return 是否添加成功
	 * */
	public boolean insertSupplier(Supplier supplier);
	
	/**
	 * 根据供应商编号删除供应商
	 * @param supplier 供应商编号
	 * @return 是否删除成功
	 * */
	public boolean deleteSupplier(int supplieid);
	/**
	 * 根据供应商编号查询供应商信息
	 * @param supplier 供应商编号
	 * @return 供应商信息
	 * */
	public Supplier selectSupplier(int supplieid);
	/**
	*获取所有供应商信息
	 * @return 供应商集合 
	* */
	public List<Supplier> getSupplier();
	/**
	 * 修改供应商信息
	 * @param 供应商基本信息
	* @return 是否修改成功
	 */
	public boolean updateSupplier(Supplier supplier);
	/**
	 * 根据条件查询供应商信息
	 * @param sql语句
	* @return 供应商集合
	 */
	public List<Supplier> select(String sql);
	/**
	 * 判断供应商编号是否存在
	 * @param  供应商编号
	 * @return 是否存在
	 * */
	public boolean getSupplierById(int supplieid);
}
