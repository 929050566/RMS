package com.aowin.scm.supplier.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.aowin.scm.supplier.dao.SupplierDao;
import com.aowin.scm.supplier.pojo.Supplier;
import com.aowin.scm.utils.DaoFactory;



/**
 * Servlet implementation class SupplierServlet
 */
@WebServlet("/web_pro/supplier")
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Logger log = Logger.getLogger(SupplierServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierServlet() {
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
		String page = request.getParameter("pages");
		System.out.println(option);
		SupplierDao supplierdao =  (SupplierDao) DaoFactory.getInstance("SupplierDao");
		if("supplieradd".equals(option)) {
			log.info("option=supplieradd");
			String supplieid = request.getParameter("supplieid");
			String suppliername = request.getParameter("suppliername");
			String velaname = request.getParameter("velaname");
			System.out.println(velaname);
			String supplierpassword = request.getParameter("supplierpassword");
			String address = request.getParameter("address");
			String mailnumber = request.getParameter("mailnumber");
			String phone = request.getParameter("phone");
			String faxes = request.getParameter("faxes");
			if("".equals(supplierpassword)) {
				supplierpassword=supplieid;
			}
			Supplier supplier=new Supplier();
			int id=Integer.parseInt(supplieid);
			supplier.setSupplieid(id);
			supplier.setSuppliername(suppliername);
			supplier.setAddress(address);
			supplier.setFaxes(faxes);
			supplier.setMailnumber(mailnumber);
			supplier.setPhone(phone);
			supplier.setSupplierpassword(supplierpassword);
			supplier.setVelaname(velaname);
			log.info(supplier);
			supplierdao.insertSupplier(supplier);
			response.getWriter().write( "<script>alert('添加成功'); window.location='supplier?option=showsupplier';window.close();</script>"); 
			response.getWriter().flush();
		}else if("showsupplier".equals(option)) {
			log.info("option=showsupplier");
			List<Supplier> list=supplierdao.getSupplier();
			log.info(list);
			request.setAttribute("suppliers", list);
			
			request.getRequestDispatcher("pomain_supplier.jsp").forward(request, response);
		}else if("deletesupplier".equals(option)) {
			log.info("option=deletesupplier");
			String supplieid= request.getParameter("supplieid");
			int id=Integer.parseInt(supplieid);
			supplierdao.deleteSupplier(id);
			response.getWriter().write( "<script>alert('删除成功'); window.location='supplier?option=showsupplier';window.close();</script>"); 
			response.getWriter().flush();
		}else if("updatesupplier".equals(option)) {
			log.info("option=updatesupplier");
			String supplieid= request.getParameter("supplieid");
			
			int id=Integer.parseInt(supplieid);
			log.info(id);
			Supplier supplier=new Supplier();
			supplier=supplierdao.selectSupplier(id);
			request.setAttribute("supplier", supplier);
			request.getRequestDispatcher("pomain_upd.jsp").forward(request, response);
		}else if("updbutton".equals(option)) {
			log.info("option=updbutton");
			String supplieid = request.getParameter("supplieid");
			String suppliername = request.getParameter("suppliername");
			String velaname = request.getParameter("velaname");
			
			String supplierpassword = request.getParameter("supplierpassword");
			String address = request.getParameter("address");
			String mailnumber = request.getParameter("mailnumber");
			String phone = request.getParameter("phone");
			String faxes = request.getParameter("faxes");
			Supplier supplier=new Supplier();
			int id=Integer.parseInt(supplieid);
			supplier.setSupplieid(id);
			supplier.setSuppliername(suppliername);
			supplier.setAddress(address);
			supplier.setFaxes(faxes);
			supplier.setMailnumber(mailnumber);
			supplier.setPhone(phone);
			supplier.setSupplierpassword(supplierpassword);
			supplier.setVelaname(velaname);
			log.info(supplier);
			supplierdao.updateSupplier(supplier);
			response.getWriter().write( "<script>alert('修改成功'); window.location='supplier?option=showsupplier';window.close();</script>"); 
			response.getWriter().flush();
		}else if("selectsupplier".equals(option)) {
			log.info("option=selectsupplier");
			request.removeAttribute("suppliers");
			String supplieid = request.getParameter("id");
			String suppliername = request.getParameter("name");
			System.out.println("supplieid:"+supplieid);
			System.out.println("suppliername："+suppliername);
			String sql = "select * from supplier where ";
			int oldLen = sql.length();
			if(!"".equals(supplieid)) {
				sql = sql + " supplieid like '%" + supplieid + "%'"+ "and";
			}
			if(!"".equals(suppliername)) {
				sql = sql + " suppliername like  '%" + suppliername +"%'" + "and";
			}
			if(sql.endsWith("and")) {//如果是以查询条件结尾
				sql=sql.substring(0, sql.length()-"and".length());//去除查询条件的长度
			}
			int newLen = sql.length();
			if(newLen == oldLen) {
				sql = sql.substring(0 , sql.length() - 7);
			}
			log.info(sql);
		
			List<Supplier> list=supplierdao.select(sql);
			log.info(list);
			request.setAttribute("suppliers", list);
			request.getRequestDispatcher("pomain_supplier.jsp").forward(request, response);
		}else if("checksupplieid".equals(option)) {
			log.info("option=checksupplieid");
			String supplieid = request.getParameter("supplieid");
		
			int id=Integer.parseInt(supplieid);
			
			response.getWriter().println(supplierdao.getSupplierById(id)?"可用":"不可用");
		}
	}

}
