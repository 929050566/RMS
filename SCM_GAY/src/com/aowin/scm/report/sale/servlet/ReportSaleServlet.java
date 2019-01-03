package com.aowin.scm.report.sale.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.aowin.scm.report.sale.dao.ReportSaleDAOimp;
import com.aowin.scm.report.sale.pojo.Reportsalemodel;
import com.aowin.scm.utils.DaoFactory;

/**
 * Servlet implementation class ReportSale
 */
@WebServlet("/report/ReportSale")
public class ReportSaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(ReportSaleServlet.class);   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportSaleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("进入销售报表服务器");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		ReportSaleDAOimp report =  (ReportSaleDAOimp) DaoFactory.getInstance("ReportSaleDAO");
		String option = request.getParameter("option");
		HttpSession session = request.getSession();
		int pages = 1;
		int pagesize = 5;
		if("salereport".equals(option)) {
			log.info("展示所有模块");
			float total = 0 ;
			float endpay =0;
			session.removeAttribute("endpay");
			session.removeAttribute("num");
			session.removeAttribute("saleend");
			session.removeAttribute("total");
			session.removeAttribute("allsale");
			session.removeAttribute("timesale");
			int salenum = report.getsalenum();
			int saleend = report.getsaleendnum();
			
			String page = request.getParameter("pages");
			Integer totalpages = (Integer) session.getAttribute("totalpages");
			if(totalpages == null) {
				totalpages =report.getTotalPages(pagesize);
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
			
			ArrayList<Reportsalemodel> allsale = report.getallsale();
			for(int i =0;i<allsale.size();i++) {
				total += allsale.get(i).getTotalsaleprice();
				endpay += allsale.get(i).getNotpayprice();
			}

			request.setAttribute("pages", pages);
			

			
			session.setAttribute("endpay", endpay);
			session.setAttribute("num", salenum);
			session.setAttribute("saleend", saleend);
			session.setAttribute("total", total);
			session.setAttribute("allsale", allsale);
			request.getRequestDispatcher("sale_report.jsp").forward(request, response);
		}else if("select".equals(option)) {
			log.info("进入查询模块");
			session.removeAttribute("allsale");
			session.removeAttribute("timesale");
			ArrayList<Reportsalemodel> timesale = report.getallsale();
			String stardate = request.getParameter("startDate");
			String enddate = request.getParameter("endDate");
			String sql ="select salebillid,createtime,customername,createname,extramoney,totalproprices,advanceprice,totalprices,paystate,closeDate,closeUser,comment,disposestate from sale where ";
			int length = sql.length();
			if(!"".equals(stardate) && !"".equals(enddate) && null != enddate ) {
				sql = sql + " createtime > '"+stardate+"' and createtime < '" + enddate + "'";
				System.out.println(sql);
			}
			if(!"".equals(stardate) && "".equals(enddate) ) {
				sql = sql + " createtime > '"+stardate+"'";
				System.out.println(sql);
			}
			if(!"".equals(enddate) && "".equals(stardate) ){
				sql = sql +" createtime < '" + enddate + "'";
				System.out.println(sql);
			}
			log.info(sql);
			timesale = report.getSelecttime(sql);
			session.setAttribute("timesale", timesale);
			request.getRequestDispatcher("sale_report.jsp").forward(request, response);

		}
		
		
		
	}

}
