/**
 * 
 */
package com.aowin.scm.report.storage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aowin.scm.report.storage.pojo.StorageBus;
import com.aowin.scm.utils.DBUtil;

/**
 * @author 李小龙
 * date:2018年11月20日 下午9:26:52
 * 
 */
public class StorageBusDAOImpl implements StorageBusDAO {
	private Logger log = Logger.getLogger(StorageBusDAOImpl.class);
	/**
	 * 
	 */
	public StorageBusDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.businessmanage.dao.StorageBusDAO#getPurchasebytime(java.lang.String, java.lang.String)
	 */
	@Override
	public List<StorageBus> getPurchasebytime(String sd, String ed) {
		log.info("调用业务逻辑方法：getPurchasebytime(String sd, String ed)");
		List<StorageBus> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(INSTORAGE_SELCETID_BYTIM_SQL);
		ResultSet rs = null;
		try {
			ps.setString(1, sd);
			ps.setString(2, ed);
			rs = ps.executeQuery();
			while(rs.next()) {
				StorageBus p = new  StorageBus();
				p.setPurchaseid(rs.getString("purchaseid"));
				p.setInStorageDate(rs.getString("inStorageDate"));
				
				list.add(p);
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
	 * @see com.aowin.scm.businessmanage.dao.StorageBusDAO#getPurchasePANbytime(java.lang.String, java.lang.String)
	 */
	@Override
	public List<StorageBus> getPurchasePANbytime(String sd, String ed) {
		log.info("调用业务逻辑方法：getPurchasePANbytime(String sd, String ed)");
		List<StorageBus> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(INSTORAGE_PANSELCETID_BYTIM_SQL);
		ResultSet rs = null;
		try {
			ps.setString(1, sd);
			ps.setString(2, ed);
			rs = ps.executeQuery();
			while(rs.next()) {
				StorageBus p = new  StorageBus();
				p.setPurchaseid("盘点入库");
				p.setProid(rs.getInt("proid"));
				p.setInStorageDate(rs.getString("inStorageDate"));
				p.setPronum(rs.getInt("inNum"));
				//p.setInNum(rs.getInt("inNum"));
				if(!"".equals(rs.getInt("proid"))) {
					p.setProname(getName(rs.getInt("proid")));
				}
				p.setTotalprice(0);
				log.info("入库盘点"+p);
				list.add(p);
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
	 * @see com.aowin.scm.businessmanage.dao.StorageBusDAO#getdetBYtime(java.lang.String)
	 */
	@Override
	public List<StorageBus> getdetBYtime(String purchaseid,String intodate) {
		log.info("开始执行 getdetBYtime(String purchaseid)");
		DBUtil db = new DBUtil();
		ArrayList<StorageBus> list = new ArrayList<StorageBus>(); 
		PreparedStatement ps = db.getPreparedStatement(INSTORAGE_SELECTMINGXIBYID_SQL);
		ResultSet rs = null;
		try {
			ps.setString(1, purchaseid);
			rs = ps.executeQuery();
			while(rs.next()) {
				StorageBus S = new StorageBus();
				S.setInStorageDate(intodate);
				S.setPurchaseid(rs.getString("purchaseid"));
				S.setPronum(rs.getInt("pronum"));
				S.setProid(rs.getInt("proid"));
				S.setProname(rs.getString("proname"));
				S.setInNum(rs.getInt("pronum"));//??
				S.setTotalprice(rs.getFloat("totalprice"));//采购明细总价
				//S.setTotalprices(getPtotalprices(rs.getString("purchaseid")));//采购单总价
				S.setUnitprice(rs.getFloat("unitprice"));
				list.add(S);
				log.info("入库"+list);
			}
			log.info("成功查询出"+list.size()+"销售详细单数据");
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

	/* (non-Javadoc)
	 * @see com.aowin.scm.businessmanage.dao.StorageBusDAO#getSaleDetByTime(java.lang.String)
	 */
	@Override
	public List<StorageBus> getSaleDetByTime(String saleid,String outdate) {
		log.info("开始执行 getSaleDetByTime(String saleid)");
		DBUtil db = new DBUtil();
		ArrayList<StorageBus> list = new ArrayList<StorageBus>(); 
		PreparedStatement ps = db.getPreparedStatement(INSTORAGE_SELECTMINGXISALE);
		ResultSet rs = null;
		try {
			ps.setString(1, saleid);
			rs = ps.executeQuery();
			log.info("saleid "+saleid);
			while(rs.next()) {
				
				StorageBus S = new StorageBus();
				S.setOutStorageDate(outdate);
				S.setSalebillid(rs.getString("salebillid"));
				S.setPronum(rs.getInt("pronum"));
				S.setProid(rs.getInt("proid"));
				S.setProname(rs.getString("proname"));
				S.setTotalprice(rs.getFloat("totalprice"));
				//S.setTotalprices(getStotalprices(rs.getString("saleid")));
				S.setUnitprice(rs.getFloat("unitprice"));
				list.add(S);
				log.info(""+list);
			}
			log.info("成功查询出"+list.size()+"销售详细单数据");
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

	/* (non-Javadoc)
	 * @see com.aowin.scm.businessmanage.dao.StorageBusDAO#getSalebytime(java.lang.String, java.lang.String)
	 */
	@Override
	public List<StorageBus> getSalebytime(String sd, String ed) {
		log.info("调用业务逻辑方法：getSalebytime(String sd, String ed)");
		List<StorageBus> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(Sale_SELCETID_BYTIM_SQL);
		ResultSet rs = null;
		try {
			ps.setString(1, sd);
			ps.setString(2, ed);
			rs = ps.executeQuery();
			while(rs.next()) {
				StorageBus p = new  StorageBus();
				p.setSalebillid(rs.getString("salebillid"));
				p.setOutStorageDate(rs.getString("outStorageDate"));
				
				list.add(p);
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
	 * @see com.aowin.scm.businessmanage.dao.StorageBusDAO#getPANSalebytime(java.lang.String, java.lang.String)
	 */
	@Override
	public List<StorageBus> getPANSalebytime(String sd, String ed) {
		log.info("调用业务逻辑方法：getPANSalebytime(String sd, String ed)");
		List<StorageBus> list = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(Sale_SELCETIDPAN_BYTIM_SQL);
		ResultSet rs = null;
		try {
			ps.setString(1, sd);
			ps.setString(2, ed);
			rs = ps.executeQuery();
			while(rs.next()) {
				StorageBus p = new  StorageBus();
				p.setTotalprice(0);
				p.setSalebillid("盘点出库");
				p.setProid(rs.getInt("proid"));
				p.setOutStorageDate(rs.getString("outStorageDate"));
				p.setPronum(rs.getInt("outNum"));
				p.setOutNum(rs.getInt("outNum"));
				p.setProname(getName(rs.getInt("proid")));
				list.add(p);
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
	 * @see com.aowin.scm.businessmanage.dao.StorageBusDAO#getName(int)
	 */
	@Override
	public String getName(int proid) {
		String name = null;
		log.info("调用业务逻辑方法：getName(int proid)");
		
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(STORAGE_PRONAME_SQL);
		ResultSet rs = null;
		try {
			ps.setInt(1, proid);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				name=rs.getString("proName");
			}
		} catch (SQLException e) {
			log.warn("数据查询失败: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null; 
		return name;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.businessmanage.dao.StorageBusDAO#getPtotalprices(java.lang.String)
	 */
	@Override
	public float getPtotalprices(String purchaseid) {
		float q = 0;
		log.info("调用业务逻辑方法：getPtotalprices(String purchaseid)");
		
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(PURCHASE_SELECT_PRICE_SQL);
		ResultSet rs = null;
		try {
			ps.setString(1, purchaseid);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				q=rs.getFloat("totalprices");
			}
		} catch (SQLException e) {
			log.warn("数据查询失败: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null; 
		return q;
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.businessmanage.dao.StorageBusDAO#getStotalprices(java.lang.String)
	 */
	@Override
	public float getStotalprices(String salebillid) {
		float q = 0;
		log.info("调用业务逻辑方法：getStotalprices(String salebillid)");
		
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(SALE_SELECT_PRICES_SQL);
		ResultSet rs = null;
		try {
			ps.setString(1, salebillid);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				q=rs.getFloat("totalprices");
			}
		} catch (SQLException e) {
			log.warn("数据查询失败: " + e);
		} finally {
			db.rsClose(rs);
			db.psClose(ps);
			db.connClose();
		}
		db = null; 
		return q;
	}

}

