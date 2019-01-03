/**
 * 
 */
package com.aowin.scm.storagemanage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aowin.scm.storagemanage.pojo.OutStorage;
import com.aowin.scm.utils.DBUtil;

/**
 * �������ģ��ҵ���߼�ʵ����
 * @author ��С��
 * date:2018��11��15�� ����3:46:47
 * 
 */
public class OutStorageDAOImpl implements OutStorageDAO {
	private Logger log = Logger.getLogger(OutStorageDAOImpl.class);
	/**
	 * 
	 */
	public OutStorageDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.storagemanage.dao.OutStorageDAO#getOutStorage()
	 */
	@Override
	public List<OutStorage> getOutStorage() {
		log.info("����ҵ���߼�������getOutStorage()");
		List<OutStorage> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(OUTSTORAGE_SELECT_SQL);
		ResultSet rs = null;
		try {
			
			rs = ps.executeQuery();
			while(rs.next()) {
				OutStorage n = new  OutStorage();
				n.setOutId(rs.getInt("outId"));
				n.setOutStorageDate(rs.getString("outStorageDate"));
				n.setOutHandle(rs.getString("outHandle"));
				n.setOutNum(rs.getInt("outNum"));
				n.setOutState(rs.getString("outState"));
				n.setReason(rs.getString("reason"));
				n.setSale_detid(rs.getInt("sale_detid"));
				n.setSalebillid(rs.getString("salebillid"));
				list.add(n);
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

	/* (non-Javadoc)
	 * @see com.aowin.scm.storagemanage.dao.OutStorageDAO#insertOutPandian(com.aowin.scm.storagemanage.pojo.OutStorage)
	 */
	@Override
	public boolean insertOutPandian(OutStorage storage) {
		log.info("����ҵ���߼�������insertOutPandian(OutStorage storage)");
		boolean result = false;
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(OUTSTORAGE_INSERT_SQL);
		try {
			ps.setInt(1, -storage.getOutNum());
			ps.setString(2, storage.getOutHandle());
			//ps.setString(2, storage.getInState());
			ps.setString(3,storage.getReason());
			ps.setInt(4, storage.getProId());
			//ps.setString(5,storage.getOutStorageDate());
			int i = ps.executeUpdate();
			if(i != 0) {
				result = true;
				log.info("�����ӳɹ�");
			}
		} catch (SQLException e) {
			log.warn("������ʧ��: " + e);
		//	e.printStackTrace();
		} finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return result;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.storagemanage.dao.OutStorageDAO#insertOutStorage(com.aowin.scm.storagemanage.pojo.OutStorage)
	 */
	@Override
	public boolean insertOutStorage(OutStorage storage) {
		log.info("����ҵ���߼�������insertOutStorage(OutStorage storage)");
		boolean result = false;
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(OUTSTORAGE_INSERT_ALL_SQL);
		try {
			
			//ps.setString(1, storage.getOutStorageDate());
			ps.setString(1, storage.getOutHandle());
			ps.setInt(2, storage.getOutNum());
			//ps.setString(2, storage.getInState());
			//ps.setString(2,storage.getReason());
			ps.setInt(3, storage.getSale_detid());
			ps.setString(4,storage.getSalebillid());
			int i = ps.executeUpdate();
			if(i != 0) {
				result = true;
				log.info("�����ӳɹ�");
			}
		} catch (SQLException e) {
			log.warn("������ʧ��: " + e);
		//	e.printStackTrace();
		} finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return result;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.storagemanage.dao.OutStorageDAO#getOut(String)
	 */
	@Override
	public OutStorage getOut(String salebillid) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.storagemanage.dao.OutStorageDAO#getIntoStorageByid(int)
	 */
	@Override
	public List<OutStorage> getOutStorageByid(int sale_detid) {
		log.info("����ҵ���߼�������getIntoStorageByid(int sale_detid)");
		List<OutStorage> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(OUTSTORAGE_BIAN_SELECT_BYPURID_SQL);
		ResultSet rs = null;
		try {
			ps.setInt(1,sale_detid);
			rs = ps.executeQuery();
			while(rs.next()) {
				OutStorage n = new  OutStorage();
				n.setOutStorageDate(rs.getString("outStorageDate"));
				n.setOutHandle(rs.getString("outHandle"));
				n.setOutNum(rs.getInt("outNum"));
				n.setOutState(rs.getString("outState"));
				n.setSalebillid(rs.getString("salebillid"));
				list.add(n);
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
	

}
