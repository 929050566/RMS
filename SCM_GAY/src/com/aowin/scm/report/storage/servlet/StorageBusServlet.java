package com.aowin.scm.report.storage.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.aowin.scm.report.storage.dao.StorageBusDAO;
import com.aowin.scm.report.storage.pojo.StorageBus;
import com.aowin.scm.utils.DaoFactory;

/**
 * Servlet implementation class StorageBusServlet
 */
@WebServlet(name = "StorageBusServlets", urlPatterns = { "/report/bus" })
public class StorageBusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(StorageBusServlet.class);   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StorageBusServlet() {
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
		String page = request.getParameter("pages");
		System.out.println("请求option  "+option);
		String startDate = request.getParameter("sd");
		String endDate = request.getParameter("ed");
		StorageBusDAO sb = (StorageBusDAO)DaoFactory.getInstance("StorageBusDAO");
	if("into".equals(option)) {
		log.info("option=into");
		List<StorageBus> list =sb.getPurchasebytime(startDate, endDate);
		//System.out.println("list "+list.toString());
		int n = list.size();//采购入库的单数
		List<StorageBus> list2=sb.getPurchasePANbytime(startDate, endDate);//盘点入库
		System.out.println(n);
		//System.out.println("list2 "+list2.toString());
		n=n+list2.size();//入库单据数
		request.setAttribute("rdnum", n);
		List<StorageBus> list3 =new ArrayList<StorageBus>() ;//存放两个集合
		float q = 0;//入库产品总金额
		int nn = 0;//产品总数
		//采购入库集合
		for(StorageBus in:list) {
			System.out.println("id "+in.getPurchaseid());
			List<StorageBus> list4 = sb.getdetBYtime(in.getPurchaseid(), in.getInStorageDate());
			System.out.println("list4 "+list4.toString());
			for(StorageBus l:list4) {
				nn+=l.getPronum();
				
			}
			System.out.println(in.getTotalprices());
			q+=sb.getPtotalprices(in.getPurchaseid());
			System.out.println("q"+q);
			list3.addAll(list4);
		}
		//log.info(list3);
		for(StorageBus in:list2) {
			nn+=in.getPronum();
			
		}
		//盘点入库也加入list3
		list3.addAll(list2);
		request.setAttribute("rlist",list3);
		request.setAttribute("q", q);
		request.setAttribute("nn", nn);
		
		request.getRequestDispatcher("inbus.jsp").forward(request, response);
	}else if("out".equals(option)) {
		log.info("option=out");
		List<StorageBus> list = sb.getSalebytime(startDate, endDate);
		log.info(list);
		int n = list.size();//销售出库的单数
		List<StorageBus> list2=sb.getPANSalebytime(startDate, endDate);//盘点出库
		System.out.println(n);
		System.out.println("list2"+list2.toString());
		n=n+list2.size();//出库单据数
		request.setAttribute("rdnum", n);
		List<StorageBus> list3 =new ArrayList<StorageBus>() ;//存放两个集合
		int q = 0;//出库产品总金额
		int nn = 0;//产品总数
		//出库集合
		for(StorageBus in:list) {
			List<StorageBus> list4 = sb.getSaleDetByTime(in.getSalebillid(), in.getOutStorageDate());
			for(StorageBus l:list4) {
				nn+=l.getPronum();
				log.info("getPronum()"+l.getPronum());
			}
			q+=sb.getStotalprices(in.getSalebillid());
			log.info("getStotalprices(in.getSalebillid())"+sb.getStotalprices(in.getSalebillid()));
			list3.addAll(list4);
		}
		for(StorageBus in:list2) {
			nn+=in.getPronum();
			
		}
		//盘点出库也加入list3
		list3.addAll(list2);
		request.setAttribute("rlist",list3);
		request.setAttribute("q", q);
		request.setAttribute("nn", nn);
		
		request.getRequestDispatcher("outbus.jsp").forward(request, response);
		
	}else if("sto".equals(option)) {
		log.info("option=sto");
		List<StorageBus> list = sb.getSalebytime(startDate, endDate);
		int c = list.size();//采购出库的单数
		List<StorageBus> list2=sb.getPANSalebytime(startDate, endDate);//盘点出库
		
	}
}

}
