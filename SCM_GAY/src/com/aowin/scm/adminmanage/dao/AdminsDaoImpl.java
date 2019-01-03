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
		log.info("��ʼִ��insertAdmins(Aminds admins)����");
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
				log.info("�ɹ���user�������һ������");
			}
		} catch (SQLException e) {
			log.warn("��user�����������ʧ��:"+e);
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
		log.info("��ʼִ��updateAdmins(Admins admins)����");
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
				log.info("�ɹ��޸���user���е�һ������");
			}
		} catch (SQLException e) {
			log.warn("��user�����޸�����ʧ��:"+e);
		}finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return false;
	}
	

	@Override
	public boolean deleteAdmins(String account) {
		log.info("��ʼִ��deleteAdmins(String account)����");
		DBUtil db = new DBUtil();
		boolean result = false;
		PreparedStatement ps = db.getPreparedStatement(ADMIN_DELETE);
		try {
			ps.setString(1, account);
			int i = ps.executeUpdate();
			if(i > 0) {
				result = true;
				log.info("�ɹ�ɾ����user���е�һ������");
			}
		} catch (SQLException e) {
			log.warn("��user����ɾ������ʧ��:"+e);
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
		log.info("��ʼִ��getADMINS(String account, String password)����");
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
				log.info("���ҵ���Ӧ���û���Ϣ");
			}
		} catch (SQLException e) {
			log.warn("�û���Ϣ����ʧ��:"+e);
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
		log.info("��ʼִ��accountIsExist(String account)����");
		DBUtil db = new DBUtil();
		boolean result = false;
		PreparedStatement ps = db.getPreparedStatement(ADMIN_ACCOUNT_EXIST);
		ResultSet rs = null;
		try {
			ps.setString(1, account);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = true;
				log.info("���û����Ѿ���ʹ��");
			}
			if(!result) {
				log.info("���û�û�б�ʹ��");
			}
		} catch (SQLException e) {
			log.warn("�û�����֤ʧ��:"+e);
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
		log.info("��ʼִ�� getAdminsBySQL(String sql) ����");
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
				log.info("�ɹ���ѯ��"+list.size()+"������");
			}else {
				log.info("��ѯ��0������");
			}
		} catch (SQLException e) {
			log.warn("��ѯʧ��:"+e);
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
		log.info("��ʼִ�� getAdminsByAccount(String account)����");
		DBUtil db = new DBUtil();
		Admins admins = null;
		PreparedStatement ps = db.getPreparedStatement(ADMINS_SELECT_ACCOUNT);
		ResultSet rs = null;
		try {
			ps.setString(1, account);
			rs = ps.executeQuery();
			if(rs.next()) {
				log.info("��ѯ��һ���˺���Ϣ");
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
			log.warn("��ѯ�˺���Ϣʧ��:"+e);
		}finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return admins;	
	}
	
	

}
