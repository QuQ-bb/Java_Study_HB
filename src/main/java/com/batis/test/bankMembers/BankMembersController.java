package com.batis.test.bankMembers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/bankmembers/*")
public class BankMembersController {
	
	@Autowired
	private BankMembersService bankMembersService;
//	@Autowired
//	private BankAccountService bankAccountService;
	
	//회원가입
	@RequestMapping(value="join.ms",method=RequestMethod.GET)
	public void join()throws Exception{
		System.out.println("JOIN GET 실행");
	}
	@RequestMapping(value="join.ms", method= RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO,MultipartFile photo,HttpSession session)throws Exception{
//		
		
		
		System.out.println("JOIN POST 실행");
		
		System.out.println("업로드 시 파일명== "+photo.getOriginalFilename());
		System.out.println("업로드시 파라미터명"+photo.getName());
		System.out.println("업로드시 파일의 크기"+photo.getSize());
		bankMembersService.join(bankMembersDTO,photo,session);
		
		return "redirect:/";
	}
	//약관 동의
	@RequestMapping(value="/agree.ms", method= RequestMethod.GET)
	public String agree()throws Exception{
		System.out.println("약관동의 실행");
		return "bankmembers/agree";
	}
	//로그인
	@RequestMapping(value="login.ms",method=RequestMethod.GET)
	public void login()throws Exception{
		System.out.println("LOGIN GET 실행");
	}
	@RequestMapping(value="login.ms",method=RequestMethod.POST)
	public String login(BankMembersDTO bankMembersDTO,HttpSession session)throws Exception{
		System.out.println("LOGIN POST 실행");
		bankMembersDTO =  bankMembersService.login(bankMembersDTO);
		session.setAttribute("member", bankMembersDTO);
		
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
	//로그아웃
	@RequestMapping(value="logout.ms")
	public String logout(HttpSession session)throws Exception{
		session.invalidate();
		
		return "redirect:/";
	}
	//MYPAGE
	@RequestMapping(value="mypage.ms", method=RequestMethod.GET)
	public ModelAndView mypage(HttpSession session)throws Exception{
		System.out.println("mypage 실행");
		ModelAndView mv = new ModelAndView();
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
//		Map<String, Object> map = bankMembersService.mypage(bankMembersDTO);
//		mv.addObject("map", map);
		
		bankMembersDTO = bankMembersService.mypage(bankMembersDTO);
//		List<BankAccountDTO> al = bankAccountService.myAccount(bankMembersDTO);
//		mv.addObject("list", al);
		mv.addObject("dto", bankMembersDTO);
		mv.setViewName("bankmembers/mypage");
		
		return mv;
		
	}
	

}
