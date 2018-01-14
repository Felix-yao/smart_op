package com.kkgame.adx.base;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest re = (HttpServletRequest) request;
		HttpServletResponse rs=(HttpServletResponse) response;
		
		HttpSession session = re.getSession();
		String contextPath=re.getContextPath();
		String url=re.getServletPath();
		
		if (!url.startsWith("/index")&&!url.startsWith("/login")&&!url.startsWith("/js")&&!url.startsWith("/css")
				&&!url.startsWith("/images")&&!url.startsWith("/fonts")){
			if (session.getAttribute(PkigConstants.SESSION_USER) != null) {
				chain.doFilter(request, response);
			} else {
				if (re.getHeader("x-requested-with") != null   && re.getHeader("x-requested-with").equals("XMLHttpRequest")) { // ajax请求  
					rs.setHeader("sessionstatus", "timeout");  
                } else {  
                	rs.sendRedirect(contextPath+"/index.jsp");
                }
			}
		}else{
			chain.doFilter(request, response);
		}
//		
//		if (session.getAttribute(PkigConstants.SESSION_USER) != null) {
//			chain.doFilter(request, response);
//		} else {
//			rs.sendRedirect(contextPath+"/index.jsp");
////			re.getRequestDispatcher("index.jsp").forward(request, response);
//		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
