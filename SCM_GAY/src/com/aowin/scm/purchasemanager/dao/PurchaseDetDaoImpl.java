package com.aowin.scm.purchasemanager.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aowin.scm.purchasemanager.pojo.Purchase;
import com.aowin.scm.purchasemanager.pojo.PurchaseDet;
import com.aowin.scm.utils.DBUtil;

import sun.java2d.pipe.OutlineTextRenderer;

public class PurchaseDetDaoImpl implements PurchaseDetDao {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public boolean insertPurchaseDet(PurchaseDet purchasedet) {
		log.info("调用业务逻辑方法：insertPurchase(PurchaseDet purchasedet)");
		boolean result = false;
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(PURCHASEDET_INSERT_SQL);
		try {
			ps.setInt(1, purchasedet.getProid());
			ps.setString(2, purchasedet.getProname());
			ps.setInt(3, purchasedet.getPronum());
			ps.setString(4,purchasedet.getProunit());
			ps.setFloat(5, purchasedet.getUnitprice());
			ps.setFloat(6, purchasedet.getTotalprice());
			ps.setString(7, purchasedet.getPurchaseid());
			int i = ps.executeUpdate();
			if(i != 0) {
				result = true;
				log.info("采购单详情表添加成功");
			}
		} catch (SQLException e) {
			log.warn("采购单详情表添加失败: " + e);
		//	e.printStackTrace();
		} finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return result;
	}
	@Override
	public boolean deletePurchaseDet(String purchaseid) {
		log.info("开始执行 deletePurchaseDet(int purchaseid)，通过采购单号删除采购明细数据");
		DBUtil db = new DBUtil();
		boolean  flag = false;
		PreparedStatement ps = db.getPreparedStatement(PURCHASEDET_DELETE_SQL);
		try {
			ps.setString(1, purchaseid);
			int i  = ps.executeUpdate();
			if(i > 0) {
				flag = true;
				log.info("采购明细删除成功");
			}
			log.info("删除了"+i+"条采购明细信息");
		} catch (SQLException e) {
			log.warn("采购明细删除失败"+e);
		}finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return flag;
	}

	@Override
	public boolean updatePurchaseDet(PurchaseDet purchasedet) {
		log.info("开始执行updatePurchaseDet(PurchaseDet purchasedet)，通过采购明细修改采购单明细表");
		DBUtil db = new DBUtil();
		boolean flag = false;
		//select detid,proid,proname,pronum,prounit,unitprice,totalprice from purchase_det where purchaseid=?
		String PURDET_UPDATE = "update purchase_det set pronum = ?,unitprice= ?,totalprice=? where detid = ?";
		PreparedStatement ps = db.getPreparedStatement(PURDET_UPDATE);
		try {
			ps.setInt(1, purchasedet.getPronum());
			ps.setFloat(2, purchasedet.getUnitprice());
			ps.setFloat(3, purchasedet.getTotalprice());
			ps.setInt(4, purchasedet.getDetid());
			int i = ps.executeUpdate();
			if(i > 0) {
				flag = true;
				log.info("修改明细表成功！");
			}else {
				log.info("修改明细表失败");
			}
		} catch (SQLException e) {
			log.warn("修改明细表失败"+e);
		}finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return flag;
	}

	@Override
	public List<PurchaseDet> selectPurchaseDet(String purchaseid) {
		log.info("开始执行selectPurchaseDet(int purchaseid) ，通过采购单号查询采购明细");
		DBUtil db = new DBUtil();
		List<PurchaseDet> list = new ArrayList<PurchaseDet>();
		PreparedStatement ps = db.getPreparedStatement(PURCHASEDET_SELECT_SQL);
		ResultSet rs = null;
		//"select detid,proid,proname,pronum,prounit,unitprice,totalprice from purchase_det where purchaseid=?";
		try {
			ps.setString(1, purchaseid);
			rs = ps.executeQuery();
			while(rs.next()) {
				PurchaseDet purDet = new PurchaseDet();
				purDet.setDetid(rs.getInt("detid"));
				purDet.setProid(rs.getInt("proid"));
				purDet.setProname(rs.getString("proname"));
				purDet.setPronum(rs.getInt("pronum"));
				purDet.setProunit(rs.getString("prounit"));
				purDet.setUnitprice(rs.getFloat("unitprice"));
				purDet.setPurchaseid(purchaseid);
				list.add(purDet);
			}
			log.info("总共查询出"+list.size()+"条采购明细数据");
		} catch (SQLException e) {
			log.warn("采购明细查询失败"+e);
		}finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return list;
	}
	//===============================================================
	@Override
	public boolean updateStorageByPurchaseDet(PurchaseDet purchaseDet) {
		log.info("开始执行 updateStorageByPurchaseDet(PurchaseDet purchaseDet) ，通过采购明细对象来减少采购在途数");
		DBUtil db = new DBUtil();
		boolean  flag = false;
		PreparedStatement ps = db.getPreparedStatement(SEORAGE_UPDATE_BY_PURCHASEID);
		try {
			ps.setInt(1, purchaseDet.getPronum());
			ps.setInt(2, purchaseDet.getProid());
			int i  = ps.executeUpdate();
			if(i > 0) {
				flag = true;
				log.info("采购在途数修改成功");
			}else {
				log.info("采购在途数修改失败");
			}
		} catch (SQLException e) {
			log.warn("采购在途数修改失败"+e);
		}finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return flag;
	}
	/* (non-Javadoc)
	 * @see com.aowin.scm.purchasemanager.dao.PurchaseDetDao#deletePurchaseDetByDetid(int)
	 */
	@Override
	public boolean deletePurchaseDetByDetid(int detid) {
		log.info("开始执行  deletePurchaseDetByDetid(int detid) ，通过采购单明细删除采购单");
		DBUtil db = new DBUtil();
		boolean  flag = false;
		PreparedStatement ps = db.getPreparedStatement(PURDET_DELETE_DETID);
		try {
			ps.setInt(1, detid);
			int i  = ps.executeUpdate();
			if(i > 0) {
				flag = true;
				log.info("采购明细删除成功");
			}
			log.info("删除了"+i+"条采购明细信息");
		} catch (SQLException e) {
			log.warn("采购明细删除失败"+e);
		}finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return flag;
	}
	
}
