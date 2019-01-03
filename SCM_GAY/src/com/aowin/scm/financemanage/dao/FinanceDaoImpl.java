package com.aowin.scm.financemanage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aowin.scm.financemanage.pojo.Finance;
import com.aowin.scm.financemanage.pojo.FinanceInfo;
import com.aowin.scm.purchasemanager.pojo.Purchase;
import com.aowin.scm.salemanage.pojo.SaleMangeModel;
import com.aowin.scm.utils.DBUtil;

public class FinanceDaoImpl implements FinanceDao {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	public FinanceDaoImpl() {
		
	}

	@Override
	public boolean insertPurchase(Finance finance) {
		log.info("开始执行insertPurchase(Finance finance) ，通过财务对象向finance表中插入一行数据");
		DBUtil db = new DBUtil();
		boolean  flag = false;
		PreparedStatement ps = db.getPreparedStatement(FINANCE_INSERT_PURCHASE);
		//insert into finance (date,theway,handle,purchaseid) values (NOW(),?,?,?)
		try {
			ps.setString(1, finance.getTheway());
			ps.setString(2, finance.getHandle());
			ps.setString(3, finance.getPurchaseid());
			int i  = ps.executeUpdate();
			if(i > 0) {
				flag = true;
				log.info("财务信息添加成功");
			}else {
				log.info("财务信息添加失败");
			}
		} catch (SQLException e) {
			log.warn("财务添加失败"+e);
		}finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return flag;
	}

	@Override
	public boolean insertSale(Finance finance) {
		log.info("开始执行insertSale(Finance finance) ，通过财务对象向finance表中插入一行数据");
		DBUtil db = new DBUtil();
		boolean  flag = false;
		PreparedStatement ps = db.getPreparedStatement(FINANCE_INSERT_SALE);
		//insert into finance (date,theway,handle,salebillid) values (NOW(),?,?,?)
		try {
			ps.setString(1, finance.getTheway());
			ps.setString(2, finance.getHandle());
			ps.setString(3, finance.getSalebillid());
			int i  = ps.executeUpdate();
			if(i > 0) {
				flag = true;
				log.info("财务信息添加成功");
			}else {
				log.info("财务信息添加失败");
			}
		} catch (SQLException e) {
			log.warn("财务添加失败"+e);
		}finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return flag;
	}

