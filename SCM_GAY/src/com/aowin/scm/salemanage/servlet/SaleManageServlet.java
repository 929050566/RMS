package com.aowin.scm.salemanage.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSpinnerUI;

import org.apache.log4j.Logger;

import com.aowin.scm.adminmanage.pojo.Admins;
import com.aowin.scm.purchasemanager.pojo.Purchase;
import com.aowin.scm.purchasemanager.pojo.PurchaseAllInfo;
import com.aowin.scm.purchasemanager.pojo.PurchaseDet;
import com.aowin.scm.salemanage.dao.ProManageDAOImpl;
import com.aowin.scm.salemanage.dao.SaleManageDAOImpl;
import com.aowin.scm.salemanage.pojo.ProductManageModle;
import com.aowin.scm.salemanage.pojo.SaleAllInfo;
import com.aowin.scm.salemanage.pojo.SaleManageDetModel;
import com.aowin.scm.salemanage.pojo.SaleMangeModel;
import com.aowin.scm.salemanage.pojo.SalePrices;
import com.aowin.scm.storagemanage.dao.StorageDAO;
import com.aowin.scm.storagemanage.pojo.Storage;
import com.aowin.scm.supplier.pojo.Supplier;
import com.aowin.scm.utils.DaoFactory;

/**
 * Servlet implementation class SaleManageServlet
 */
@WebServlet("/salsehtml/SaleManageServlet")
public class SaleManageServlet extends HttpServlet {

