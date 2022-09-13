package com.batis.test.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.batis.test.bankMembers.BankMembersDTO;
import com.batis.test.bankMembers.RoleDTO;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter{
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//1.
		BankMembersDTO bankMembersDTO =  (BankMembersDTO)request.getSession().getAttribute("member");
		
		boolean check = false;
		
		for(RoleDTO roleDTO  : bankMembersDTO.getRoleDTOs()){ 
			System.out.println(roleDTO.getRoleNum());
			System.out.println(roleDTO.getRoleName());
			if(roleDTO.getRoleName().equals("ADMIN")) {
				check=true;
				break;
			}//if end
		}//for end
		
		//admin이 아닐때
		if(!check) {
			request.setAttribute("message", "권한이 없습니다.");	//controller의 model 역할
			request.setAttribute("url", "../../../../../");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp"); //jsp의 경로 (어딘지모르기때문에 절대경로사용) IRV를 거치지않아 처음부터 써줘어야 함
			view.forward(request, response);
		}
		
		return check;
	}

}
