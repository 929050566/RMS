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
		log.info("��ʼִ��getTotalLines()��������purchase���в�ѯ������");
		DBUtil db = new DBUtil();
		int count = 0;
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_SELECT_COUNT_SQL);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("total");
				log.info("�ɹ���ѯ����������");
			}
		} catch (SQLException e) {
			log.warn("��ѯʧ��"+e);
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
		log.info("��ʼִ��getTotalLinesBydisposestate()����");
		DBUtil db = new DBUtil();
		int count = 0;
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_SELECT_COUNT_SQL_BY_DISPOSESTATE);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("total");
				log.info("�ɹ���ѯ����������");
			}
		} catch (SQLException e) {
			log.warn("��ѯʧ��"+e);
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
		log.info("����ҵ���߼�������List<Float> gettotalprices()");
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
	public List<Float> gettotalpricesBydisposestate() {
		log.info("����ҵ���߼�������List<Float> gettotalpricesBydisposestate()");
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
	public List<Float> getadvancepriceBydisposestate() {
		log.info("����ҵ���߼�������List<Float> getadvancepriceBydisposestate()");
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
	public List<Report> getReport(int page, int size) {
		log.info("��ʼִ��getPurchaseByCondition()����ѯ�����˽�Ĳɹ���");
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
			log.info("�ɹ���ѯ��"+list.size()+"���ɹ�������");
		} catch (SQLException e) {
			log.warn("��ѯʧ��"+e);
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
		log.info("����ҵ���߼�������getTotalPages(int pagesize)");
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

	@Override
	public List<Report> getReportBySql(String sql) {
		log.info("��ʼִ��getPurchaseBySql(String sql)��ͨ��sql����ѯ�ɹ�������");
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
			log.warn("��ѯʧ��"+e);
			log.warn("�����sql���:"+sql);
		}finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return list;
	}

	
	
}
