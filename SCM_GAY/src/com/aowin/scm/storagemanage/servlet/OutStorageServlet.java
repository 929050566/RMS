package com.aowin.scm.storagemanage.servlet;

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
import com.aowin.scm.salemanage.dao.SaleDAO;
import com.aowin.scm.salemanage.pojo.Sale;
import com.aowin.scm.salemanage.pojo.SaleDet;
import com.aowin.scm.storagemanage.dao.OutStorageDAO;
import com.aowin.scm.storagemanage.dao.StorageDAO;
import com.aowin.scm.storagemanage.pojo.OutStorage;
import com.aowin.scm.utils.DaoFactory;


/**
 * Servlet implementation class OutStorageServlet
 */
@WebServlet("/storage/out")
public class OutStorageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(IntoStorageServlet.class);   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutStorageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//字体设置操作
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=UTF-8");
				
				String option = request.getParameter("option");
				
				HttpSession session = request.getSession();
				
				if("outstock".equals(option)) {
					//获得采购单列表
					log.info("option=outstock");
					SaleDAO sa = (SaleDAO)DaoFactory.getInstance("SaleDAO");
					Sale p = new Sale();
					
					
					String pageString = request.getParameter("page");
					int page = 1;
					int size = 10;
					if(pageString != null) {
						page = Integer.parseInt(pageString);
					}
					if(page <= 1 ) {
						page = 1;
					}
					String paystate = request.getParameter("state");
					System.out.println("paystate:"+paystate);
					List<Sale> list = null;
					int totalPage = 0;
					int totalLines = 0;
					
					if("1".equals(paystate) || "2".equals(paystate) || "3".equals(paystate)) {
						log.info("option="+paystate);
						totalLines = sa.getSaleStateCount(paystate);
						totalPage =  (totalLines%size == 0)? 0 : 1 + totalLines/size;
						if(page > totalPage && totalPage != 0) {
							page = totalPage;
						}
						request.setAttribute("page", page);
						page = (page-1)*size ;
						list  = sa.getSaleByState(page, size, paystate);
					}else {
						log.info("option=all");
						totalLines = sa.getSaleCount();
						totalPage =  (totalLines%size == 0)? 0 : 1 + totalLines/size;//页面总数
						if(page > totalPage && totalPage != 0) {
							page = totalPage;
						}
						System.out.println("page:"+page);
						request.setAttribute("page", page);//页面总数
						page = (page-1)*size ;//
						list  = sa.getSaleByCondition(page,size);
						
						System.out.println("totalPage:"+totalPage);
						System.out.println("linesNum:"+totalLines);
						
					}
					request.setAttribute("List", list);
					request.setAttribute("totalPage", totalPage);
					request.setAttribute("linesNum", totalLines);
					request.setAttribute("paystate", paystate);
					request.getRequestDispatcher("outstock.jsp").forward(request, response);
				}else if("saleidlink".equals(option)) {
					
				}else if("outw".equals(option)) {
					log.info("option=outw");
					OutStorage o = new OutStorage();
					SaleDAO sa = (SaleDAO)DaoFactory.getInstance("SaleDAO");
					String disposestate = request.getParameter("di");//未出库前处理状态
					//String inStorageDate = request.getParameter("time");//出库时间
					String purchaseid =request.getParameter("id");//销售单号
					String inoHandle = request.getParameter("han");//出库经手人  ????
					String outState = request.getParameter("instate");//出库类型
					List<SaleDet> det =sa.getproid(purchaseid);//获得销售单号对应的产品集合
					OutStorageDAO t = (OutStorageDAO)DaoFactory.getInstance("OutStorageDAO");
					//出库表加一行
					for(SaleDet d:det) {
						o.setOutHandle(((Admins)session.getAttribute("admins")).getRealname());//??
						o.setOutStorageDate("2018-11");//inStorageDate
						o.setSale_detid(d.getDetid());
						System.err.println("sale_detid:"+d.getDetid());
						o.setSalebillid(purchaseid);
						o.setOutState(outState);
						t.insertOutStorage(o);
					}
					StorageDAO sto = (StorageDAO)DaoFactory.getInstance("StorageDAO");
					//出库时库存表先减少库存与预销售数
					for(SaleDet d:det) {
						int outnum =d.getPronum();//根据销售单号获得预销售数
						int prooid =d.getProid();
						
						sto.updaCKBYID(prooid,outnum,outnum);
					}
					
					
					//修改销售表的处理状态
					sa.updaid(purchaseid,"2");
					request.getRequestDispatcher("out?option=outstock&state="+disposestate).forward(request, response);
				}
	}
}
