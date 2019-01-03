package com.aowin.scm.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.aowin.scm.adminmanage.pojo.Admins;

/**
 * 系统登录安全处理过滤器
 * 
 * @author ty
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

	private Logger log = Logger.getLogger(LoginFilter.class);

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		HttpSession session = request.getSession();

		String uri = request.getRequestURI();
		StringBuffer url = request.getRequestURL();
		log.info("url: " + url);
		log.info("请求路径：" + uri);
		Admins admin = (Admins) session.getAttribute("admins");
		if ("/SCM_GAY/login.jsp".equals(uri) || "/SCM_GAY/title.jsp".equals(uri)
				|| "/SCM_GAY/dynamic_bar_h.htm".equals(uri) || "/SCM_GAY/dynamic_bar_v.htm".equals(uri)
				|| "/SCM_GAY/index.htm".equals(uri) || "/SCM_GAY/wellcome.jsp".equals(uri)
				|| "/SCM_GAY/catalog.htm".equals(uri) ||"/SCM_GAY/nopermit.jsp".equals(uri)) {
			chain.doFilter(request, response);
			return;
		} else if (uri.endsWith(".js") || uri.endsWith(".css") || uri.endsWith(".gif") || uri.endsWith(".jpg")) {
			chain.doFilter(request, response);
			return;
		} else if ("/SCM_GAY/Login".equals(uri) || uri.contains("Admins")) {
			chain.doFilter(request, response);
			return;
		}
		//如果登录了 判断权限
		if (admin != null) {
			if (uri.contains("/SCM_GAY/user/") && "1".equals(admin.getUser_permit())) {
				chain.doFilter(request, response);
				return;
			} else if (uri.contains("/SCM_GAY/web_pro/") && "1".equals(admin.getPo_permit())) {
				chain.doFilter(request, response);
				return;
			} else if (uri.contains("/SCM_GAY/storage/") && "1".equals(admin.getDepot_permit())) {
				chain.doFilter(request, response);
				return;
			} else if (uri.contains("/SCM_GAY/finance/") && "1".equals(admin.getFinance_permit())) {
				chain.doFilter(request, response);
				return;
			} else if (uri.contains("/SCM_GAY/salsehtml/") && "1".equals(admin.getSale_permit()) ) {
				chain.doFilter(request, response);
				return;
			}else if(uri.contains("/SCM_GAY/report/") && "1".equals(admin.getReport_permit())){
				chain.doFilter(request, response);
				return;
			}
		}else {
			//如果没有登录先登录
			response.sendRedirect("/SCM_GAY/login.jsp");
		}
	
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
