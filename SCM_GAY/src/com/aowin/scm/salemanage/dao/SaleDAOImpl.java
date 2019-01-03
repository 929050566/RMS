/**
 * 
 */
package com.aowin.scm.salemanage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aowin.scm.salemanage.pojo.Sale;
import com.aowin.scm.salemanage.pojo.SaleDet;
import com.aowin.scm.utils.DBUtil;

/**
 * @author 李小龙
 * date:2018年11月20日 上午6:39:43
 * 
 */
public class SaleDAOImpl implements SaleDAO {
	private Logger log = Logger.getLogger(this.getClass());
	/**
	 * 
	 */
	public SaleDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.aowin.scm.salemanage.dao.SaleDAO#getSaleByCondition(int, int)
	 */
	@Override
	public List<Sale> getSaleByCondition(int page, int size) {
		log.info("开始执行getSaleByCondition(int page, int size)");
		DBUtil db = new DBUtil();
		ArrayList<Sale> list = new ArrayList<Sale>(); 
		PreparedStatement ps = db.getPreparedStatement(SALE_CK_ALL_SQL);
		ResultSet rs = null;
		try {
			ps.setInt(1, page);
			ps.setInt(2, size);
			rs = ps.executeQuery();
			while(rs.next()) {
				Sale S = new Sale();
				S.setSalebillid(rs.getString("salebillid"));
				S.setCreatetime(rs.getString("createtime"));
				S.setCustomername(rs.getString("customername"));
				S.setCreatename(rs.getString("createname"));
				S.setExtramoney(rs.getFloat("extramoney"));
				S.setTotalproprices(rs.getFloat("totalproprices"));
				S.setAdvanceprice(rs.getFloat("advanceprice"));
				S.setTotalprices(rs.getFloat("totalprices"));
				S.setPaystate(rs.getString("paystate"));
				//S.setComment(rs.getString("comment"));
				S.setDisposestate(rs.getString("disposestate"));
				list.add(S);
			}
			log.info("成功查询出"+list.size()+"条销售单数据");
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
	 * @see com.aowin.scm.salemanage.dao.SaleDAO#getSaleCount()
	 */
	@Override
	public int getSaleCount() {
		log.info("开始执行getSaleCount()，查询出待出库销售单的总条数");
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(SALE_SELECT__ACCOUNT);
		ResultSet rs = null;
		int count = 0;
		try {
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("total");
			}
			log.info("成功查询出"+count+"条销售单数据");
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

	/* (non-Javadoc)
	 * @see com.aowin.scm.salemanage.dao.SaleDAO#getSaleByState(int, int)
	 */
	@Override
	public List<Sale> getSaleByState(int page,int size,String paystate) {
		log.info("开始执行getSaleByState(int page, int size)");
		DBUtil db = new DBUtil();
		ArrayList<Sale> list = new ArrayList<Sale>(); 
		PreparedStatement ps = db.getPreparedStatement(SALE_CK_SELECTBYSTATE_SQL);
		ResultSet rs = null;
		try {
			ps.setString(1, paystate);
			ps.setInt(2, page);
			ps.setInt(3, size);
			rs = ps.executeQuery();
			while(rs.next()) {
				Sale S = new Sale();
				S.setSalebillid(rs.getString("salebillid"));
				S.setCreatetime(rs.getString("createtime"));
				S.setCustomername(rs.getString("customername"));
				S.setCreatename(rs.getString("createname"));
				S.setExtramoney(rs.getFloat("extramoney"));
				S.setTotalproprices(rs.getFloat("totalproprices"));
				S.setAdvanceprice(rs.getFloat("advanceprice"));
				S.setTotalprices(rs.getFloat("totalprices"));
				S.setPaystate(rs.getString("paystate"));
				//S.setComment(rs.getString("comment"));
				S.setDisposestate(rs.getString("disposestate"));
				list.add(S);
			}
			log.info("成功查询出"+list.size()+"销售单单数据");
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
	 * @see com.aowin.scm.salemanage.dao.SaleDAO#getSaleStateCount()
	 */
	@Override
	public int getSaleStateCount(String paystate) {
		log.info("开始执行getSaleStateCount()");
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(SALE_SELECTBYSTATE__ACCOUNT);
		ResultSet rs = null;
		int count = 0;
		try {
			ps.setString(1, paystate);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("total");
			}
			log.info("成功查询出"+count+"条销售单数据");
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

	/* (non-Javadoc)
	 * @see com.aowin.scm.salemanage.dao.SaleDAO#getproid(java.lang.String)
	 */
	@Override
	public List<SaleDet> getproid(String saleid) {
		log.info("开始执行getproid(String saleid)");
		DBUtil db = new DBUtil();
		ArrayList<SaleDet> list = new ArrayList<SaleDet>(); 
		PreparedStatement ps = db.getPreparedStatement(SALEDET_PROIDSELECT_SQL);
		ResultSet rs = null;
		try {
			ps.setString(1, saleid);
			rs = ps.executeQuery();
			while(rs.next()) {
				SaleDet S = new SaleDet();
				S.setPronum(rs.getInt("pronum"));
				S.setProid(rs.getInt("proid"));
				S.setDetid(rs.getInt("detid"));
				list.add(S);
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
	 * @see com.aowin.scm.salemanage.dao.SaleDAO#updaid(java.lang.String)
	 */
	@Override
	public boolean updaid(String salebillid,String disposestate) {
		log.info("调用业务逻辑方法：updaid(String salebillid)");
		boolean result = false;
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(SALEDET_UPDASELECTBY_SQL);
		try {
			ps.setString(1, disposestate);
			ps.setString(2, salebillid);
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
	
}
