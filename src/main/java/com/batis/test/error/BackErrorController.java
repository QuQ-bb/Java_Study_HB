package com.batis.test.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice //예외 처리를 전문적으로 하는 컨트롤러라는 듯
public class BackErrorController {

		//ExceptionHandler method만 모임
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView exceptionTest(){
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("errors/error_404");
		
		return mv;
	}
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionTest2(){
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("errors/error_404");
		
		return mv;
	}
}
