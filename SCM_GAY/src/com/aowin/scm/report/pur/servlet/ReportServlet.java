package com.aowin.scm.report.pur.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.aowin.scm.report.pur.dao.ReportDao;
import com.aowin.scm.report.pur.pojo.Report;
import com.aowin.scm.utils.DaoFactory;


/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/report/reportServlet")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(ReportServlet.class);
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String option = request.getParameter("option");
		request.removeAttribute("report");
		request.removeAttribute("reports");
		int pages = 1;
		int pagesize = 5;
		ReportDao reportdao=(ReportDao) DaoFactory.getInstance("ReportDao");
		if("showpurrepor".equals(option)) {
			log.info("option=showpurrepor");
			int TotalLines=reportdao.getTotalLines();
			int TotalLinesBydisposestate =reportdao.getTotalLinesBydisposestate();
			log.info(TotalLinesBydisposestate);
			List<Float> purchase = reportdao.gettotalprices();//所有的采购单总价
			log.info(purchase);
			float totalprices=0;
			for(Float pur :purchase) {
				totalprices=totalprices+pur;
			}
			log.info(totalprices);
			List<Float> totprices=reportdao.gettotalpricesBydisposestate();//已付款和已了结的总价
			float totprice=0;
			for(Float tot :totprices) {
				totprice=totprice+tot;
				log.info(totprice);
			}	
			List<Float> advanceprice=reportdao.getadvancepriceBydisposestate();//已预付的预付款
			float adprice=0;
			for(Float adv :advanceprice) {
				adprice=adprice+adv;
			}
			log.info(adprice);
			float all=adprice+totprice;
			
			String page = request.getParameter("pages");
			HttpSession session = request.getSession();
			Integer totalpages = (Integer) session.getAttribute("totalpages");

			if(totalpages == null) {
				totalpages =reportdao.getTotalPages(pagesize);
				session.setAttribute("totalpages", totalpages);
			}
			
			try {
				pages = Integer.parseInt(page);
			} catch (NumberFormatException e) {
				pages = 1;
				log.warn("pages不能进行转换, pages=1");
			}
			if(pages < 1) {
				pages = 1;
			}
			if(pages > totalpages) {
				pages = totalpages;
			}
			log.info("当前页pages="+ pages);
			List<Report> list = reportdao.getReport(pages, pagesize);
			request.setAttribute("report", list);
			request.setAttribute("pages", pages);
			
			request.setAttribute("total",all);
			request.setAttribute("totalprices",totalprices);
			request.setAttribute("TotalLines", TotalLines);
			request.setAttribute("TotalLinesBydisposestate", TotalLinesBydisposestate);
			request.getRequestDispatcher("purchase_report.jsp").forward(request, response);
		}else if("select".equals(option)) {
			request.removeAttribute("report");
			request.removeAttribute("reports");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			String sql = "select purchaseid,createtime,suppliername,createname,advanceprice,totalprices,paystate,disposestate from purchase where ";
			int length = sql.length();
			if(!"".equals(startDate) && !"".equals(endDate) && null != endDate ) {
				sql = sql + " createtime > '"+startDate+"' and createtime < '" + endDate + "'";
			}if(!"".equals(startDate) && "".equals(endDate) ) {
				sql = sql + " createtime > '"+startDate+"'";
		
			}
			if(!"".equals(endDate) && "".equals(startDate) ){
				sql = sql +" createtime < '" + endDate + "'";

			}
			log.info(sql);
			
			List<Report> list =reportdao.getReportBySql(sql);
			
			request.setAttribute("reports", list);
			request.getRequestDispatcher("purchase_report.jsp").forward(request, response);
		}
	}

}
