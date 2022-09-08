package com.batis.test.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.batis.test.bankMembers.BankMembersDTO;
import com.batis.test.board.impl.BoardDTO;

public class WriterCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		String method = request.getMethod();
		
		if(method.equals("POST")) {
			return;
		}
		

		//로그인 사용자의 ID와 DTO의 작성자가 일치하는가?
		
		//로그인 사용자 정보
		BankMembersDTO bankMembersDTO = (BankMembersDTO)request.getSession().getAttribute("member");
		
		//DTO
		Map<String, Object> map =  modelAndView.getModel();
		BoardDTO boardDTO = (BoardDTO)map.get("boardDTO");
		
		//		map.keySet();	//키가 뭔지 모를때 key들을 set타입으로 모아둔것
		
								//자바는 == 대신 .equals 사용
		if(!bankMembersDTO.getUserName().equals(boardDTO.getWriter())) {
			System.out.println("session 가져오기 =="+bankMembersDTO.getUserName());
			System.out.println("작성자 정보 =="+boardDTO.getWriter());
			modelAndView.setViewName("common/result");		
			modelAndView.addObject("result", 1);
			modelAndView.addObject("message", "작성자만 수정이 가능합니다.");
			modelAndView.addObject("url", "./list.ms");
			
		}
		System.out.println("Writer Interceptor");
		
		super.postHandle(request, response, handler, modelAndView);
	}

}
