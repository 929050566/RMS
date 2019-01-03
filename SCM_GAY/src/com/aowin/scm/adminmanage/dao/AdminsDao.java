package com.aowin.scm.adminmanage.dao;

import java.util.List;

import com.aowin.scm.adminmanage.pojo.Admins;
import com.aowin.scm.utils.BaseDao;

/**
 * 用户管理接口
 * @author haozai
 * @date 2018年11月15日 上午9:56:24
 */
public interface AdminsDao extends BaseDao{
	/**
	 * 通过一个admins来增加一个用户
	 * @param admins
	 * @return 是否增加成功
	 */
	public boolean insertAdmins(Admins admins);
	public String ADMIN_INSERT = "insert into user (account,realname,password,createdate,lock_statu,po_permit," + 
			" depot_permit,sale_permit,finance_permit,report_permit,user_permit,networksale_permit,manager_permit)"
			+ "values(?,?,?,current_date(),?,?,?,?,?,?,?,?,?)";
	
	/**
	 * 通过admins来修改一个用户数据
	 * @param admins
	 * @return 是否修改成功
	 */
	public boolean updateAdmins(Admins admins);
	public String ADMIN_UPDATE_ACCOUNT= "update user set realname=?,password=?,lock_statu=?,po_permit=?,"+ 
			" depot_permit=?,sale_permit=?,finance_permit=?,report_permit=?,user_permit=?,networksale_permit=?,manager_permit=?"+ 
			" where account = ?";
	
	public boolean deleteAdmins(String account);
	public String ADMIN_DELETE = "delete from user where account = ?";
	
	/**
	 * 通过用户名和密码查询用户是否存在
	 * @param account 用户名 
	 * @param password 密码
	 * @return 用户  不存在为null
	 */
	public Admins login(String account,String password);
	public String ADMIN_SELEET_LOGIN = "select * from user where account=? and password=?";
	
	/**
	 * 通过用户名 判断用户名是否存在
	 * @param 用户名 account
	 * @return 是否存在
	 */
	public boolean accountIsExist(String account);
	public String ADMIN_ACCOUNT_EXIST = "select account from user where account = ?";
	
	/**
	 * 通过sql语句查询用户集合
	 * @param sql语句
	 * @return 用户集合
	 */
	public List<Admins> getAdminsBySQL(String sql);
	
	/**
	 * 通过账号account查询出用户信息
	 * @param 账号account
	 * @return 用户信息Admins
	 */
	public Admins getAdminsByAccount(String account);
	public String ADMINS_SELECT_ACCOUNT = "select * from user where account = ?";
}
