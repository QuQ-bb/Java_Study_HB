package com.batis.test.bankMembers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/bankmembers/*")
public class BankMembersController {
	
	@Autowired
	private BankMembersService bankMembersService;
	
	//회원가입
	@RequestMapping(value="join.ms",method=RequestMethod.GET)
	public void join()throws Exception{
		System.out.println("JOIN GET 실행");
	}
	@RequestMapping(value="join.ms", method= RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO)throws Exception{
		System.out.println("JOIN POST 실행");
		bankMembersService.join(bankMembersDTO);
		
		return "redirect:/";
	}
	//로그인
	@RequestMapping(value="login.ms",method=RequestMethod.GET)
	public void login()throws Exception{
		System.out.println("LOGIN GET 실행");
	}
	@RequestMapping(value="login.ms",method=RequestMethod.POST)
	public String login(BankMembersDTO bankMembersDTO)throws Exception{
		System.out.println("LOGIN POST 실행");
		bankMembersDTO =  bankMembersService.login(bankMembersDTO);
		System.out.println(bankMembersDTO.getUserName());
		System.out.println(bankMembersDTO.getName());
		System.out.println(bankMembersDTO.getEmail());
		System.out.println(bankMembersDTO.getPhone());
		
		return "redirect:/";
	}
	//ID찾기
	@RequestMapping(value="searchID.ms" ,method=RequestMethod.GET)
	public void searchID()throws Exception{
		System.out.println("searchID get 실행");
	}
	@RequestMapping(value="searchID.ms", method=RequestMethod.POST)
	public ModelAndView searchID(String search)throws Exception{
		System.out.println("searchID post 실행");
		ModelAndView mv = new ModelAndView();
		List<BankMembersDTO> al = bankMembersService.searchID(search);
		
		mv.setViewName("/bankmembers/list");
		mv.addObject("search", al);

		return mv;
		
	}

}