	private Logger log = Logger.getLogger(this.getClass());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaleManageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String option = request.getParameter("option");
		HttpSession session = request.getSession();
		ProManageDAOImpl pmo = (ProManageDAOImpl) DaoFactory.getInstance("ProManageDAO");
		SaleManageDAOImpl sale = (SaleManageDAOImpl) DaoFactory.getInstance("SaleManageDAO");
		StorageDAO storageDao = (StorageDAO) DaoFactory.getInstance("StorageDAO");
		if ("gettimes".equals(option)) {
			session.removeAttribute("time_id");
			session.removeAttribute("allpro");
			session.removeAttribute("nowtime");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String time = sdf.format(new Date());
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
			String time1 = sdf2.format(new Date());
			ArrayList<ProductManageModle> allpro = pmo.getallproduct();
			session.setAttribute("allpro", allpro);
			session.setAttribute("time_id", time);
			session.setAttribute("nowtime", time1);
			request.setAttribute("createname", ((Admins)session.getAttribute("admins")).getRealname());
			request.getRequestDispatcher("AddSalseDillone.jsp").forward(request, response);
		} else if ("addsale".equals(option)) {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			SaleMangeModel salenew = new SaleMangeModel();
			String[] proid = request.getParameterValues("proid");
			String[] pronum = request.getParameterValues("pronum");
			String[] proPrice = request.getParameterValues("totalprice");
			String poid = request.getParameter("poId");
			String vName = request.getParameter("vName");
			String createper = request.getParameter("textfield");
			String tipFee = request.getParameter("extramoney");// 附加费用
			String productTotal = request.getParameter("totalproprices");// 产品总价
			String payType = request.getParameter("payType"); // 123形式保存
			String prepayfee = request.getParameter("prePayFee"); // 最低预付款金额
			String saletotalprice = request.getParameter("totalprices");
			String remark = request.getParameter("remark"); // 备注
			salenew.setSaleid(poid);
			salenew.setCustomername(vName);
			salenew.setCreatename(createper);
			salenew.setExtramoney(Float.parseFloat(tipFee));
			salenew.setPaystate(payType);
			salenew.setTotalproprices(Float.parseFloat(productTotal));
			salenew.setTotalprices(Float.parseFloat(saletotalprice));
			salenew.setComment(remark);
			sale.insertsale(salenew);
			for (int i = 0; i < proid.length; i++) {// 每有一个产品详情就添加
				ProductManageModle pm = pmo.getProduct(Integer.parseInt(proid[i]));
				SaleManageDetModel saledet = new SaleManageDetModel();
				SalePrices price = pmo.getproprice(pm.getProduct_id());
				saledet.setSaleid(poid);
				saledet.setProduct_name(pm.getProduct_name());
				saledet.setProduct_id(pm.getProduct_id());
				saledet.setProduct_unit(pm.getProduct_unit());
				saledet.setProduct_quantity(Integer.parseInt(pronum[i]));
				saledet.setProduct_dettotalprice(Double.parseDouble(proPrice[i]));
				saledet.setProduct_unitprice(price.getProsaleprices());
				sale.insertsaledel(saledet);
				sale.insert_stroagenum(saledet);
			}
			response.getWriter().write( "<script>alert('添加成功'); window.location='AddSalseDillone.jsp';window.close();</script>"); 
			response.getWriter().flush();
		} else if ("startQuery".equals(option)) {
			request.setAttribute("custmerList", sale.getAllCustomerName());
			request.getRequestDispatcher("SalseDill_select.jsp").forward(request, response);
		} else if ("querySale".equals(option)) {
			String pageString = request.getParameter("page");
			int page = 1;
			int size = 10;
			if (pageString != null) {
				page = Integer.parseInt(pageString);
			}
			if (page <= 1) {
				page = 1;
			}
			String salebilidToQuery = request.getParameter("salebilidToQuery");
			String customername = request.getParameter("customername");
			String paystate = request.getParameter("paystate");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			String disposestate = request.getParameter("disposestate");
			String sql = makeSQLToSelect(salebilidToQuery, startDate, endDate, paystate, disposestate, customername);
			if (session.getAttribute("sql_getPurchaseList") != null) {
				sql = (String) session.getAttribute("sql_getPurchaseList");
				session.removeAttribute("sql_getPurchaseList");
			}
			// 这个sql用来查询总数
			String sql_getTotalLines = sql.replaceAll("\\*", "count('salebillid') as total");
			System.out.println(sql_getTotalLines);
			int totalLines = sale.getCountBySql(sql_getTotalLines);
			System.out.println(totalLines);
			int totalPage = ((totalLines % size == 0) ? 0 : 1) + totalLines / size;
			System.out.println(totalLines / 10);
			System.out.println("totalPage:" + totalPage);
			if (page >= totalPage && totalPage != 0) {
				page = totalPage;
			}
			// 这个sql用来查询当前需要查询的pruchase数据
			String sql_getPurchaseList = sql + "  order by salebillid desc limit " + (page - 1) * size + " , " + size;
			System.out.println(sql_getPurchaseList);
			List<SaleMangeModel> list = sale.getListBySql(sql_getPurchaseList);
			request.setAttribute("saleList", list);
			request.setAttribute("page", page);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("linesNum", totalLines);
			request.setAttribute("salebilidToQuery", salebilidToQuery);
			request.setAttribute("customername", customername);
			request.setAttribute("paystate", paystate);
			request.setAttribute("startDate", startDate);
			request.setAttribute("endDate", endDate);
			request.setAttribute("disposestate", disposestate);
			request.setAttribute("custmerList", sale.getAllCustomerName());
			request.getRequestDispatcher("SalseDill_select.jsp").forward(request, response);
		} else if ("deletePur".equals(option)) {
			String salebillid = request.getParameter("salebillid");
			String salebillidToQuery = request.getParameter("salebilidToQuery");
			System.err.println("salebillidToQuery:" + salebillidToQuery);
			String customername = request.getParameter("customername");
			String paystate = request.getParameter("paystate");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			String disposestate = request.getParameter("disposestate");
			String page = request.getParameter("page");
			System.out.println("salebillid=" + salebillid);
			// 通过purid查询出所有采购单明细
			List<SaleManageDetModel> saleDetList = sale.getsale_det(salebillid);
			// 通过采购单明细 减少采购在途数
			for (SaleManageDetModel saleDet : saleDetList) {
				storageDao.updaCKBYID(saleDet.getProduct_id(), 0, saleDet.getProduct_quantity());
			}
			sale.deleteSaleDet(salebillid);
			sale.deleteSale(salebillid);
			request.setAttribute("page", page);
			request.setAttribute("salebilidToQuery", salebillidToQuery);
			request.setAttribute("customername", customername);
			request.setAttribute("paystate", paystate);
			request.setAttribute("startDate", startDate);
			request.setAttribute("endDate", endDate);
			request.setAttribute("disposestate", disposestate);
			request.getRequestDispatcher("SaleManageServlet?option=querySale").forward(request, response);
		} else if ("saleEnd".equals(option)) {
			String pageString = request.getParameter("page");
			int page = 1;
			int size = 10;
			if (pageString != null) {
				page = Integer.parseInt(pageString);
			}
			if (page <= 1) {
				page = 1;
			}
			String paystateToQuery = request.getParameter("paystateToQuery");
			System.out.println("paystateToQuery:" + paystateToQuery);
			List<SaleMangeModel> list = null;
			int totalPage = 0;
			int totalLines = 0;
			if ("1".equals(paystateToQuery) || "2".equals(paystateToQuery) || "3".equals(paystateToQuery)) {
				totalLines = sale.getCountByConditionAndPaystateSale(paystateToQuery);
				totalPage = ((totalLines % size == 0) ? 0 : 1) + totalLines / size;
				if (page > totalPage && totalPage != 0) {
					page = totalPage;
				}
				request.setAttribute("page", page);
				page = (page - 1) * size;
				list = sale.getListByConditionAndPaystateSale(page, size, paystateToQuery);
			} else {
				totalLines = sale.getCountByConditionSale();
				totalPage = ((totalLines % size == 0) ? 0 : 1) + totalLines / size;
				if (page > totalPage && totalPage != 0) {
					page = totalPage;
				}
				System.out.println("page:" + page);
				request.setAttribute("page", page);
				page = (page - 1) * size;
				list = sale.getListByConditionSale(page, size);
				System.out.println("totalPage:" + totalPage);
				System.out.println("linesNum:" + totalLines);

			}
			request.setAttribute("saleList", list);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("linesNum", totalLines);
			request.setAttribute("paystateToQuery", paystateToQuery);
			request.getRequestDispatcher("AddSalseDill_end.jsp").forward(request, response);
		} else if ("setEnd".equals(option)) {
			String paystateToQuery = request.getParameter("paystateToQuery");
			String saleid = request.getParameter("saleid");
			// 张三是通过 session中的user中的realname得来的
			sale.updateDisposestate(saleid, "4", ((Admins)session.getAttribute("admins")).getRealname());
			request.getRequestDispatcher("SaleManageServlet?option=saleEnd&paystateToQuery=" + paystateToQuery)
					.forward(request, response);
		} else if ("updateDet".equals(option)) {
			log.info("option=updateDet");
			String saleid = request.getParameter("saleid");
			String customername = request.getParameter("customername");
			String createname = request.getParameter("createname");
			String extramoney = request.getParameter("extramoney");
			String totalproprices = request.getParameter("totalproprices");
			String totalprices = request.getParameter("totalprices");
			String paystate = request.getParameter("paystate");
			String advanceprice = request.getParameter("advanceprice");
			String comment = request.getParameter("comment");
			String createtime = request.getParameter("createtime");
			String disposestate = request.getParameter("disposestate");
			SaleMangeModel saleModel = new SaleMangeModel();
			saleModel.setDisposestate(disposestate);
			saleModel.setSaleid(saleid);
			saleModel.setCustomername(customername);
			saleModel.setCreatename(createname);
			float extra = Float.parseFloat(extramoney);
			saleModel.setExtramoney(extra);
			float total = Float.parseFloat(totalproprices);
			saleModel.setTotalproprices(total);
			saleModel.setPaystate(paystate);
			float advance = Float.parseFloat(advanceprice);
			saleModel.setAdvanceprice(advance);
			saleModel.setComment(comment);
			saleModel.setCreatetime(createtime);
			float totalpri = Float.parseFloat(totalproprices);
			saleModel.setTotalprices(totalpri);
			sale.updateSale(saleModel);
			System.out.println(saleModel);

			String[] proid = request.getParameterValues("proid");
			String[] proname = request.getParameterValues("proname");
			String[] prounit = request.getParameterValues("prounit");
			String[] pronum = request.getParameterValues("pronum");
			String[] unitprice = request.getParameterValues("unitprice");
			String[] totalprice = request.getParameterValues("totalprice");
			String[] detid = request.getParameterValues("detid");
			List<SaleManageDetModel> saleDetList = sale.getsale_det(saleid);
			System.err.println("detid:"+detid);
			for (int i = 0; i < proid.length; i++) {
				SaleManageDetModel saleDet = new SaleManageDetModel();
				int id = Integer.parseInt(proid[i]);
				saleDet.setProduct_id(id);
				saleDet.setProduct_name(proname[i]);
				saleDet.setProduct_unit(prounit[i]);
				saleDet.setSaleid(saleid);
				if (detid != null && i < detid.length) {
					saleDet.setDetid(Integer.parseInt(detid[i]));
				}
				float unit = Float.parseFloat(unitprice[i]);
				saleDet.setProduct_unitprice(unit);
				float tot = Float.parseFloat(totalprice[i]);
				saleDet.setProduct_unitprice(tot);
				int num = Integer.parseInt(pronum[i]);
				saleDet.setProduct_quantity(num);
				log.info(saleDet);
				// 通过Purchaseid查出销售明细表中的明细信息 如果产品id相同 则先要减去库存表中对应的采购在途数
				boolean flag = true;
				for (int j = 0; j < saleDetList.size(); j++) {
					if (saleDetList.get(j).getDetid() == saleDet.getDetid()) {
						// 减去库存表中对应的采购在途数(与销售数)
						//storageDao.updateOnPurchaseNum(id, -purDetList.get(j).getPronum());
						storageDao.updaCKBYID(id, 0, saleDetList.get(j).getProduct_quantity());
						// 增加库存表中的采购在途数(预销售数)
						storageDao.updateOnPurchaseNum(id, num);
						storageDao.updaCKBYID(id, 0, -num);
						//System.err.println(purchasedet.getProname());
						// 修改产品细节表
						sale.updateSaleDet(saleDet);
//						purchaseDetDao.updatePurchaseDet(purchasedet);
						// 将处理过的销售细节信息减去
						saleDetList.remove(saleDetList.get(j));
//						purDetList.remove(purDetList.get(j));
						flag = false;
						break;
					}
				}
				// 如果是新增的 则需要添加产品明细 和 修改预销售数
				if (flag) {
//					purchaseDetDao.insertPurchaseDet(purchasedet);
					sale.insertsaledel(saleDet);
					storageDao.updaCKBYID(id, 0, -num);
					//storageDao.updateOnPurchaseNum(purchasedet.getProid(), num);
				}
			}
			// 剩下的 销售单对应的明细信息 说明是被删除了的 应该减去
			for (SaleManageDetModel saleDet : saleDetList) {
				sale.deleteSaleDetByDetid(saleDet.getDetid());
				storageDao.updaCKBYID(saleDet.getProduct_id(), 0, saleDet.getProduct_quantity());
			}
//			for (PurchaseDet purDet : purDetList) {
//				purchaseDetDao.deletePurchaseDetByDetid(purDet.getDetid());
//				storageDao.updateOnPurchaseNum(purDet.getProid(), -purDet.getPronum());
//			}
			request.getRequestDispatcher("SaleManageServlet?option=querySale").forward(request, response);
		} else if ("sale_detail".equals(option)) {
			log.info("option = sale_detail");
			String saleid = request.getParameter("saleid");
			String url = request.getParameter("url");
			String edit = request.getParameter("edit");
			SaleAllInfo saleAllInfo = sale.getSaleAllInfoBySaleid(saleid);
			List<SaleManageDetModel> saleDetList = sale.getsale_det(saleid);
			List<Storage> list = storageDao.getStorage();
			System.err.println(saleAllInfo);
			String salebillidToQuery = request.getParameter("salebillidToQuery");
			String customername = request.getParameter("customername");
			String paystate = request.getParameter("paystate");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			String disposestate = request.getParameter("disposestate");
			String sql = makeSQLToSelect(salebillidToQuery, startDate, endDate, paystate, disposestate, customername);
			session.setAttribute("sql_getPurchaseList", sql);
			request.setAttribute("saleAllInfo", saleAllInfo);
			request.setAttribute("saleDetList", saleDetList);
			request.setAttribute("storageList", list);
			request.setAttribute("edit", edit);
			request.setAttribute("url", url);
			System.out.println(saleDetList);
			request.getRequestDispatcher("SalseDill_det.jsp").forward(request, response);
		}
	}

	// 查询
	private String makeSQLToSelect(String salebillid, String startDate, String endDate, String paystate,
			String disposestate, String customername) {

		// 表名可自己修改
		String sql = "select * from sale where ";
		int length = sql.length();
		if (!"".equals(salebillid) && null != salebillid) {
			sql = sql + " salebillid like '%" + salebillid + "%' and";
		}
		if (!"请选择".equals(paystate) && null != paystate) {
			sql = sql + " paystate= '" + paystate + "' and";
		}
		if (!"请选择".equals(customername) && null != customername) {
			sql = sql + " customername= '" + customername + "' and";
		}
		if (!"请选择".equals(disposestate) && null != disposestate) {
			sql = sql + " disposestate= '" + disposestate + "' and";
		}
		if (!"".equals(startDate) && !"".equals(endDate) && null != endDate) {
			sql = sql + " createtime > '" + startDate + "' and createtime < '" + endDate + "' and";
		}
		if (sql.length() > length) {
			sql = sql.substring(0, sql.length() - 4);
		} else {
			sql = sql.substring(0, sql.length() - 7);
		}
		System.err.println(sql);
		return sql;
	}

}
