/**
 * 
 */
package com.aowin.scm.report.sale.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.aowin.scm.report.sale.pojo.Reportsalemodel;
import com.aowin.scm.utils.DBUtil;

/**
 * @author 葛金铭
 *
 * date:2018年11月20日 下午7:45:37
 */
public class ReportSaleDAOimp implements ReportSaleDAO {
	Logger log = Logger.getLogger(ReportSaleDAOimp.class);
	/**
	 * 
	 */
	public ReportSaleDAOimp() {
	}

	@Override
	public int getsalenum() {
		// TODO 自动生成的方法存根
		log.info("查询总行数 销售报表");
		DBUtil db = new DBUtil();
		PreparedStatement ps =db.getPreparedStatement(GET_REPORT_SALE_SQL);
		ResultSet rs =null;
		int salenum =0;
		try {
			rs = ps.executeQuery();
			rs.next();
			salenum = rs.getInt(1);
			
		} catch (SQLException e) {
			log.warn("查询失败"+e);
		}
		
		return salenum;
	}

	@Override
	public int getsaleendnum() {
		// TODO 自动生成的方法存根
		log.info("查询已经完结的销售数量 销售报表");

		DBUtil db = new DBUtil();
		PreparedStatement ps =db.getPreparedStatement(GET_REPORT_ENDSALE_SQL);
		ResultSet rs = null;
		int saleend = 0;
		try {
			rs = ps.executeQuery();
			rs.next();
			saleend = rs.getInt(1);
		} catch (SQLException e) {
			log.warn("查询失败"+e);
		}
		return saleend;
	}
//salebillid,createtime,customername,createname,extramoney,totalproprices,advanceprice,totalprices,paystate,closeDate,closeUser,comment,disposestate
	@Override
	public ArrayList<Reportsalemodel> getallsale(int page,int size) {
		log.info("获得销售所有信息分页显示 销售报表");
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(GET_SALEDET_PAGEMANAGE);
		ArrayList<Reportsalemodel> ar =new ArrayList<>();
		ResultSet rs =null;
		try {
			ps.setInt(1, page);
			ps.setInt(2, size);
			rs = ps.executeQuery();
			while(rs.next()) {
				Reportsalemodel sale = new Reportsalemodel();
				sale.setSaleid(rs.getString("salebillid"));
				sale.setSaletime(rs.getString("createtime"));
				sale.setCustomername(rs.getString("customername"));
				sale.setCreatesaleper(rs.getString("createname"));
				sale.setTotalsaleprice(rs.getFloat("totalprices"));
				if("2".equals(rs.getString("paystate"))) {
					sale.setNotpayprice(0);
				}else if("1".equals(rs.getString("paystate")) && "1".equals(rs.getString("disposestate"))) {
					sale.setNotpayprice(rs.getFloat("totalprices"));
				}else if("3".equals(rs.getString("paystate")) && "5".equals(rs.getString("disposestate"))) {
					sale.setNotpayprice(rs.getFloat("totalprices")-rs.getFloat("advanceprice"));
				}else if("4".equals(rs.getString("disposestate"))) {
					sale.setNotpayprice(0);
				}
				sale.setPaystate(rs.getString("paystate"));
				ar.add(sale);
			}
		} catch (SQLException e) {
			log.warn("查询失败"+e);
		}finally {
			db.connClose();
			db.psClose(ps);
			db.rsClose(rs);
		}
		db = null;
		return ar;
	}

	public ArrayList<Reportsalemodel> getallsale() {
		log.info("获得销售所有信息不分页显示 销售报表");
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement(GET_SALEDET_ALLMANAGE);
		ArrayList<Reportsalemodel> ar =new ArrayList<>();
		ResultSet rs =null;
		try {
			rs = ps.executeQuery();
			while(rs.next()) {
				Reportsalemodel sale = new Reportsalemodel();
				sale.setSaleid(rs.getString("salebillid"));
				sale.setSaletime(rs.getString("createtime"));
				sale.setCustomername(rs.getString("customername"));
				sale.setCreatesaleper(rs.getString("createname"));
				sale.setTotalsaleprice(rs.getFloat("totalprices"));
				if("2".equals(rs.getString("paystate"))) {
					sale.setNotpayprice(0);
				}else if("1".equals(rs.getString("paystate")) && "1".equals(rs.getString("disposestate"))) {
					sale.setNotpayprice(rs.getFloat("totalprices"));
				}else if("3".equals(rs.getString("paystate")) && "5".equals(rs.getString("disposestate"))) {
					sale.setNotpayprice(rs.getFloat("totalprices")-rs.getFloat("advanceprice"));
				}else if("4".equals(rs.getString("disposestate"))) {
					sale.setNotpayprice(0);
				}
				sale.setPaystate(rs.getString("paystate"));
				sale.setDisposestate(rs.getString("disposestate"));
				ar.add(sale);
			}
		} catch (SQLException e) {
			log.warn("获得失败"+e);
		}finally {
			db.connClose();
			db.psClose(ps);
			db.rsClose(rs);
		}
		db = null;
		return ar;
	}
	public ArrayList<Reportsalemodel> getSelecttime(String sql){
		log.info("查询销售列表 销售报表");
		ArrayList<Reportsalemodel> ar = new ArrayList<>();
		DBUtil db = new DBUtil();
		PreparedStatement ps =db.getPreparedStatement(sql);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			while(rs.next()) {
				Reportsalemodel sale = new Reportsalemodel();
				sale.setSaleid(rs.getString("salebillid"));
				sale.setSaletime(rs.getString("createtime"));
				sale.setCustomername(rs.getString("customername"));
				sale.setCreatesaleper(rs.getString("createname"));
				sale.setTotalsaleprice(rs.getFloat("totalprices"));
				if("2".equals(rs.getString("paystate"))) {
					sale.setNotpayprice(0);
				}else if("1".equals(rs.getString("paystate")) && "1".equals(rs.getString("disposestate"))) {
					sale.setNotpayprice(rs.getFloat("totalprices"));
				}else if("3".equals(rs.getString("paystate")) && "5".equals(rs.getString("disposestate"))) {
					sale.setNotpayprice(rs.getFloat("totalprices")-rs.getFloat("advanceprice"));
				}else if("4".equals(rs.getString("disposestate"))) {
					sale.setNotpayprice(0);
				}
				sale.setPaystate(rs.getString("paystate"));
				sale.setDisposestate(rs.getString("disposestate"));
				ar.add(sale);
				
			}
		} catch (SQLException e) {
			log.warn("获得失败"+e);
		}finally {
			db.connClose();
			db.psClose(ps);
			db.rsClose(rs);
		}
		return ar;
	}
	public int getTotalPages(int pagesize) {
		//log.info("调用业务逻辑方法：getTotalPages(int pagesize)");
		log.info("获得销售的总页数 销售报表");
		int totalpages = 1;
		DBUtil db = new DBUtil();
		PreparedStatement ps = db.getPreparedStatement("select count(salebillid) total from sale");
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			rs.next();
			int totalrecords = rs.getInt(1);
			totalpages = (totalrecords%pagesize==0?0:1) + totalrecords/pagesize;   
		} catch (SQLException e) {
			//log.warn("数据查询失败: " + e);
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

}
