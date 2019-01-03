package com.aowin.scm.adminmanage.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.aowin.scm.adminmanage.dao.AdminsDao;
import com.aowin.scm.adminmanage.dao.AdminsDaoImpl;
import com.aowin.scm.adminmanage.pojo.Admins;

import sun.security.util.Password;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/user/Admins")
public class AdminsServlet extends HttpServlet {
	private Logger log = Logger.getLogger(this.getClass());
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminsDao adminsDao = new AdminsDaoImpl();
		HttpSession session = request.getSession();
		String account = request.getParameter("account");
		String realname = request.getParameter("realname");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String lock = request.getParameter("lock");
		String option = request.getParameter("option");
		
		if("query".equals(option)) {
			log.info(" option = query");
			request.setAttribute("account", account);
			request.setAttribute("realname", realname);
			request.setAttribute("startDate", startDate);
			request.setAttribute("endDate", endDate);
			request.setAttribute("lock", lock);
			String sql = makeSQL(account, realname, startDate, endDate, lock);
			List<Admins> list = adminsDao.getAdminsBySQL(sql);
			request.setAttribute("adminList", list);
			request.getRequestDispatcher("adminlist.jsp").forward(request, response);
		}else if("addAdminsLink".equals(option)) {
			log.info(" option = addAdminsLink");
			request.getRequestDispatcher("adminadd.jsp").forward(request, response);
		}else if("addAdmins".equals(option)) {
			log.info(" option = addAdmins");
			String[] permits = request.getParameterValues("permit");
			String[] passwords = request.getParameterValues("password");
			String[] accounts = request.getParameterValues("account");
			String password = passwords[1];
			account = accounts[1];
			Admins admins = new Admins();
			if("".equals(password)) {
				password = account;
			}
			admins.setPassword(password);
			admins.setAccount(account);
			admins.setRealname(realname);
			admins.setLock_statu(lock);
			for (String string : permits) {
				if("user".equals(string)) {
					admins.setUser_permit("1");
				}else if("po".equals(string)) {
					admins.setPo_permit("1");
				}else if("depot".equals(string)) {
					admins.setDepot_permit("1");
				}else if("sale".equals(string)) {
					admins.setSale_permit("1");
				}else if("report".equals(string)) {
					admins.setReport_permit("1");
				}else if("finance".equals(string)) {
					admins.setFinance_permit("1");
				}else if("networksale".equals(string)) {
					admins.setNetworksale_permit("1");
				}
			}
			System.out.println(admins);
			adminsDao.insertAdmins(admins);
			response.getWriter().println("<script>alert('添加成功'); window.location='adminlist.jsp';window.close();</script>");
		}else if("editAdminslink".equals(option)) {
			log.info(" option = editAdminslink");
			account = request.getParameter("accountUpdate");
			Admins admins = adminsDao.getAdminsByAccount(account);
			System.out.println(admins);
			request.setAttribute("admins", admins);
			request.getRequestDispatcher("adminedit.jsp").forward(request, response);
		}else if("editAdmins".equals(option)){
			log.info(" option = editAdmins");
			String[] permits = request.getParameterValues("permit");
			String[] passwords = request.getParameterValues("password");
			String password = passwords[1];
			Admins admins = new Admins();
			admins.setPassword(password);
			admins.setAccount(account);
			admins.setRealname(realname);
			admins.setLock_statu(lock);
			for (String string : permits) {
				if("user".equals(string)) {
					admins.setUser_permit("1");
				}else if("po".equals(string)) {
					admins.setPo_permit("1");
				}else if("depot".equals(string)) {
					admins.setDepot_permit("1");
				}else if("sale".equals(string)) {
					admins.setSale_permit("1");
				}else if("report".equals(string)) {
					admins.setReport_permit("1");
				}else if("finance".equals(string)) {
					admins.setFinance_permit("1");
				}else if("networksale".equals(string)) {
					admins.setNetworksale_permit("1");
				}
			}
			System.err.println(admins);
			adminsDao.updateAdmins(admins);
			response.getWriter().println("<script>alert('修改成功'); window.location='adminlist.jsp';window.close();</script>");
			response.getWriter().flush();
		}else if("deleteAdmins".equals(option)) {
			log.info(" option = deleteAdmins");
			account = request.getParameter("accountDelete");
			boolean flag = adminsDao.deleteAdmins(account);
			String msg = flag?"<script>alert('删除成功'); window.location='adminlist.jsp';window.close();</script>":"<script>alert('删除失败，请先删除关联信息'); window.location='adminlist.jsp';window.close();</script>";
			response.getWriter().println(msg);
			response.getWriter().flush();
		}else if("exit".equals(option)) {
			log.info(" option = option");
			String flag = request.getParameter("flag");
			session.removeAttribute("admins");
			response.getWriter().println("<script>window.open('../login.jsp', 'mainFrame')</script>");
			response.getWriter().flush();
		}else if("checkAccount".equals(option)) {
			log.info(" option = checkAccount");
			boolean flag = adminsDao.accountIsExist(account);
			String msg = flag?"用户名已经被使用":"用户名可用";
			response.getWriter().println(msg);
		}
		
	}
	
	private String makeSQL(String account,String realname,String startDate,String endDate,String lock) {
		
		//表名可自己修改
		String sql = "select * from user where ";
		int length = sql.length();
		if(!"".equals(account)) {
			sql = sql + " account = '" + account + "' and";
		}
		if(!"".equals(realname)) {
			sql = sql + " realname = '" + realname + "' and";
		}
		if(!"all".equals(lock)) {
			sql = sql + " lock_statu= '" + lock + "' and";
		}
		if(!"".equals(startDate) && !"".equals(endDate)) {
			sql = sql + " createdate > '"+startDate+"' and createdate < '" + endDate + "' and";
		}
		if(sql.length() > length) {
			sql = sql.substring(0, sql.length()-4);
		}else {
			sql = sql.substring(0, sql.length()-7);
		}
		System.err.println(sql);
		return sql;
	}

}
