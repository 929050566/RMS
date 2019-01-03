/**
 * 
 */
package com.aowin.scm.supplier.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aowin.scm.supplier.pojo.Supplier;
import com.aowin.scm.utils.DBUtil;

/**
 * @author �濡��
 *date:2018��11��15�� ����11:47:55
 * 
 */
public class SupplierDaoImpl implements SupplierDao {

	
	private Logger log = Logger.getLogger(SupplierDaoImpl.class);
	public boolean insertSupplier(Supplier supplier) {
		// TODO �Զ����ɵķ������
		log.info("����ҵ���߼�������insertSupplier(Supplier supplier)");
		boolean result = false;
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(SUPPLIER_INSERT_SQL);
		try {
			ps.setInt(1, supplier.getSupplieid());
			ps.setString(2, supplier.getSuppliername());
			ps.setString(3, supplier.getVelaname());
			ps.setString(4, supplier.getSupplierpassword());
			ps.setString(5, supplier.getAddress());
			ps.setString(6, supplier.getMailnumber());
			ps.setString(7, supplier.getPhone());
			ps.setString(8, supplier.getFaxes());
			int i = ps.executeUpdate();
			if(i != 0) {
				result = true;
				log.info("��Ӧ����ӳɹ�");
			}
		} catch (SQLException e) {
			log.warn("��Ӧ�����ʧ��: " + e);
		//	e.printStackTrace();
		} finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return result;
	}

	/* ���� Javadoc��
	 * @see com.aowin.scm.supplier.dao.SupplierDao#deleteSupplier(int)
	 */
	@Override
	public boolean deleteSupplier(int supplieid) {
		log.info("����ҵ���߼�������deleteSupplier(int supplieid)");
		boolean result = false;
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(SUPPLIER_DELETE_SQL);
		try {
			ps.setInt(1, supplieid);
			int i = ps.executeUpdate();
			if( i > 0 ) {
				result = true;
				log.info("�ɹ�ɾ��һ����Ӧ��");
			}
		} catch (SQLException e) {
			log.warn("��Ӧ��ɾ��ʧ�ܣ�"+e);
		} finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return result;
		
	}

	/* ���� Javadoc��
	 * @see com.aowin.scm.supplier.dao.SupplierDao#getSupplier(int, int)
	 */
	@Override
	public List<Supplier> getSupplier() {
		log.info("����ҵ���߼�������getSupplier()");
		List<Supplier> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(SUPPLIER_SELECT_ALL_SQL);
		ResultSet rs = null;
		try {
	
			rs = ps.executeQuery();
			while(rs.next()) {
				Supplier supplier = new  Supplier();
				supplier.setSupplieid(rs.getInt("supplieid"));
				supplier.setSuppliername(rs.getString("suppliername"));
				supplier.setVelaname(rs.getString("velaname"));
				supplier.setSupplierpassword(rs.getString("supplierpassword"));
				supplier.setAddress(rs.getString("address"));
				supplier.setMailnumber(rs.getString("mailnumber"));
				supplier.setCreatedate(rs.getString("createdate"));
				supplier.setPhone(rs.getString("phone"));
				supplier.setFaxes(rs.getString("faxes"));
				list.add(supplier);
			}
		} catch (SQLException e) {
			log.warn("���ݲ�ѯʧ��: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return list;
	}

	
	@Override
	public boolean updateSupplier(Supplier supplier) {
		log.info("����ҵ���߼�������updateSupplier(Supplier supplier)");
		boolean result = false;
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(SUPPLIER_UPDATE_SQL);
		try {
			
			ps.setString(1, supplier.getSuppliername());
			ps.setString(2, supplier.getVelaname());
			ps.setString(3, supplier.getSupplierpassword());
			ps.setString(4, supplier.getAddress());
			ps.setString(5, supplier.getMailnumber());
			ps.setString(6, supplier.getPhone());
			ps.setString(7, supplier.getFaxes());
			ps.setInt(8, supplier.getSupplieid());
			log.info(ps);
			int i = ps.executeUpdate();
			if(i != 0) {
				result = true;
				log.info("��Ӧ���޸ĳɹ�");
			}
		} catch (SQLException e) {
			log.warn("��Ӧ���޸�ʧ��: " + e);
		//	e.printStackTrace();
		} finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return result;
	}

	@Override
	public Supplier selectSupplier(int supplieid) {
		log.info("����ҵ���߼�������selectSupplier(int supplieid)");
		Supplier supplier=null;
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(SUPPLIER_SELECT_SQL_BY_ID);
		ResultSet rs = null;
		try {
			ps.setInt(1, supplieid);
			rs = ps.executeQuery();
			if(rs.next()) {
				supplier = new Supplier();
				supplier.setSupplieid(rs.getInt("supplieid"));
				supplier.setSuppliername(rs.getString("suppliername"));
				supplier.setVelaname(rs.getString("velaname"));
				supplier.setSupplierpassword(rs.getString("supplierpassword"));
				supplier.setAddress(rs.getString("address"));
				supplier.setMailnumber(rs.getString("mailnumber"));
				supplier.setCreatedate(rs.getString("createdate"));
				supplier.setPhone(rs.getString("phone"));
				supplier.setFaxes(rs.getString("faxes"));
			}
		} catch (SQLException e) {
			log.warn("������ʧ��: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return supplier;
	}

	@Override
	public List<Supplier> select(String sql) {
		log.info("����ҵ���߼�������List<Supplier> select(String sql)");
		List<Supplier> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(sql);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			while(rs.next()) {
				Supplier supplier = new  Supplier();
				supplier.setSupplieid(rs.getInt("supplieid"));
				supplier.setSuppliername(rs.getString("suppliername"));
				supplier.setVelaname(rs.getString("velaname"));
				supplier.setSupplierpassword(rs.getString("supplierpassword"));
				supplier.setAddress(rs.getString("address"));
				supplier.setMailnumber(rs.getString("mailnumber"));
				supplier.setCreatedate(rs.getString("createdate"));
				supplier.setPhone(rs.getString("phone"));
				supplier.setFaxes(rs.getString("faxes"));
				list.add(supplier);
			}
		} catch (SQLException e) {
			log.warn("����ѯʧ��: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return list;
	}

	@Override
	public boolean getSupplierById(int supplieid) {
		log.info("����ҵ���߼�������getSupplierById(int supplieid)");
		boolean result = true;
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(SUPPLIER_SELECT_SQL_BY_ID);
		ResultSet rs = null;
		try {
			ps.setInt(1, supplieid);
			rs = ps.executeQuery();
			if(rs.next()) {
			 result=false;
			}
		} catch (SQLException e) {
			log.warn("������ʧ��: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return result;
	}
	

}
