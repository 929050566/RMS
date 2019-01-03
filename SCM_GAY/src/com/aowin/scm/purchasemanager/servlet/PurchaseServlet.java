package com.aowin.scm.purchasemanager.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.aowin.scm.adminmanage.pojo.Admins;
import com.aowin.scm.purchasemanager.dao.PurchaseDao;
import com.aowin.scm.purchasemanager.dao.PurchaseDaoImpl;
import com.aowin.scm.purchasemanager.dao.PurchaseDetDao;
import com.aowin.scm.purchasemanager.pojo.Purchase;
import com.aowin.scm.purchasemanager.pojo.PurchaseAllInfo;
import com.aowin.scm.purchasemanager.pojo.PurchaseDet;
import com.aowin.scm.storagemanage.dao.StorageDAO;
import com.aowin.scm.storagemanage.pojo.Storage;
import com.aowin.scm.supplier.dao.SupplierDao;
import com.aowin.scm.supplier.dao.SupplierDaoImpl;
import com.aowin.scm.supplier.pojo.Supplier;
import com.aowin.scm.utils.DaoFactory;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/web_pro/Purchase")
public class PurchaseServlet extends HttpServlet {
	
	private Logger log = Logger.getLogger(this.getClass());
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		System.out.println(option);
		SupplierDao supplierDao = new SupplierDaoImpl();
		PurchaseDao purchaseDao = new PurchaseDaoImpl();
		PurchaseDetDao purchaseDetDao = (PurchaseDetDao) DaoFactory.getInstance("PurchaseDetDao");
		StorageDAO storageDao = (StorageDAO) DaoFactory.getInstance("StorageDAO");
		HttpSession session = request.getSession();
		if("addpurchase".equals(option)) {
			log.info("option=addpurchase");
			List<Supplier> list=supplierDao.getSupplier();
			log.info(list);
			List<Storage> storage=storageDao.getStorage();
			log.info(storage);
			//session域中得到用户姓名
			request.setAttribute("createname", ((Admins)session.getAttribute("admins")).getRealname());
			request.setAttribute("suppliers", list);
			request.setAttribute("storage", storage);
			request.getRequestDispatcher("pomainform.jsp").forward(request, response);
		}if("purchaseadd".equals(option)) {
			log.info("option=purchaseadd");
			String purchaseid=request.getParameter("purchaseid");
			String suppliername=request.getParameter("suppliername");
			String createname=request.getParameter("createname");
			String extramoney=request.getParameter("extramoney");
			String totalproprices=request.getParameter("totalproprices");
			String totalprices=request.getParameter("totalprices");
			String paystate=request.getParameter("paystate");
			String advanceprice=request.getParameter("advanceprice");
			String comment=request.getParameter("comment");
			String createtime=request.getParameter("createTime");
			Purchase purchase=new Purchase();
			purchase.setPurchaseid(purchaseid);
			purchase.setSuppliername(suppliername);
			purchase.setCreatename(createname);
			float extra=Float.parseFloat(extramoney);
			purchase.setExtramoney(extra);
			float total=Float.parseFloat(totalproprices);
			purchase.setTotalproprices(total);
			purchase.setPaystate(paystate);
			float advance=Float.parseFloat(advanceprice);
			purchase.setAdvanceprice(advance);
			purchase.setComment(comment);
			purchase.setCreatetime(createtime);
			float totalpri=Float.parseFloat(totalproprices);
			purchase.setTotalprices(totalpri);
			log.info(purchase);
			purchaseDao.insertPurchase(purchase);
			System.out.println(purchase);
			
			String[] proid=request.getParameterValues("proid");
			String[] proname=request.getParameterValues("proname");
			String[] prounit=request.getParameterValues("prounit");
			String[] pronum=request.getParameterValues("pronum");
			String[] unitprice=request.getParameterValues("unitprice");
			String[] totalprice=request.getParameterValues("totalprice");
			for(int i=0;i<proid.length;i++) {
				PurchaseDet purchasedet=new PurchaseDet();
				int id=Integer.parseInt(proid[i]);
				purchasedet.setProid(id);
				purchasedet.setProname(proname[i]);
				purchasedet.setProunit(prounit[i]);
				purchasedet.setPurchaseid(purchaseid);
				float unit=  Float.parseFloat(unitprice[i]);
				purchasedet.setUnitprice(unit);
				float tot=  Float.parseFloat(totalprice[i]);
				purchasedet.setTotalprice(tot);
				int num=Integer.parseInt(pronum[i]);
				purchasedet.setPronum(num);
				log.info(purchasedet);
				storageDao.updateOnPurchaseNum(id, num);
				purchaseDetDao.insertPurchaseDet(purchasedet);
				System.out.println();
			
			}
			response.getWriter().write( "<script>alert('添加成功'); window.location='pomainform.jsp';window.close();</script>"); 
			response.getWriter().flush();
			
		}else if("updatePur".equals(option)) {
			log.info("option=updatePur");
			String purchaseid=request.getParameter("purchaseid");
			String suppliername=request.getParameter("suppliername");
			String createname=request.getParameter("createname");
			String extramoney=request.getParameter("extramoney");
			String totalproprices=request.getParameter("totalproprices");
			String totalprices=request.getParameter("totalprices");
			String paystate=request.getParameter("paystate");
			String advanceprice=request.getParameter("advanceprice");
			String comment=request.getParameter("comment");
			String createtime=request.getParameter("createtime");
			String disposestate = request.getParameter("disposestate");
			Purchase purchase=new Purchase();
			purchase.setDisposestate(disposestate);
			purchase.setPurchaseid(purchaseid);
			purchase.setSuppliername(suppliername);
			purchase.setCreatename(createname);
			float extra=Float.parseFloat(extramoney);
			purchase.setExtramoney(extra);
			float total=Float.parseFloat(totalproprices);
			purchase.setTotalproprices(total);
			purchase.setPaystate(paystate);
			float advance=Float.parseFloat(advanceprice);
			purchase.setAdvanceprice(advance);
			purchase.setComment(comment);
			purchase.setCreatetime(createtime);
			float totalpri=Float.parseFloat(totalproprices);
			purchase.setTotalprices(totalpri);
			log.info(purchase);
			purchaseDao.updatePurchase(purchase);
			System.out.println(purchase);
			
			String[] proid=request.getParameterValues("proid");
			String[] proname=request.getParameterValues("proname");
			String[] prounit=request.getParameterValues("prounit");
			String[] pronum=request.getParameterValues("pronum");
			String[] unitprice=request.getParameterValues("unitprice");
			String[] totalprice=request.getParameterValues("totalprice");
			String[] detid = request.getParameterValues("detid");
			List<PurchaseDet> purDetList = purchaseDetDao.selectPurchaseDet(purchaseid);
		
			for(int i=0;i<proid.length;i++) {
				PurchaseDet purchasedet=new PurchaseDet();
				int id=Integer.parseInt(proid[i]);
				purchasedet.setProid(id);
				purchasedet.setProname(proname[i]);
				purchasedet.setProunit(prounit[i]);
				purchasedet.setPurchaseid(purchaseid);
				if(detid != null &&  i < detid.length ) {
					purchasedet.setDetid(Integer.parseInt(detid[i]));
				}
				float unit=  Float.parseFloat(unitprice[i]);
				purchasedet.setUnitprice(unit);
				float tot=  Float.parseFloat(totalprice[i]);
				purchasedet.setTotalprice(tot);
				int num=Integer.parseInt(pronum[i]);
				purchasedet.setPronum(num);
				log.info(purchasedet);
				//通过Purchaseid查出销售明细表中的明细信息 如果产品id相同 则先要减去库存表中对应的采购在途数
				boolean flag = true;
				for (int j = 0; j < purDetList.size(); j++) {
					if(purDetList.get(j).getDetid() == purchasedet.getDetid()) {
						//减去库存表中对应的预销售数
						storageDao.updateOnPurchaseNum(id, -purDetList.get(j).getPronum());
						//增加库存表中的预销售数
						storageDao.updateOnPurchaseNum(id, num);
						System.err.println(purchasedet.getProname());
						//修改产品细节表
						purchaseDetDao.updatePurchaseDet(purchasedet);
						//将处理过的销售细节信息减去
						purDetList.remove(purDetList.get(j));
						flag = false;
						break;
					}
				}
				//如果是新增的 则需要添加产品明细
				if(flag) {
					purchaseDetDao.insertPurchaseDet(purchasedet);
					storageDao.updateOnPurchaseNum(purchasedet.getProid(), num);
				}
			}
			//剩下的 采购单对应的明细信息 说明是被删除了的 应该减去
			for (PurchaseDet purDet : purDetList) {
				purchaseDetDao.deletePurchaseDetByDetid(purDet.getDetid());
				storageDao.updateOnPurchaseNum(purDet.getProid(), -purDet.getPronum());
			}
			request.getRequestDispatcher("Purchase?option=queryPur").forward(request, response);
		}else if("startQuery".equals(option)) {
			List<Supplier> list = supplierDao.getSupplier();
			request.setAttribute("supplierList", list);
			request.getRequestDispatcher("pomain_sel.jsp").forward(request, response);
		}else if("queryPur".equals(option)) {
			String pageString = request.getParameter("page");
			int page = 1;
			int size = 10;
			if(pageString != null) {
				page = Integer.parseInt(pageString);
			}
			if(page <= 1 ) {
				page = 1;
			}
			String purchaseidToQuery = request.getParameter("purchaseidToQuery");
			String suppliername = request.getParameter("suppliername");
			String paystate = request.getParameter("paystate");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			String disposestate = request.getParameter("disposestate");
			String sql = makeSQLToSelect(purchaseidToQuery, startDate, endDate, paystate, disposestate,suppliername);
			if(session.getAttribute("sql_getPurchaseList") != null) {
				sql =	(String) session.getAttribute("sql_getPurchaseList");
				session.removeAttribute("sql_getPurchaseList");
			}
			//这个sql用来查询总数
			String sql_getTotalLines = sql.replaceAll("\\*", "count('purchaseid') as total");
			System.out.println(sql_getTotalLines);
			int totalLines = purchaseDao.getTotalLinesBySql(sql_getTotalLines);
			System.out.println(totalLines);
			int totalPage = ((totalLines%size == 0)? 0 : 1) + totalLines/size;
			System.out.println(totalLines/10);
			System.out.println("totalPage:"+totalPage);
			if(page >= totalPage && totalPage != 0) {
				page = totalPage;
			}
			//这个sql用来查询当前需要查询的pruchase数据
			String sql_getPurchaseList = sql + "  order by purchaseid desc limit " + (page-1)*size + " , " + size;
			System.out.println(sql_getPurchaseList);
			List<Purchase> list = purchaseDao.getPurchaseBySql(sql_getPurchaseList);
			request.setAttribute("purchaseList", list);
			request.setAttribute("page", page);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("linesNum", purchaseDao.getTotalLinesBySql(sql_getTotalLines));
			request.setAttribute("purchaseidToQuery", purchaseidToQuery);
			request.setAttribute("suppliername", suppliername);
			request.setAttribute("paystate", paystate);
			request.setAttribute("startDate", startDate);
			request.setAttribute("endDate", endDate);
			request.setAttribute("disposestate", disposestate);
			List<Supplier> listSupplier = supplierDao.getSupplier();
			request.setAttribute("supplierList", listSupplier);
			request.getRequestDispatcher("pomain_sel.jsp").forward(request, response);
		}else if("pur_endAll".equals(option)) {
			log.info(" option = pur_ednAll");
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
			List<Purchase> list = null;
			int totalPage = 0;
			int totalLines = 0;
			
			if("1".equals(paystate) || "2".equals(paystate) || "3".equals(paystate)) {
				totalLines = purchaseDao.getPurchaseConditionCountByPaystate(paystate);
				totalPage =  (totalLines%size == 0)? 0 : 1 + totalLines/size;
				if(page > totalPage && totalPage != 0) {
					page = totalPage;
				}
				request.setAttribute("page", page);
				page = (page-1)*size ;
				list  = purchaseDao.getPurchaseConditionByPaystate(page, size, paystate);
			}else {
				totalLines = purchaseDao.getPurchaseCount();
				totalPage =  (totalLines%size == 0)? 0 : 1 + totalLines/size;
				if(page > totalPage) {
					page = totalPage;
				}
				System.out.println("page:"+page);
				request.setAttribute("page", page);
				page = (page-1)*size ;
				list  = purchaseDao.getPurchaseByCondition(page,size);
				
				System.out.println("totalPage:"+totalPage);
				System.out.println("linesNum:"+totalLines);
				
			}
			request.setAttribute("purchaseList", list);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("linesNum", totalLines);
			request.setAttribute("paystate", paystate);
			request.getRequestDispatcher("pomain_end.jsp").forward(request, response);
		}else if("purToEnd".equals(option)) {
			log.info(" option = purToEnd");
			String paystate = request.getParameter("paystate");
			String purchaseid = request.getParameter("purchaseid");
			//张三是通过 session中的user中的realname得来的
			purchaseDao.updateDisposestate(purchaseid, "4",((Admins)session.getAttribute("admins")).getRealname());
			request.getRequestDispatcher("Purchase?option=pur_endAll&paystate="+paystate).forward(request, response);
		}else if("deletePur".equals(option)) {
			log.info(" option = deletePur");
			String purchaseid = request.getParameter("purchaseid");
			System.out.println("purchaseid");
			//通过purid查询出所有采购单明细
			List<PurchaseDet> purDetList = purchaseDetDao.selectPurchaseDet(purchaseid);
			//通过采购单明细 减少采购在途数
			for (PurchaseDet purchaseDet : purDetList) {
				purchaseDetDao.updateStorageByPurchaseDet(purchaseDet);
			}
			purchaseDetDao.deletePurchaseDet(purchaseid);
			purchaseDao.deletePurchaseid(purchaseid);
			request.getRequestDispatcher("Purchase?option=queryPur").forward(request, response);
		}else if("pur_detail".equals(option)) {
			log.info(" option = pur_detail");
			String purchaseid = request.getParameter("purchaseid");
			String url = request.getParameter("url");
			String edit = request.getParameter("edit");
			PurchaseAllInfo purAllInfo = purchaseDao.getPurPurchaseAllInfoByPurchaseid(purchaseid);
			List<PurchaseDet> purDetList = purchaseDetDao.selectPurchaseDet(purchaseid);
			String purchaseidToQuery = request.getParameter("purchaseidToQuery");
			String suppliername = request.getParameter("suppliername");
			String paystate = request.getParameter("paystate");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			String disposestate = request.getParameter("disposestate");
			String sql = makeSQLToSelect(purchaseidToQuery, startDate, endDate, paystate, disposestate,suppliername);
			List<Storage> list = storageDao.getStorage();
			session.setAttribute("sql_getPurchaseList", sql);
			request.setAttribute("purAllInfo", purAllInfo);
			request.setAttribute("purDetList", purDetList);
			request.setAttribute("storageList", list);
			request.setAttribute("edit", edit);
			System.out.println("edit="+edit);
			request.setAttribute("url", url);
			System.out.println(purDetList);
			request.getRequestDispatcher("pomain_detail.jsp").forward(request, response);
		}
	}
	//查询
	private String makeSQLToSelect(String purchaseid,String startDate,String endDate,String paystate,String disposestate,String suppliername) {
		
		//表名可自己修改
		String sql = "select * from purchase where ";
		int length = sql.length();
		if(!"".equals(purchaseid) && null != purchaseid) {
			sql = sql + " purchaseid like '%" + purchaseid + "%' and";
		}
		if(!"请选择".equals(paystate) && null != paystate) {
			sql = sql + " paystate= '" + paystate + "' and";
		}
		if(!"请选择".equals(suppliername) && null != suppliername) {
			sql = sql + " suppliername= '" + suppliername + "' and";
		}
		if(!"请选择".equals(disposestate) && null != disposestate) {
			sql = sql + " disposestate= '" + disposestate + "' and";
		}
		if(!"".equals(startDate) && !"".equals(endDate) && null != endDate ) {
			sql = sql + " createtime > '"+startDate+"' and createtime < '" + endDate + "' and";
		}
		if(sql.length() > length) {
			sql = sql.substring(0, sql.length()-4);
		}else {
			sql = sql.substring(0, sql.length()-7);
		}
		//System.err.println(sql);
		return sql;
	}

}
