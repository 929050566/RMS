package com.aowin.scm.adminmanage.servlet;

import java.io.IOException;

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

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	private Logger log = Logger.getLogger(this.getClass());
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminsDao adminsDao = new AdminsDaoImpl();
		HttpSession session = request.getSession();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String option = request.getParameter("option");
		
		if("login".equals(option)) {
			log.info("option=login,serlvet=Login");
			System.out.println("account:"+account+"  password:"+password);
			Admins admins= adminsDao.login(account, password);
			if(admins != null) {
				session.setAttribute("admins", admins);
				request.getRequestDispatcher("wellcome.jsp").forward(request, response);
			}else {
				request.setAttribute("error", "用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		
		
	}
	

}
