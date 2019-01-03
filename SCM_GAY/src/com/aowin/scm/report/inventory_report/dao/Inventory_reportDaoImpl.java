package com.aowin.scm.report.inventory_report.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aowin.scm.report.inventory_report.pojo.Inventory_report;
import com.aowin.scm.utils.DBUtil;


public class Inventory_reportDaoImpl implements Inventory_reportDao {

	private Logger log = Logger.getLogger(Inventory_reportDaoImpl.class);
	public Inventory_reportDaoImpl() {
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public int getTotalLines() {
		log.info("��ʼִ��getTotalLines()����");
		DBUtil db = new DBUtil();
		int count = 0;
		PreparedStatement ps = db.getPreparedStatement(REPORT_SELECT_COUNT_SQL);
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
	public List<Integer> gettotalpresentNum() {
		log.info("����ҵ���߼�������List<Integer> gettotalpresentNum()");
		List<Integer> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(REPORT_SELECT_PRESENTNUM_SQL);
		ResultSet rs = null;
		try {
		
			rs = ps.executeQuery();
				while(rs.next()) {
					
					list.add(rs.getInt("presentNum"));
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
	public List<Inventory_report> getInventory_Report(int page, int size) {
		log.info("��ʼִ�� List<Inventory_report> getInventory_Report(int page, int size)");
		DBUtil db = new DBUtil();
		List<Inventory_report> list = new ArrayList<Inventory_report>(); 
		PreparedStatement ps = db.getPreparedStatement(REPORT_SELECT_ALL_SQL);
		ResultSet rs = null;
		try {
			ps.setInt(1, (page-1)*size);
			ps.setInt(2, size);
			rs = ps.executeQuery();
			while(rs.next()) {
				Inventory_report purchase = new Inventory_report();
				purchase.setProID(rs.getInt("ProID"));
				purchase.setProName(rs.getString("ProName"));
				purchase.setPresentNum(rs.getInt("presentNum"));
				list.add(purchase);
			}
			log.info(list);
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
		PreparedStatement ps = db.getPreparedStatement(REPORT_SELECT_COUNT_SQL);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			rs.next();
			int totalrecords = rs.getInt(1);
			totalpages = (totalrecords%pagesize==0?0:1) + totalrecords/pagesize;
			System.out.println(totalrecords);
			System.out.println(totalpages);
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
	public List<Inventory_report> getInventoryBySql(String sql) {
		log.info("��ʼִ��List<Inventory_report> getInventoryBySql(String sql)");
		DBUtil db = new DBUtil();
		List<Inventory_report> list = new ArrayList<Inventory_report>(); 
		PreparedStatement ps = db.getPreparedStatement(sql);
		ResultSet rs = null;
		try {
	
			rs = ps.executeQuery();
			while(rs.next()) {
				Inventory_report purchase = new Inventory_report();
				purchase.setProID(rs.getInt("ProID"));
				purchase.setProName(getNameById(rs.getInt("ProID")));
				purchase.setNum(rs.getInt("outNum"));
				purchase.setCreatename(rs.getString("outStorageDate"));
				list.add(purchase);
			}
			log.info(list);
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
	public String getNameById(int id) {
		log.info("��ʼִ��getTotalLines()����");
		DBUtil db = new DBUtil();
		String  name = null;
		PreparedStatement ps = db.getPreparedStatement(REPORT_SELECT_NAME_BY_ID_SQL);
		ResultSet rs = null;
		try {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				name = rs.getString("proName");
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
		return name;
	}

	@Override
	public List<Inventory_report> getInInventoryBySql(String sql) {
		log.info("��ʼִ��List<Inventory_report> getInventoryBySql(String sql)");
		DBUtil db = new DBUtil();
		List<Inventory_report> list = new ArrayList<Inventory_report>(); 
		PreparedStatement ps = db.getPreparedStatement(sql);
		ResultSet rs = null;
		try {
	
			rs = ps.executeQuery();
			while(rs.next()) {
				Inventory_report purchase = new Inventory_report();
				purchase.setProID(rs.getInt("ProID"));
				purchase.setProName(getNameById(rs.getInt("ProID")));
				log.info(rs.getInt("inNum"));
				purchase.setNum(rs.getInt("inNum"));
				purchase.setCreatename(rs.getString("inStorageDate"));
				list.add(purchase);
			}
			log.info(list);
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

}
