package org.sonusoft.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class SessionTimeoutInterceptor extends HandlerInterceptorAdapter{
	private static final long MAX_INACTIVE_SESSION_TIME = 5 * 10000;
	
	@Autowired
	private HttpSession session;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		session=request.getSession();
		long lastReqTime=System.currentTimeMillis() - request.getSession().getLastAccessedTime();
		System.out.println("Time since last request in this session: {} ms :: " +lastReqTime);
		if(lastReqTime>MAX_INACTIVE_SESSION_TIME) {
			response.sendRedirect("http://localhost:8080/hello/logout");
			return false;
		}
		return true;
	}
}
