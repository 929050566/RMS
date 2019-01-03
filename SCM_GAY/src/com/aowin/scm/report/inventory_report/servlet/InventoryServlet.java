package com.aowin.scm.report.inventory_report.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.aowin.scm.report.inventory_report.dao.Inventory_reportDao;
import com.aowin.scm.report.inventory_report.pojo.Inventory_report;
import com.aowin.scm.utils.DaoFactory;

/**
 * Servlet implementation class InventoryServlet
 */
@WebServlet("/report/InventoryServlet")
public class InventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private Logger log = Logger.getLogger(InventoryServlet.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InventoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String option = request.getParameter("option");
		int pages = 1;
		int pagesize = 5;
		request.removeAttribute("report");
		request.removeAttribute("reports");
		HttpSession session = request.getSession();
		
		Inventory_reportDao inventory= (Inventory_reportDao) DaoFactory.getInstance("Inventory_reportDao");
		if("showpurrepor".equals(option)) {
			log.info("option=showpurrepor");
			int TotalLines=inventory.getTotalLines();
			List<Integer> purchase = inventory.gettotalpresentNum();//所有商品的库存
			log.info(purchase);
			int totalprices=0;
			for(int pur :purchase) {
				totalprices=totalprices+pur;
			}
			log.info(totalprices);
			
			String page = request.getParameter("pages");
			
			Integer totalpages = (Integer) session.getAttribute("totalpage");
			
			if(totalpages == null) {
				totalpages =inventory.getTotalPages(pagesize);
				session.setAttribute("totalpage", totalpages);
			}
			log.info(totalpages);
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
			List<Inventory_report> list = inventory.getInventory_Report(pages, pagesize);
			request.setAttribute("rep", list);
			request.setAttribute("page", pages);
			
			
			request.setAttribute("totalprices",totalprices);
			request.setAttribute("TotalLines", TotalLines);
			request.getRequestDispatcher("inventory_report.jsp").forward(request, response);
		}else if("select".equals(option)) {
			request.removeAttribute("rep");
			request.removeAttribute("re");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			String sql = "select outNum,proid,outStorageDate from outstorage where ";
			String insql = "select inNum,proid,inStorageDate from intostorage where ";
			if(!"".equals(startDate) && !"".equals(endDate) && null != endDate ) {
				sql = sql + " outStorageDate > '"+startDate+"' and outStorageDate < '" + endDate + "'";
			}if(!"".equals(startDate) && "".equals(endDate) ) {
				sql = sql + " outStorageDate > '"+startDate+"'";
		
			}
			if(!"".equals(endDate) && "".equals(startDate) ){
				sql = sql +" outStorageDate < '" + endDate + "'";
			}
			log.info(sql);
			if(!"".equals(startDate) && !"".equals(endDate) && null != endDate ) {
				insql = insql + " inStorageDate > '"+startDate+"' and inStorageDate < '" + endDate + "'";
			}if(!"".equals(startDate) && "".equals(endDate) ) {
				insql = insql + " inStorageDate > '"+startDate+"'";
		
			}
			if(!"".equals(endDate) && "".equals(startDate) ){
				insql = insql +" inStorageDate < '" + endDate + "'";
			}
			log.info(insql);
			List<Inventory_report> outlist =inventory.getInventoryBySql(sql);
			List<Inventory_report> inlist =inventory.getInInventoryBySql(insql);
			
			request.setAttribute("inlist",inlist);
			request.setAttribute("outlist",outlist);
			request.getRequestDispatcher("inventory_report.jsp").forward(request, response);
	}
	}
}
