package com.batis.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.batis.test.bankMembers.BankMembersDAO;

public class MemberInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("member");
		
		System.out.println(bankMembersDAO);
		
		if(obj != null) {
			return true;
		}else {
			System.out.println("로그인 안했잖아;");
			response.sendRedirect("../../../../../bankmembers/login.ms");
			return false;
		}
	}

}
