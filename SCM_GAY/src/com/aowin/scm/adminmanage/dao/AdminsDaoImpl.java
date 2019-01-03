package com.aowin.scm.adminmanage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aowin.scm.adminmanage.pojo.Admins;
import com.aowin.scm.utils.DBUtil;

public class AdminsDaoImpl implements AdminsDao {
	
	Logger log = Logger.getLogger(AdminsDaoImpl.class);

	@Override
	public boolean insertAdmins(Admins admins) {
		log.info("开始执行insertAdmins(Aminds admins)方法");
		DBUtil db = new DBUtil();
		boolean result = false;
		PreparedStatement ps = db.getPreparedStatement(ADMIN_INSERT);
		try {
			ps.setString(1, admins.getAccount());
			ps.setString(2, admins.getRealname());
			ps.setString(3, admins.getPassword());
			ps.setString(4,admins.getLock_statu());
			ps.setString(5, admins.getPo_permit());
			ps.setString(6, admins.getDepot_permit());
			ps.setString(7, admins.getSale_permit());
			ps.setString(8, admins.getFinance_permit());
			ps.setString(9, admins.getReport_permit());
			ps.setString(10, admins.getUser_permit());
			ps.setString(11, admins.getNetworksale_permit());
			ps.setString(12, admins.getManager_permit());
			int i = ps.executeUpdate();
			if(i > 0) {
				result = true;
				log.info("成功向user表中添加一行数据");
			}
		} catch (SQLException e) {
			log.warn("向user表中添加数据失败:"+e);
		}finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return false;
	}
	
	/*
	 *  "update user set realname=?,password=?,lock_statu=?,po_permit=?,"+ 
			" depot_permit=?,sale_permit=?,finance_permit=?,report_permit=?,user_permit=?,networksale_permit=?,manager_permit=?"+ 
			" where account = ?";
	 */
	@Override
	public boolean updateAdmins(Admins admins) {
		log.info("开始执行updateAdmins(Admins admins)方法");
		DBUtil db = new DBUtil();
		boolean result = false;
		PreparedStatement ps = db.getPreparedStatement(ADMIN_UPDATE_ACCOUNT);
		try {
			ps.setString(1, admins.getRealname());
			ps.setString(2, admins.getPassword());
			ps.setString(3,admins.getLock_statu());
			ps.setString(4, admins.getPo_permit());
			ps.setString(5, admins.getDepot_permit());
			ps.setString(6, admins.getSale_permit());
			ps.setString(7, admins.getFinance_permit());
			ps.setString(8, admins.getReport_permit());
			ps.setString(9, admins.getUser_permit());
			ps.setString(10, admins.getNetworksale_permit());
			ps.setString(11, admins.getManager_permit());
			ps.setString(12, admins.getAccount());
			int i = ps.executeUpdate();
			if(i > 0) {
				result = true;
				log.info("成功修改了user表中的一行数据");
			}
		} catch (SQLException e) {
			log.warn("向user表中修改数据失败:"+e);
		}finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return false;
	}
	

	@Override
	public boolean deleteAdmins(String account) {
		log.info("开始执行deleteAdmins(String account)方法");
		DBUtil db = new DBUtil();
		boolean result = false;
		PreparedStatement ps = db.getPreparedStatement(ADMIN_DELETE);
		try {
			ps.setString(1, account);
			int i = ps.executeUpdate();
			if(i > 0) {
				result = true;
				log.info("成功删除了user表中的一行数据");
			}
		} catch (SQLException e) {
			log.warn("向user表中删除数据失败:"+e);
		}finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return false;
	}
	
