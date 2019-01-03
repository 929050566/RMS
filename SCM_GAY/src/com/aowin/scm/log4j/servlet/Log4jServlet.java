/**
 * 
 */
package com.aowin.scm.log4j.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;



/**
 * ��log4j�����ļ������õ�ǰ���̸�Ŀ¼
 * @author TY
 * create date: 2018��11��7�� ����9:39:47
 */
public class Log4jServlet extends HttpServlet {

	public Log4jServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init() throws ServletException {
		String file = super.getInitParameter("log4j");
		if(file != null) {
			String path = super.getServletContext().getRealPath("/");
			System.setProperty("webroot", path);
			PropertyConfigurator.configure(path+file);
		}
	}

}