	@Override
	public boolean updatePurchase(String purchaseid, String disposestate) {
		log.info("开始执行updatePurchase(String purchaseid, String disposestate) ，通过采购单编号，修改采购单状态");
		DBUtil db = new DBUtil();
		boolean  flag = false;
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_UPDATE_DISPOSESTATE);
		//update purchase set disposestate = ? where purchaseid = ? 
		try {
			ps.setString(1, disposestate);
			ps.setString(2, purchaseid);
			int i  = ps.executeUpdate();
			if(i > 0) {
				flag = true;
				log.info("修改采购单状态成功");
			}else {
				log.info("修改采购单状态失败");
			}
		} catch (SQLException e) {
			log.warn("修改采购单状态失败"+e);
		}finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return flag;
	}

	@Override
	public boolean updateSale(String salebillid, String disposestate) {
		log.info("开始执行 updateSale(String salebillid, String disposestate) ，通过销售单编号，修改销售单状态");
		DBUtil db = new DBUtil();
		boolean  flag = false;
		PreparedStatement ps = db.getPreparedStatement(SALE_UPDATE_DISPOSESTATE);
		//update salebillid set disposestate = ? where salebillid = ? 
		try {
			ps.setString(1, disposestate);
			ps.setString(2, salebillid);
			int i  = ps.executeUpdate();
			if(i > 0) {
				flag = true;
				log.info("修改销售单状态成功");
			}else {
				log.info("修改销售单状态失败");
			}
		} catch (SQLException e) {
			log.warn("修改销售单状态失败"+e);
		}finally {
			db.psClose(ps);
			db.connClose();
		}
		db = null;
		return flag;
	}

	@Override
	public int getCountByCondition() {
		//select count(purchaseid) as total from purchase where (paystate = 1 and disposestate = 2) or (paystate = 2 and disposestate = 1) or (paystate = 3 and disposestate = 1) or (paystate = 3 and disposestate = 2) 
		log.info("开始执行getCountByCondition(),获得可收款登记的所有采购单数量");
		DBUtil db = new DBUtil();
		int count = 0;
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_SELECT_COUNT_CONDITION);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			if(rs.next() ) {
				count = rs.getInt("total");
			}
			log.info("成功查询出的行数为:"+count);
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
	public List<Purchase> getListByCondition(int start, int size) {
		//select * as total from purchase where (paystate = 1 and disposestate = 2) or (paystate = 2 and disposestate = 1) or (paystate = 3 and disposestate = 1) or (paystate = 3 and disposestate = 2) order by purchaseid desc limit ?,? 
		log.info("开始执行getListByCondition(int start, int size) ，查询出可付款和预付款的采购单");
		DBUtil db = new DBUtil();
		ArrayList<Purchase> list = new ArrayList<Purchase>(); 
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_SELECT_LIST_CONDITION);
		ResultSet rs = null;
		try {
			ps.setInt(1, start);
			ps.setInt(2, size);
			rs = ps.executeQuery();
			while(rs.next()) {
				Purchase purchase = new Purchase();
				purchase.setPurchaseid(rs.getString("purchaseid"));
				purchase.setCreatetime(rs.getString("createtime"));
				purchase.setSuppliername(rs.getString("suppliername"));
				purchase.setCreatename(rs.getString("createname"));
				purchase.setExtramoney(rs.getFloat("extramoney"));
				purchase.setTotalproprices(rs.getFloat("totalproprices"));
				purchase.setAdvanceprice(rs.getFloat("advanceprice"));
				purchase.setTotalprices(rs.getFloat("totalprices"));
				purchase.setPaystate(rs.getString("paystate"));
				purchase.setComment(rs.getString("comment"));
				purchase.setDisposestate(rs.getString("disposestate"));
				purchase.setCloseDate(rs.getString("closeDate"));
				purchase.setCloseUser(rs.getString("closeUser"));
				purchase.setUserid(rs.getInt("userid"));
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
	public int getCountByConditionAndPaystate(String paystate) {
		//select count(purchaseid) as total from purchase where ((paystate = 1 and disposestate = 2) or (paystate = 2 and disposestate = 1) or (paystate = 3 and disposestate = 1) or (paystate = 3 and disposestate = 2)) and (paystate = ?) 
		log.info("开始执行getCountByConditionAndPaystate(String paystate)，通过处理状态查询出可付款和预付的采购单的总条数数量");
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_SELECT_COUNT_CONDITION_PAYSTATE);
		ResultSet rs = null;
		int count = 0;
		try {
			ps.setString(1, paystate);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("total");
			}
			log.info("成功查询出"+count+"条可付款或预付的采购单数据");
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
	public List<Purchase> getListByConditionAndPaystate(int start, int size, String paystate) {
		log.info(" getCountByConditionAndPaystate(int start, int size, String paystate)，通过付款方式查询出可付款或预付款的采购单");
		DBUtil db = new DBUtil();
		ArrayList<Purchase> list = new ArrayList<Purchase>(); 
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_SELECT_LIST_CONDITION_PAYSTATE);
		ResultSet rs = null;
		try {
			ps.setString(1, paystate);
			ps.setInt(2, start);
			ps.setInt(3, size);
			rs = ps.executeQuery();
			while(rs.next()) {
				Purchase purchase = new Purchase();
				purchase.setPurchaseid(rs.getString("purchaseid"));
				purchase.setCreatetime(rs.getString("createtime"));
				purchase.setSuppliername(rs.getString("suppliername"));
				purchase.setCreatename(rs.getString("createname"));
				purchase.setExtramoney(rs.getFloat("extramoney"));
				purchase.setTotalproprices(rs.getFloat("totalproprices"));
				purchase.setAdvanceprice(rs.getFloat("advanceprice"));
				purchase.setTotalprices(rs.getFloat("totalprices"));
				purchase.setPaystate(rs.getString("paystate"));
				purchase.setComment(rs.getString("comment"));
				purchase.setDisposestate(rs.getString("disposestate"));
				purchase.setCloseDate(rs.getString("closeDate"));
				purchase.setCloseUser(rs.getString("closeUser"));
				purchase.setUserid(rs.getInt("userid"));
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
	
	public int getCountByConditionSale() {
		log.info("开始执行 getCountByConditionSale(,获得可收款登记的所有销售单数量");
		DBUtil db = new DBUtil();
		int count = 0;
		PreparedStatement ps = db.getPreparedStatement(SALE_SELECT_COUNT_CONDITION);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			if(rs.next() ) {
				count = rs.getInt("total");
			}
			log.info("成功查询出的行数为:"+count);
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
	public List<SaleMangeModel> getListByConditionSale(int start, int size) {
		log.info("开始执行getListByConditionSale(int start, int size) ，查询出可收款和预收款的销售单");
		DBUtil db = new DBUtil();
		ArrayList<SaleMangeModel> list = new ArrayList<SaleMangeModel>(); 
		PreparedStatement ps = db.getPreparedStatement(SALE_SELECT_LIST_CONDITION);
		ResultSet rs = null;
		try {
			ps.setInt(1, start);
			ps.setInt(2, size);
			rs = ps.executeQuery();
			while(rs.next()) {
				SaleMangeModel sale = new SaleMangeModel();
				sale.setSaleid(rs.getString("salebillid"));
				sale.setCreatetime(rs.getString("createtime"));
				sale.setCustomername(rs.getString("customername"));
				sale.setCreatename(rs.getString("createname"));
				sale.setExtramoney(rs.getFloat("extramoney"));
				sale.setTotalproprices(rs.getFloat("totalproprices"));
				sale.setAdvanceprice(rs.getFloat("advanceprice"));
				sale.setTotalprices(rs.getFloat("totalprices"));
				sale.setPaystate(rs.getString("paystate"));
				sale.setCloseDate(rs.getString("closeDate"));
				sale.setCloseUser(rs.getString("closeUser"));
				sale.setDisposestate(rs.getString("disposestate"));
				sale.setUserid(rs.getInt("userid"));
				list.add(sale);
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
	public int getCountByConditionAndPaystateSale(String paystate) {
		log.info("开始执行 getCountByConditionAndPaystateSale(String paystate)通过付款方式，获得可收款登记的所有销售单数量");
		DBUtil db = new DBUtil();
		int count = 0;
		PreparedStatement ps = db.getPreparedStatement(SALE_SELECT_COUNT_CONDITION_PAYSTATE);
		ResultSet rs = null;
		try {
			ps.setString(1, paystate);
			rs = ps.executeQuery();
			if(rs.next() ) {
				count = rs.getInt("total");
			}
			log.info("成功查询出的行数为:"+count);
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
	public List<SaleMangeModel> getListByConditionAndPaystateSale(int start, int size, String paystate) {
		log.info("开始执行getListByConditionAndPaystateSale(int start, int size, String paystate)，通过付款状态,查询出可收款和预收款的销售单");
		DBUtil db = new DBUtil();
		ArrayList<SaleMangeModel> list = new ArrayList<SaleMangeModel>(); 
		PreparedStatement ps = db.getPreparedStatement(SALE_SELECT_LIST_CONDITION_PAYSTATE);
		ResultSet rs = null;
		try {
			ps.setString(1, paystate);
			ps.setInt(2, start);
			ps.setInt(3, size);
			rs = ps.executeQuery();
			while(rs.next()) {
				SaleMangeModel sale = new SaleMangeModel();
				sale.setSaleid(rs.getString("salebillid"));
				sale.setCreatetime(rs.getString("createtime"));
				sale.setCustomername(rs.getString("customername"));
				sale.setCreatename(rs.getString("createname"));
				sale.setExtramoney(rs.getFloat("extramoney"));
				sale.setTotalproprices(rs.getFloat("totalproprices"));
				sale.setAdvanceprice(rs.getFloat("advanceprice"));
				sale.setTotalprices(rs.getFloat("totalprices"));
				sale.setPaystate(rs.getString("paystate"));
				sale.setCloseDate(rs.getString("closeDate"));
				sale.setCloseUser(rs.getString("closeUser"));
				sale.setDisposestate(rs.getString("disposestate"));
				sale.setUserid(rs.getInt("userid"));
				list.add(sale);
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
	public List<FinanceInfo> getFinInfoListBySql(String sql) {
		log.info("开始执行 getFinInfoListBySql(String sql) ，通过sql语句得到对应的financInfo对象集合");
		DBUtil db = new DBUtil();
		List<FinanceInfo>  list = new ArrayList<FinanceInfo>(); 
		PreparedStatement ps = db.getPreparedStatement(sql);
		ResultSet rs = null;
		System.out.println(sql);
		try {	
			rs = ps.executeQuery();
			while(rs.next()) {
				FinanceInfo finInfo = new FinanceInfo();
				finInfo.setPropertyid(rs.getInt("propertyId"));
				finInfo.setDate(rs.getString("date"));
				finInfo.setTheway(rs.getString("theway"));
				finInfo.setHandle(rs.getString("handle"));
				finInfo.setPurchaseid(rs.getString("purchaseid"));
				finInfo.setSalebillid(rs.getString("salebillid"));
				finInfo.setCreatetime(rs.getString("createtime"));
				finInfo.setDisposestate(rs.getString("disposestate"));
				finInfo.setTotalprices(rs.getFloat("totalprices"));
				finInfo.setPaystate(rs.getString("paystate"));
				list.add(finInfo);
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
	public int getFinInfoCountBySql(String sql) {
		log.info("开始执行 getFinInfoCountBySql(String sql)通过sql得到行数");
		DBUtil db = new DBUtil();
		int count = 0;
		PreparedStatement ps = db.getPreparedStatement(sql);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			if(rs.next() ) {
				count = rs.getInt("total");
			}
			log.info("成功查询出的行数为:"+count);
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
	
	
}
