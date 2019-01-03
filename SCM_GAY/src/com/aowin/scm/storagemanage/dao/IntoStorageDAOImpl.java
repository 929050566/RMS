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

import com.aowin.scm.storagemanage.pojo.IntoStorage;
import com.aowin.scm.utils.DBUtil;


/**
 * @author 李小龙
 * date:2018年11月15日 下午3:09:07
 * 
 */
public class IntoStorageDAOImpl implements IntoStorageDAO {
	private Logger log = Logger.getLogger(IntoStorageDAOImpl.class);
	/**
	 * 
	 */
	public IntoStorageDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.storagemanage.dao.IntoStorageDAO#getIntoStorage()
	 */
	@Override
	public List<IntoStorage> getIntoStorage() {
		log.info("调用业务逻辑方法：getIntoStorage()");
		List<IntoStorage> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(INTOSTORAGE_SELECT_SQL);
		ResultSet rs = null;
		try {
			
			rs = ps.executeQuery();
			while(rs.next()) {
				IntoStorage n = new  IntoStorage();
				n.setInId(rs.getInt("inId"));
				n.setInStorageDate(rs.getString("inStorageDate"));
				n.setInoHandle(rs.getString("inoHandle"));
				n.setInNum(rs.getInt("inNum"));
				n.setInState(rs.getString("inState"));
				n.setReason(rs.getString("reason"));
				n.setPurchase_detid(rs.getInt("purchase_detid"));
				n.setPurchaseid(rs.getString("purchaseid"));
				list.add(n);
			}
		} catch (SQLException e) {
			log.warn("数据查询失败: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null; 
		return list;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.storagemanage.dao.IntoStorageDAO#insertPandian()
	 */
	@Override
	public boolean insertPandian(IntoStorage storage) {
		log.info("调用业务逻辑方法：insertPandian(IntoStorage storage)");
		boolean result = false;
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(INTOSTORAGE_INSERT_SQL);
		try {
			ps.setInt(1, storage.getInNum());
			//ps.setString(2, storage.getInState());
			ps.setString(2, storage.getInoHandle());
			ps.setString(3,storage.getReason());
			ps.setInt(4, storage.getProId());
			//ps.setString(5,storage.getInStorageDate());
			int i = ps.executeUpdate();
			if(i != 0) {
				result = true;
				log.info("类别添加成功");
			}
		} catch (SQLException e) {
			log.warn("类别添加失败: " + e);
		//	e.printStackTrace();
		} finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return result;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.storagemanage.dao.IntoStorageDAO#insertIntoStorage()
	 */
	@Override
	public boolean insertIntoStorage(IntoStorage storage) {
		log.info("调用业务逻辑方法：insertIntoStorage(IntoStorage storage)");
		boolean result = false;
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(INTOSTORAGE_INSERT_ALL_SQL);
		try {
			
			//ps.setString(1, storage.getInStorageDate());
			ps.setString(1, storage.getInoHandle());
			ps.setInt(2, storage.getInNum());
			//ps.setString(2, storage.getInState());
			//ps.setString(2,storage.getReason());
			ps.setInt(3, storage.getPurchase_detid());
			ps.setString(4,storage.getPurchaseid());
			int i = ps.executeUpdate();
			if(i != 0) {
				result = true;
				log.info("类别添加成功");
			}
		} catch (SQLException e) {
			log.warn("类别添加失败: " + e);
		//	e.printStackTrace();
		} finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return result;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.storagemanage.dao.IntoStorageDAO#getInto(java.lang.String)
	 */
	@Override
	public IntoStorage getInto(String purchaseid) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.storagemanage.dao.IntoStorageDAO#getPAN()
	 */
	@Override
	public List<IntoStorage> getPAN(int purchase_detid) {
		log.info("调用业务逻辑方法：getPAN()");
		List<IntoStorage> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(INTO_STORAGEPAN_SELECT_SQL);
		ResultSet rs = null;
		try {
			ps.setInt(1, purchase_detid);
			rs = ps.executeQuery();
			while(rs.next()) {
				IntoStorage n = new  IntoStorage();
				n.setInStorageDate(rs.getString("inStorageDate"));
				n.setInoHandle(rs.getString("inoHandle"));
				n.setInNum(rs.getInt("inNum"));
				n.setInState(rs.getString("inState"));
				n.setReason(rs.getString("reason"));
				n.setPurchase_detid(rs.getInt("purchase_detid"));
			
				list.add(n);
			}
		} catch (SQLException e) {
			log.warn("库存更新数据查询失败: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null; 
		return list;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.storagemanage.dao.IntoStorageDAO#getIntoStorageByid(int)
	 */
	@Override
	public List<IntoStorage> getIntoStorageByid(int purchase_detid) {
		log.info("调用业务逻辑方法：getIntoStorageByid(int purchase_detid)");
		List<IntoStorage> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(INTOSTORAGE_BIAN_SELECT_BYPURID_SQL);
		ResultSet rs = null;
		try {
			ps.setInt(1, purchase_detid);
			rs = ps.executeQuery();
			while(rs.next()) {
				IntoStorage n = new  IntoStorage();
				n.setInStorageDate(rs.getString("inStorageDate"));
				n.setInoHandle(rs.getString("inoHandle"));
				n.setInNum(rs.getInt("inNum"));
				n.setInState(rs.getString("inState"));
				n.setPurchaseid(rs.getString("purchaseid"));
				list.add(n);
			}
		} catch (SQLException e) {
			log.warn("数据查询失败: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null; 
		return list;
	}

}
