package com.batis.test.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/error/*")
public class FrontErrorController {
	
	
	@GetMapping(value="error404")
	public ModelAndView error404()throws Exception{
		ModelAndView mv = new ModelAndView();
		
		System.out.println("Parameter가 틀림");
		mv.setViewName("errors/error_404");
		
		return mv;
	}
	@GetMapping(value="error500")
	public ModelAndView error500()throws Exception{
		ModelAndView mv = new ModelAndView();
		
		System.out.println("Server Exception 발생");
		mv.setViewName("errors/error_404");
		
		return mv;
	}

}
