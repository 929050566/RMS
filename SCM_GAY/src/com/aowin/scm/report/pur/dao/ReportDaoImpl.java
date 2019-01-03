package com.aowin.scm.report.pur.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aowin.scm.report.pur.pojo.Report;
import com.aowin.scm.utils.DBUtil;

public class ReportDaoImpl implements ReportDao {

	private Logger log = Logger.getLogger(ReportDaoImpl.class);

	public int getTotalLines() {
		log.info("开始执行getTotalLines()方法，在purchase表中查询总行数");
		DBUtil db = new DBUtil();
		int count = 0;
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_SELECT_COUNT_SQL);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("total");
				log.info("成功查询出所有行数");
			}
		} catch (SQLException e) {
			log.warn("查询失败"+e);
		}finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return count;
	}

	@Override
	public int getTotalLinesBydisposestate() {
		log.info("开始执行getTotalLinesBydisposestate()方法");
		DBUtil db = new DBUtil();
		int count = 0;
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_SELECT_COUNT_SQL_BY_DISPOSESTATE);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("total");
				log.info("成功查询出所有行数");
			}
		} catch (SQLException e) {
			log.warn("查询失败"+e);
		}finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return count;
	}

	@Override
	public List<Float> gettotalprices() {
		log.info("调用业务逻辑方法：List<Float> gettotalprices()");
		List<Float> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_SELECT_ALLTOTALPRICESE_SQL);
		ResultSet rs = null;
		try {
		
			rs = ps.executeQuery();
				while(rs.next()) {
					
					list.add(rs.getFloat("totalprices"));
			}
				log.info(list);
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

	@Override
	public List<Float> gettotalpricesBydisposestate() {
		log.info("调用业务逻辑方法：List<Float> gettotalpricesBydisposestate()");
		List<Float> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_SELECT_TOTALPRICESE_BY_DISPOSESTATA_SQL);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
				while(rs.next()) {
					list.add(rs.getFloat("totalprices"));
					
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

	@Override
	public List<Float> getadvancepriceBydisposestate() {
		log.info("调用业务逻辑方法：List<Float> getadvancepriceBydisposestate()");
		List<Float> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_SELECT_ADVANCEPRICESE_BY_DISPOSESTATA_SQL);
		ResultSet rs = null;
		try {
			
			rs = ps.executeQuery();
				while(rs.next()) {
					
					list.add(rs.getFloat("advanceprice"));
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

	@Override
	public List<Report> getReport(int page, int size) {
		log.info("开始执行getPurchaseByCondition()，查询出可了结的采购单");
		DBUtil db = new DBUtil();
		List<Report> list = new ArrayList<Report>(); 
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_SELECT_ALL_SQL);
		ResultSet rs = null;
		try {
			ps.setInt(1, (page-1)*size);
			ps.setInt(2, size);
			rs = ps.executeQuery();
			while(rs.next()) {
				Report purchase = new Report();
				purchase.setPurchaseid(rs.getString("purchaseid"));
				purchase.setCreatetime(rs.getString("createtime"));
				purchase.setSuppliername(rs.getString("suppliername"));
				purchase.setCreatename(rs.getString("createname"));
				purchase.setAdvanceprice(rs.getFloat("advanceprice"));
				purchase.setTotalprices(rs.getFloat("totalprices"));
				purchase.setPaystate(rs.getString("paystate"));
				purchase.setDisposestate(rs.getString("disposestate"));
				if("5".equals(rs.getString("disposestate"))) {
					purchase.setNopuy(rs.getFloat("totalprices")-rs.getFloat("advanceprice"));
				}else if("3".equals(rs.getString("disposestate"))||"4".equals(rs.getString("disposestate"))) {
					purchase.setNopuy(0);
				}else if("1".equals(rs.getString("disposestate"))||"2".equals(rs.getString("disposestate"))) {
					purchase.setNopuy(rs.getFloat("totalprices"));
				}
				list.add(purchase);
			}
			log.info("成功查询出"+list.size()+"条采购单数据");
		} catch (SQLException e) {
			log.warn("查询失败"+e);
		}finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return list;
	}

	@Override
	public int getTotalPages(int pagesize) {
		log.info("调用业务逻辑方法：getTotalPages(int pagesize)");
		int totalpages = 1;
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_SELECT_COUNT_SQL);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			rs.next();
			int totalrecords = rs.getInt(1);
			totalpages = (totalrecords%pagesize==0?0:1) + totalrecords/pagesize;   
		} catch (SQLException e) {
			log.warn("数据查询失败: " + e);
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

	@Override
	public List<Report> getReportBySql(String sql) {
		log.info("开始执行getPurchaseBySql(String sql)，通过sql语句查询采购单集合");
		DBUtil db = new DBUtil();
		List<Report> list = new ArrayList<Report>(); 
		PreparedStatement ps = db.getPreparedStatement(sql);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			while(rs.next()) {
				Report purchase = new Report();
				purchase.setPurchaseid(rs.getString("purchaseid"));
				purchase.setCreatetime(rs.getString("createtime"));
				purchase.setSuppliername(rs.getString("suppliername"));
				purchase.setCreatename(rs.getString("createname"));
				purchase.setAdvanceprice(rs.getFloat("advanceprice"));
				purchase.setTotalprices(rs.getFloat("totalprices"));
				purchase.setPaystate(rs.getString("paystate"));
				purchase.setDisposestate(rs.getString("disposestate"));
				if("5".equals(rs.getString("disposestate"))) {
					purchase.setNopuy(rs.getFloat("totalprices")-rs.getFloat("advanceprice"));
				}else if("3".equals(rs.getString("disposestate"))||"4".equals(rs.getString("disposestate"))) {
					purchase.setNopuy(0);
				}else if("1".equals(rs.getString("disposestate"))||"2".equals(rs.getString("disposestate"))) {
					purchase.setNopuy(rs.getFloat("totalprices"));
				}
				list.add(purchase);
				}
			log.info(list);
		} catch (SQLException e) {
			log.warn("查询失败"+e);
			log.warn("错误的sql语句:"+sql);
		}finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return list;
	}

	
	
}
