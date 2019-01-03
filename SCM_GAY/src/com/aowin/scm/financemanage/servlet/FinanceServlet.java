package com.aowin.scm.financemanage.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.aowin.scm.adminmanage.pojo.Admins;
import com.aowin.scm.financemanage.dao.FinanceDao;
import com.aowin.scm.financemanage.pojo.Finance;
import com.aowin.scm.financemanage.pojo.FinanceInfo;
import com.aowin.scm.purchasemanager.pojo.Purchase;
import com.aowin.scm.salemanage.pojo.SaleMangeModel;
import com.aowin.scm.utils.DaoFactory;

/**
 * Servlet implementation class FinanceServlet
 */
@WebServlet("/finance/Finance")
public class FinanceServlet extends HttpServlet {
	private Logger log = Logger.getLogger(this.getClass());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		FinanceDao financeDao = (FinanceDao) DaoFactory.getInstance("FinanceDAO");
		HttpSession session = request.getSession(); 
		if("queryOutMoney".equals(option)) {
			log.info("option = queryOutMoney");
			String pageString = request.getParameter("page");
			int page = 1;
			int size = 10;
			if(pageString != null) {
				page = Integer.parseInt(pageString);
			}
			if(page <= 1 ) {
				page = 1;
			}
			String paystateToQuery = request.getParameter("paystateToQuery");
			String paystate = request.getParameter("paystate");
			System.out.println("paystate:"+paystate);
			List<Purchase> list = null;
			int totalPage = 0;
			int totalLines = 0;
			if("1".equals(paystateToQuery) || "2".equals(paystateToQuery) || "3".equals(paystateToQuery)) {
				totalLines = financeDao.getCountByConditionAndPaystate(paystateToQuery);
				totalPage =  ((totalLines%size == 0)? 0 : 1) + totalLines/size;
				if(page > totalPage && totalPage !=0) {
					page = totalPage;
				}
				request.setAttribute("page", page);
				page = (page-1)*size ;
				list = financeDao.getListByConditionAndPaystate(page, size, paystateToQuery);
			}else {
				totalLines = financeDao.getCountByCondition();
				totalPage =  ((totalLines%size == 0)? 0 : 1) + totalLines/size;
				if(page > totalPage  && totalPage !=0) {
					page = totalPage;
				}
				System.out.println("page:"+page);
				request.setAttribute("page", page);
				page = (page-1)*size ;
				list  = financeDao.getListByCondition(page, size);
				System.out.println("totalPage:"+totalPage);
				System.out.println("linesNum:"+totalLines);
				
			}
			request.setAttribute("purchaseList", list);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("linesNum", totalLines);
			request.setAttribute("paystateToQuery", paystateToQuery);
			request.getRequestDispatcher("outMoney.jsp").forward(request, response);
		}else if("purOutMoney".equals(option)) {
			log.info("option = purOutMoney");
			String paystate = request.getParameter("paystate");
			String purchaseid = request.getParameter("purchaseid");
			String disposestate = request.getParameter("disposestate");
			Finance finance = new Finance();
			finance.setPurchaseid(purchaseid);
			finance.setHandle(((Admins)session.getAttribute("admins")).getRealname());
			if("1".equals(paystate) || "2".equals(paystate)) {
				financeDao.updatePurchase(purchaseid, "3");
				finance.setTheway("2");
			}else if("3".equals(paystate)) {
				if("1".equals(disposestate)) {
					financeDao.updatePurchase(purchaseid, "5");
					finance.setTheway("2");
				}else if("2".equals(disposestate)) {
					financeDao.updatePurchase(purchaseid, "3");
					finance.setTheway("4");
				}
			}
			financeDao.insertPurchase(finance);
			request.getRequestDispatcher("Finance?option=queryOutMoney&paystate="+paystate).forward(request, response);
		}else if("queryInMoney".equals(option)) {
			log.info("option = queryInMoney");
			String pageString = request.getParameter("page");
			int page = 1;
			int size = 10;
			if(pageString != null) {
				page = Integer.parseInt(pageString);
			}
			if(page <= 1 ) {
				page = 1;
			}
			String paystate = request.getParameter("paystate");
			System.out.println("paystate:"+paystate);
			List<SaleMangeModel> list = null;
			int totalPage = 0;
			int totalLines = 0;
			if("1".equals(paystate) || "2".equals(paystate) || "3".equals(paystate)) {
				totalLines = financeDao.getCountByConditionAndPaystateSale(paystate);
				totalPage =  ((totalLines%size == 0)? 0 : 1) + totalLines/size;
				if(page > totalPage && totalPage != 0) {
					page = totalPage;
				}
				request.setAttribute("page", page);
				page = (page-1)*size ;
				list = financeDao.getListByConditionAndPaystateSale(page, size, paystate);
			}else {
				totalLines = financeDao.getCountByConditionSale();
				totalPage =  ((totalLines%size == 0)? 0 : 1) + totalLines/size;
				if(page > totalPage && totalPage != 0) {
					page = totalPage;
				}
				System.out.println("page:"+page);
				request.setAttribute("page", page);
				page = (page-1)*size ;
				list  = financeDao.getListByConditionSale(page, size);
				System.out.println("totalPage:"+totalPage);
				System.out.println("linesNum:"+totalLines);
				
			}
			request.setAttribute("saleList", list);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("linesNum", totalLines);
			request.setAttribute("paystate", paystate);
			request.getRequestDispatcher("inMoney.jsp").forward(request, response);
		}else if("purIntMoney".equals(option)) {
			log.info("option = purIntMoney");
			String paystate = request.getParameter("paystate");
			System.err.println("paystate= "+paystate);
			String saleid = request.getParameter("saleid");
			String disposestate = request.getParameter("disposestate");
			Finance finance = new Finance();
			finance.setSalebillid(saleid);
			//session域中得到
			finance.setHandle(((Admins)session.getAttribute("admins")).getRealname());
			if("1".equals(paystate) || "2".equals(paystate)) {
				financeDao.updateSale(saleid, "3");
				finance.setTheway("1");
			}else if("3".equals(paystate)) {
				if("1".equals(disposestate)) {
					financeDao.updateSale(saleid, "5");
					finance.setTheway("1");
				}else if("2".equals(disposestate)) {
					financeDao.updateSale(saleid, "3");
					finance.setTheway("3");
				}
			}
			financeDao.insertSale(finance);
			request.getRequestDispatcher("Finance?option=queryInMoney&paystate="+paystate).forward(request, response);
		}else if("queryAll".equals(option)) {
			log.info("option = queryAll");
			String pageString = request.getParameter("page");
			int page = 1;
			int size = 10;
			if( pageString != null) {
				page = Integer.parseInt(pageString);
			}
			String inOrOut = request.getParameter("inOrOut");
			String paystate = request.getParameter("paystate");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			String id = request.getParameter("id");
			String sql_res = mkSql(paystate, startDate, endDate, inOrOut, id);
			String sql_getTotalLines = sql_res.replaceAll("\\*", "count('propertyId') as total");
			System.out.println(sql_getTotalLines);
			int totalLines = financeDao.getFinInfoCountBySql(sql_getTotalLines);
			System.out.println(totalLines);
			int totalPage = ((totalLines%size == 0)? 0 : 1) + totalLines/size;
			if(page <= 1) {
				page = 1;
			}
			if(page >= totalPage && totalPage != 0) {
				page = totalPage;
			}
			//这个sql用来查询当前需要查询的pruchase数据
			String sql_getPurchaseList = sql_res + "  order by date desc limit " + (page-1)*size + " , " + size;
			List<FinanceInfo> list = financeDao.getFinInfoListBySql(sql_getPurchaseList);
			request.setAttribute("finInfoList", list);
			request.setAttribute("page", page);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("linesNum", totalLines);
			request.setAttribute("id", id);
			request.setAttribute("paystate", paystate);
			request.setAttribute("startDate", startDate);
			request.setAttribute("endDate", endDate);
			request.setAttribute("inOrOut", inOrOut);
			request.getRequestDispatcher("queryMoney.jsp").forward(request, response);
		}
	}
	/**
	 * sql 拼接方法
	 * @param paystate 付款方式
	 * @param startDate 起始日期 
	 * @param endDate 结束日期
	 * @param inOrOut 付款或收款
	 * @param id 订单号
	 * @return
	 */
	private String mkSql(String paystate,String startDate,String endDate,String inOrOut,String id ) {
		String sql = null;
		int oldLen = 0;
		if("in".equals(inOrOut)) {
			sql = "select * from finance Inner JOIN sale on finance.salebillid = sale.salebillid where ";
			oldLen = sql.length();
			sql = sql + " (theway = '1' or theway = '3') and" ;
			if(!"".equals(id)) {
				sql = sql + " finance.salebillid like  '%" + id + "%' and";
			}
		}else if("out".equals(inOrOut) ) {
			sql = "select * from finance Inner JOIN purchase on finance.purchaseid = purchase.purchaseid  where ";
			oldLen = sql.length();
			sql = sql + " (theway = '2' or theway = '4') and" ;
			if(!"".equals(id)) {
				sql = sql + " finance.purchaseid like  '%" + id + "%' and";
			}
		}
		if(!"".equals(paystate)) {
			sql = sql +" paystate = '" + paystate +"' and";
		}
		if(!"".equals(startDate) && !"".equals(endDate) && null != endDate ) {
			sql = sql + " date > '"+startDate+"' and date < '" + endDate + "' and";
		}
		int newLen = sql.length();
		if(newLen == oldLen) {
			sql = sql.substring(0, sql.length() - 7);
		}else {
			sql = sql.substring(0,sql.length() - 4);
		}
		System.err.println(sql);
		return sql;
	}
}