	//select account,password from user where account=? and password=?
	@Override
	public Admins login(String account, String password) {
		log.info("开始执行getADMINS(String account, String password)方法");
		DBUtil db = new DBUtil();
		Admins admins = null;
		PreparedStatement ps = db.getPreparedStatement(ADMIN_SELEET_LOGIN);
		ResultSet rs = null;
		try {
			ps.setString(1, account);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()) {
				admins = new Admins();
				admins.setUserid(rs.getInt("userid"));
				admins.setAccount(rs.getString("account"));
				admins.setRealname(rs.getString("realname"));
				admins.setPassword(rs.getString("password"));
				admins.setCreatedate(rs.getDate("createdate"));
				admins.setLock_statu(rs.getString("lock_statu"));
				admins.setPo_permit(rs.getString("po_permit"));
				admins.setDepot_permit(rs.getString("depot_permit"));
				admins.setSale_permit(rs.getString("sale_permit"));
				admins.setFinance_permit(rs.getString("finance_permit"));
				admins.setReport_permit(rs.getString("report_permit"));
				admins.setUser_permit(rs.getString("user_permit"));
				admins.setNetworksale_permit(rs.getString("networksale_permit"));
				admins.setManager_permit(rs.getString("manager_permit"));
				log.info("查找到对应的用户信息");
			}
		} catch (SQLException e) {
			log.warn("用户信息查找失败:"+e);
		}finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return admins;		
	}
	
	//select account from user where account = ?
	@Override
	public boolean accountIsExist(String account) {
		log.info("开始执行accountIsExist(String account)方法");
		DBUtil db = new DBUtil();
		boolean result = false;
		PreparedStatement ps = db.getPreparedStatement(ADMIN_ACCOUNT_EXIST);
		ResultSet rs = null;
		try {
			ps.setString(1, account);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = true;
				log.info("该用户名已经被使用");
			}
			if(!result) {
				log.info("该用户没有被使用");
			}
		} catch (SQLException e) {
			log.warn("用户名验证失败:"+e);
		}finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return result;	
	}

	@Override
	public List<Admins> getAdminsBySQL(String sql) {
		log.info("开始执行 getAdminsBySQL(String sql) 方法");
		DBUtil db = new DBUtil();
		List<Admins> list = new ArrayList<Admins>();
		PreparedStatement ps = db.getPreparedStatement(sql);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			while(rs.next()) {
				Admins admins = new Admins();
				admins.setUserid(rs.getInt("userid"));
				admins.setAccount(rs.getString("account"));
				admins.setRealname(rs.getString("realname"));
				admins.setPassword(rs.getString("password"));
				admins.setCreatedate(rs.getDate("createdate"));
				admins.setLock_statu(rs.getString("lock_statu"));
				admins.setPo_permit(rs.getString("po_permit"));
				admins.setDepot_permit(rs.getString("depot_permit"));
				admins.setSale_permit(rs.getString("sale_permit"));
				admins.setFinance_permit(rs.getString("finance_permit"));
				admins.setReport_permit(rs.getString("report_permit"));
				admins.setUser_permit(rs.getString("user_permit"));
				admins.setNetworksale_permit(rs.getString("networksale_permit"));
				admins.setManager_permit(rs.getString("manager_permit"));
				list.add(admins);
			}
			if(list.size() >0) {
				log.info("成功查询出"+list.size()+"条数据");
			}else {
				log.info("查询出0条数据");
			}
		} catch (SQLException e) {
			log.warn("查询失败:"+e);
		}finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return list;	
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.adminmanage.dao.AdminsDao#getAdminsByAccount(java.lang.String)
	 */
	@Override
	public Admins getAdminsByAccount(String account) {
		log.info("开始执行 getAdminsByAccount(String account)方法");
		DBUtil db = new DBUtil();
		Admins admins = null;
		PreparedStatement ps = db.getPreparedStatement(ADMINS_SELECT_ACCOUNT);
		ResultSet rs = null;
		try {
			ps.setString(1, account);
			rs = ps.executeQuery();
			if(rs.next()) {
				log.info("查询出一条账号信息");
				admins = new Admins();
				admins.setUserid(rs.getInt("userid"));
				admins.setAccount(rs.getString("account"));
				admins.setRealname(rs.getString("realname"));
				admins.setPassword(rs.getString("password"));
				admins.setCreatedate(rs.getDate("createdate"));
				admins.setLock_statu(rs.getString("lock_statu"));
				admins.setPo_permit(rs.getString("po_permit"));
				admins.setDepot_permit(rs.getString("depot_permit"));
				admins.setSale_permit(rs.getString("sale_permit"));
				admins.setFinance_permit(rs.getString("finance_permit"));
				admins.setReport_permit(rs.getString("report_permit"));
				admins.setUser_permit(rs.getString("user_permit"));
				admins.setNetworksale_permit(rs.getString("networksale_permit"));
				admins.setManager_permit(rs.getString("manager_permit"));
			}
		} catch (SQLException e) {
			log.warn("查询账号信息失败:"+e);
		}finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return admins;	
	}
	
	

}
