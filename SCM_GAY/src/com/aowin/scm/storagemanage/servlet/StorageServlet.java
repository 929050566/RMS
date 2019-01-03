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
import com.aowin.scm.storagemanage.dao.IntoStorageDAO;
import com.aowin.scm.storagemanage.dao.OutStorageDAO;
import com.aowin.scm.storagemanage.dao.StorageDAO;
import com.aowin.scm.storagemanage.pojo.IntoStorage;
import com.aowin.scm.storagemanage.pojo.OutStorage;
import com.aowin.scm.storagemanage.pojo.Storage;
import com.aowin.scm.utils.DaoFactory;




/** 
 * SCM库存管理模块控制类
 * @author 李小龙
 * date:2018年11月16日 上午11:33:21
 *
 */
@WebServlet("/storage/type")
public class StorageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	private Logger log = Logger.getLogger(StorageServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StorageServlet() {
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
		System.out.println("option  "+option);
		String number = request.getParameter("number");//当前库存
		String innum = request.getParameter("inNum");//变化数量
		String pan = request.getParameter("pan");//盘点（更新）后库存
		String state = request.getParameter("state");//变化类型
		String reason = request.getParameter("reason");//盘点数量变化原因
		String proid = request.getParameter("proid");//产品编号
		String handle = request.getParameter("handle");//经手人
		String time = request.getParameter("time");//登记时间
		
		StorageDAO st = (StorageDAO) DaoFactory.getInstance("StorageDAO");
		HttpSession session = request.getSession();
		int pages = 1;
		int pagesize = 10;
		
		if("count".equals(option)) {
			log.info("option=count");
			Integer totalpages = (Integer) session.getAttribute("totalpages");
			if(totalpages == null) {
				totalpages = st.getStorageTotalPages(pagesize);
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
			List<Storage> list = st.getCountStorage(pages, pagesize);
			int num = st.getNum(pagesize);
			request.setAttribute("n", num);
			request.setAttribute("counts", list);
			request.setAttribute("pages", pages);
			request.setAttribute("totalpages", totalpages);
			request.getRequestDispatcher("count.jsp").forward(request, response);
		}else if("gx".equals(option)) {
			log.info("option=gx");
			request.setAttribute("number", number);
			request.setAttribute("proid", proid);
			request.getRequestDispatcher("gx.jsp").forward(request, response);
		}else if("aftercount".equals(option)) {
			log.info("option=aftercount  ");
			IntoStorage in = new IntoStorage();
			int id = Integer.parseInt(proid);
			in.setProId(id);
			int pannum = Integer.parseInt(pan);
			
			st.updaPersentNum(id,pannum);//盘点更新后修改库存
			in.setInoHandle(((Admins)session.getAttribute("admins")).getRealname());//?
			int inNum = Integer.parseInt(innum);
			in.setInNum(inNum);
			in.setInState(state);
			in.setInStorageDate("2018");
			in.setReason(reason);
				System.err.println("state="+state);
				if(state.equals("损耗")) {
					OutStorageDAO out =(OutStorageDAO) DaoFactory.getInstance("OutStorageDAO");
					OutStorage o = new OutStorage();
					o.setOutNum(inNum);
					o.setOutState(state);
					o.setOutStorageDate("2018");
					o.setReason(reason);
					o.setOutHandle(((Admins)session.getAttribute("admins")).getRealname());
					o.setProId(id);
					out.insertOutPandian(o);
				}else if(state.equals("盘余")) {
					IntoStorageDAO into =(IntoStorageDAO) DaoFactory.getInstance("IntoStorageDAO");
					into.insertPandian(in);
				}
				request.getRequestDispatcher("type?option=count").forward(request, response);
			}else if("find".equals(option)) {//库存查询
				log.info("option=find");
				Integer totalpages = (Integer) session.getAttribute("totalpages");
				if(totalpages == null) {
					totalpages = st.getStorageTotalPages(pagesize);
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
				List<Storage> list = st.getCountStorage(pages, pagesize);
				int num = st.getNum(pagesize);
				request.setAttribute("n", num);
				request.setAttribute("counts", list);
				request.setAttribute("pages", pages);
				request.setAttribute("totalpages", totalpages);
				request.getRequestDispatcher("finds.jsp").forward(request, response);
				
			}else if("findlink".equals(option)) {
				log.info("option=findlink");
				System.out.println();
				//String proid 
				String proname =request.getParameter("proname");
				String minnum = request.getParameter("minnum");
				String maxnum = request.getParameter("maxnum");
				String sql = "select * from storage where ";
				int oldlength = sql.length();
				if(!"".equals(proid)) {
					int id = Integer.parseInt(proid);
					sql = sql + "proid like '%" + id +"%' and ";
				}
				if(!"".equals(proname)) {
					sql = sql + "proname like '%" + proname +"%' and ";
				}
				if(!"".equals(minnum)) {
					sql = sql + "presentNum >=" + minnum +" and ";
				}
				if(!"".equals(maxnum)) {
					sql = sql + "presentNum  <= " + maxnum +" and ";
				}
				int newlenght = sql.length();
				if(sql.endsWith(" and ")) {
					sql=sql.substring(0,sql.length()-" and ".length());
				}
				if(oldlength==newlenght) {
					sql=sql.substring(0,sql.length()-" where ".length());
				}
				log.info(sql);
				
				
				List<Storage> select = st.getSelect(sql);
				request.setAttribute("s", select);
				
				request.getRequestDispatcher("finds.jsp").forward(request, response);
			}else if("kd".equals(option)) {
				log.info("option=kd");
				String proname = request.getParameter("proname");
				IntoStorageDAO in = (IntoStorageDAO)DaoFactory.getInstance("IntoStorageDAO");
				int id = Integer.parseInt(proid);
				List<IntoStorage> list = in.getIntoStorageByid(id);
				request.setAttribute("list",list);
				OutStorageDAO out = (OutStorageDAO)DaoFactory.getInstance("OutStorageDAO");
				List<OutStorage> olist = out.getOutStorageByid(id);
				System.out.println(id);
				request.setAttribute("olist",olist);
				System.out.println(olist.toString());
				request.getRequestDispatcher("kd.jsp").forward(request, response);
			}
	}

}
