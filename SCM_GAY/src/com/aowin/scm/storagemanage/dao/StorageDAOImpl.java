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

import com.aowin.scm.storagemanage.pojo.Storage;
import com.aowin.scm.utils.DBUtil;


/**
 * @author ��С��
 * date:2018��11��15�� ����12:02:56
 * 
 */
public class StorageDAOImpl implements StorageDAO {
	private Logger log = Logger.getLogger(StorageDAOImpl.class);
	/**
	 * 
	 */
	public StorageDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.storagemanage.dao.StorageDAO#updaPurByProID(int)
	 */
	@Override
	public boolean updaPurByProID(int proID,String onPurchaseNum) {
		log.info("����ҵ���߼�������updaPurByProID(int proID,String onPurchaseNum)");
		boolean result = false;
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(STORAGE_UPDATE_ONPURCHASENUM_SQL);
		try {
			ps.setString(1, onPurchaseNum);
			ps.setInt(2, proID);
			int i = ps.executeUpdate();
			if(i != 0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.psClose(ps);
			db.connClose();
		}
		db =  null;
		return result;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.storagemanage.dao.StorageDAO#updaSaleByProID(int)
	 */
	@Override
	public boolean updaSaleByProID(int proID,String onPresaleNum) {
		log.info("����ҵ���߼�������updaSaleByProID(int proID,String onPresaleNum)");
		boolean result = false;
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(STORAGE_UPDATE_ONPRESALENUM_SQL);
		try {
			ps.setString(1, onPresaleNum);
			ps.setInt(2, proID);
			int i = ps.executeUpdate();
			if(i != 0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.psClose(ps);
			db.connClose();
		}
		db =  null;
		return result;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.storagemanage.dao.StorageDAO#insertStorage(com.aowin.scm.storagemanage.pojo.Storage)
	 */
	@Override
	public boolean insertStorage(Storage storage) {
		log.info("����ҵ���߼�������insertStorage(Storage storage)");
		boolean result = false;
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(STORAGE_INSERT_SQL);
		try {
			ps.setInt(1, storage.getProID());
			ps.setString(2, storage.getProName());
			ps.setString(3,storage.getProUnit());
			ps.setInt(4, storage.getProtypeid());
			ps.setInt(5,storage.getPresentNum());
			ps.setInt(6,storage.getOnPurchaseNum());
			ps.setInt(7, storage.getOnPresaleNum());
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
	 * @see com.aowin.scm.storagemanage.dao.StorageDAO#getStorage(int)
	 */
	@Override
	public List<Storage> getStorage(int proID) {
		log.info("����ҵ���߼�������getStorage(int proID)");
		List<Storage> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(STOTRAGE_SELECT_SQL);
		ResultSet rs = null;
		try {
			ps.setInt(1, proID);
			rs = ps.executeQuery();
			while(rs.next()) {
				Storage ninfo = new  Storage();
				ninfo.setProID(rs.getInt("proID"));
				ninfo.setProName(rs.getString("proName"));
				ninfo.setProUnit(rs.getString("proUnit"));
				ninfo.setPresentNum(rs.getInt("presentNum"));
				ninfo.setOnPurchaseNum(rs.getInt("onPurchaseNum"));
				ninfo.setOnPresaleNum(rs.getInt("onPresaleNum"));
				list.add(ninfo);
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
	 * @see com.aowin.scm.storagemanage.dao.StorageDAO#getPanStorage()
	 */
	@Override
	public List<Storage> getPanStorage() {
		log.info("����ҵ���߼�������getPanStorage()");
		List<Storage> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(STOTRAGE_SELECT_PAN_SQL);
		ResultSet rs = null;
		try {
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Storage ninfo = new  Storage();
				ninfo.setProID(rs.getInt("proID"));
				ninfo.setProName(rs.getString("proName"));
				
				ninfo.setPresentNum(rs.getInt("presentNum"));
				ninfo.setOnPurchaseNum(rs.getInt("onPurchaseNum"));
				ninfo.setOnPresaleNum(rs.getInt("onPresaleNum"));
				list.add(ninfo);
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
	 * @see com.aowin.scm.storagemanage.dao.StorageDAO#getCountStorage(int, int)
	 */
	@Override
	public List<Storage> getCountStorage(int pages, int pagesize) {
		log.info("����ҵ���߼�������getCountStorage(int pages, int pagesize)");
		List<Storage> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(COUNT_SELECT_STORAGE_SQL);
		ResultSet rs = null;
		try {
			ps.setInt(1, (pages-1)*pagesize);
			ps.setInt(2, pagesize);
			rs = ps.executeQuery();
			while(rs.next()) {
				Storage ninfo = new  Storage();
				ninfo.setProID(rs.getInt("proID"));
				ninfo.setProName(rs.getString("proName"));
				
				ninfo.setPresentNum(rs.getInt("presentNum"));
				ninfo.setOnPurchaseNum(rs.getInt("onPurchaseNum"));
				ninfo.setOnPresaleNum(rs.getInt("onPresaleNum"));
				list.add(ninfo);
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
	 * @see com.aowin.scm.storagemanage.dao.StorageDAO#getStorageTotalPages(int)
	 */
	@Override
	public int getStorageTotalPages(int pagesize) {
		log.info("����ҵ���߼�������getStorageTotalPages(int pagesize) ");
		int totalpages = 1;
		
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(COUNT_SELECT_PRO_SQL);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			rs.next();
			int totalrecords = rs.getInt(1);
		
			totalpages = (totalrecords%pagesize==0?0:1) + totalrecords/pagesize;   
		} catch (SQLException e) {
			log.warn("���ݲ�ѯʧ��: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}		
		if(totalpages == 0) {
			totalpages = 1;
		}
		db = null;
		return totalpages;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.storagemanage.dao.StorageDAO#getNum(int)
	 */
	@Override
	public int getNum(int pagesize) {
		log.info("����ҵ���߼�������getNum(int pagesize) ");
		int totalpages = 0;
	
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(COUNT_SELECT_PRO_SQL);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			rs.next();
			totalpages = rs.getInt(1);
			
		} catch (SQLException e) {
			log.warn("���ݲ�ѯʧ��: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}		
			db = null;
			return totalpages;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.storagemanage.dao.StorageDAO#updaPersentNum(int, int)
	 */
	@Override
	public boolean updaPersentNum(int proID, int presentNum) {
		boolean result = false;
		log.info("����ҵ���߼�������updaPersentNum(int proID, int presentNum) ");
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(STORAGE_UPDATE_PRESENTNUM_SQL);
		try {
			ps.setInt(1, presentNum);
			ps.setInt(2, proID);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db = null;
		return result;
	}
	/** 
	 * ����ѡ���������ѯ������
	 * @param sql
	 * @return �����Ϣ����
	 */
	public List<Storage> getSelect(String sql){
		log.info("����ҵ���߼�������getPanStorage()");
		List<Storage> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(sql);
		ResultSet rs = null;
		try {
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Storage ninfo = new  Storage();
				ninfo.setProID(rs.getInt("proID"));
				ninfo.setProName(rs.getString("proName"));
				
				ninfo.setPresentNum(rs.getInt("presentNum"));
				ninfo.setOnPurchaseNum(rs.getInt("onPurchaseNum"));
				ninfo.setOnPresaleNum(rs.getInt("onPresaleNum"));
				list.add(ninfo);
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
	 * @see com.aowin.scm.storagemanage.dao.StorageDAO#updaRKBID(int, int, int)
	 */
	@Override
	public boolean updaRKBID(int proid, int presentNum, int onPurchaseNum) {
		boolean result = false;
		log.info("����ҵ���߼�������updaRKBID(int proid, int presentNum, int onPurchaseNum)");
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(STORAGE_RKBYID_SQL);
		try {
			ps.setInt(1, onPurchaseNum);
			ps.setInt(2, presentNum);
			ps.setInt(3, proid);
			ps.executeUpdate();
		} catch (SQLException e) {
			log.info("����ҵ���߼�������updaRKBID(int proid, int presentNum, int onPurchaseNum)ʧ��");
		}
		db = null;
		return result;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.storagemanage.dao.StorageDAO#updaCKBYID(int, int, int)
	 */
	@Override
	public boolean updaCKBYID(int proid, int presentNum, int onPresaleNum) {
		boolean result = false;
		log.info("����ҵ���߼�������updaCKBYID(int proid, int presentNum, int onPresaleNum)");
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(STORAGE_CKBYID_SQL);
		try {
			ps.setInt(1, onPresaleNum);
			ps.setInt(2, presentNum);
			ps.setInt(3, proid);
			ps.executeUpdate();
		} catch (SQLException e) {
			log.info("����ҵ���߼�������updaCKBID(int proid, int presentNum, int onPurchaseNum)ʧ��");
		}
		db = null;
		return result;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.storagemanage.dao.StorageDAO#getStorageALL()
	 */
	@Override
	public Storage getStorageALL(int proID) {
		log.info("����ҵ���߼�������getStorageALL(int proID)");
		Storage s = new Storage();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(STOTRAGE_SELECT_ALL_SQL);
		ResultSet rs = null;
		try {
			ps.setInt(1, proID);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				s.setProID(rs.getInt("proID"));
				s.setProName(rs.getString("proName"));
				s.setProUnit(rs.getString("proUnit"));
				s.setPresentNum(rs.getInt("presentNum"));
				s.setOnPurchaseNum(rs.getInt("onPurchaseNum"));
				s.setOnPresaleNum(rs.getInt("onPresaleNum"));
				
			}
		} catch (SQLException e) {
			log.warn("���ݲ�ѯʧ��: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null; 
		return s;
	}
	//===���� ===���� ===���� ===���� ===���� ===���� ===���� ===���� ===���� ===���� ===���� ===���� ===���� ===���� 
	@Override
	public List<Storage> getStorage() {
		log.info("����ҵ���߼�������getStorage()");
		List<Storage> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(STOTRAGE_SELECT_PIO_SQL);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			while(rs.next()) {
				Storage storage = new  Storage();
				storage.setProID(rs.getInt("proID"));
				storage.setProName(rs.getString("proName"));
				storage.setProUnit(rs.getString("proUnit"));
				list.add(storage);
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
	public boolean updateOnPurchaseNum(int proID, int num) {
		log.info("����ҵ���߼�������updateOnPurchaseNum(int proID, int num)");
		boolean result = false;
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(STOTRAGE_UPD_PIO_SQL);
		try {
			
			ps.setInt(1,num );
			ps.setInt(2,proID );
			log.info(ps);
			int i = ps.executeUpdate();
			if(i != 0) {
				result = true;
				log.info("��;���޸ĳɹ�");
			}
		} catch (SQLException e) {
			log.warn("��;���޸�ʧ��: " + e);
		//	e.printStackTrace();
		} finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return result;
	}
}
