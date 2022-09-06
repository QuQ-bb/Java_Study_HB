package com.batis.test.bankBook;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.batis.test.util.CommentPager;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
	
	@Autowired
	BankBookService service;
	
	//Comment
//	@PostMapping("commentAdd")
//	@RequestMapping(value="commentAdd",method=RequestMethod.POST)
//	public ModelAndView setCommentAdd(BankBookCommentDTO bankBookCommentDTO)throws Exception {
//		System.out.println(bankBookCommentDTO.getBookNum());
//		System.out.println(bankBookCommentDTO.getWriter());
//		System.out.println(bankBookCommentDTO.getContents()
//		ModelAndView mv = new ModelAndView();
//		int result = service.setCommentAdd(bankBookCommentDTO);
//		mv.addObject("result", result);
//		mv.setViewName("/common/ajaxResult");
//		return mv;
//	}
	
	@RequestMapping(value="commentAdd",method=RequestMethod.POST)
	@ResponseBody //jsp를 거치지않고 바로 응답으로 보내버림
	public String setCommentAdd(BankBookCommentDTO bankBookCommentDTO)throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = service.setCommentAdd(bankBookCommentDTO);
		String jsonResult = "{\"result\":\""+result+"\"}";	//{"result":"result"}
		
		return jsonResult;
	}
//	@RequestMapping(value="commentList", method= RequestMethod.GET)
//	public ModelAndView getCommentList(CommentPager commentPager)throws Exception{
//		ModelAndView mv = new ModelAndView();
//		List<BankBookCommentDTO> al = service.getCommentList(commentPager);
//			System.out.println("CommentList");
//			System.out.println(al.size());
//			
//			mv.addObject("commentList", al);
//			mv.setViewName("common/commentList");
//			
//			return mv;
//	}
	
	@RequestMapping(value="commentList", method= RequestMethod.GET)
	@ResponseBody
	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager)throws Exception{
		List<BankBookCommentDTO> al = service.getCommentList(commentPager);
			System.out.println("CommentList");
			System.out.println(al.size());
	
			//json
			//DTO == {}
			// num=1 =={"num":1, "bookNum":123, "writer":"홍길이"}
			//[{"num":1, "bookNum":123, "writer":"홍길이"},{"num":1, "bookNum":123, "writer":"홍길이"},{"num":1, "bookNum":123, "writer":"홍길이"}...]
			
			return al;
	}
	//-------------------------------------------------------------------
	
	@RequestMapping(value = "list.ms", method = RequestMethod.GET)
	public void list(HttpServletRequest request) {
		System.out.println("list Controller");
		
		request.setAttribute("bankBookList", service.getList());
	}
	
	@RequestMapping(value = "detail.ms", method = RequestMethod.GET)
	public void detail(Model model,BankBookDTO dto) {
		System.out.println("detail Controller");
		
		dto = service.getDetail(dto);
		model.addAttribute("bankBook", dto);
	}
	
	@RequestMapping(value = "add.ms", method = RequestMethod.GET)
	public void add() {
		System.out.println("add controller");
	}
	
	@RequestMapping(value = "add.ms", method = RequestMethod.POST)
	public String add(BankBookDTO dto) {
		System.out.println("상품 db 등록 Controller");
		
		Calendar cal = Calendar.getInstance();
		
		System.out.println(dto.getBookName());
		dto.setBookNum(cal.getTimeInMillis());
		System.out.println(dto.getBookRate());
		
		service.addBankBook(dto);
		
		return "redirect: ./list.ms";
	}
	
	@RequestMapping(value = "update.ms", method = RequestMethod.GET)
	public void update(HttpServletRequest request) {
		System.out.println("상풍 update 페이지");
		
		BankBookDTO dto = new BankBookDTO();
		dto.setBookNum(Long.parseLong(request.getParameter("bookNum")));
		
		dto = service.getDetail(dto);
		request.setAttribute("bankBook", dto);
	}
	
	@RequestMapping(value = "update.ms", method = RequestMethod.POST)
	public String update(BankBookDTO dto) {
		System.out.println("상품 db update");
		
		service.update(dto);
		return "redirect:./list.ms";
	}
	
	@RequestMapping(value="delete.ms", method= RequestMethod.GET)
	public String delete(BankBookDTO dto) {
		System.out.println("상품 삭제 method");
		
		int chk = service.delete(dto);
		
		System.out.println(chk +" : 1이면 성공");
		return "redirect:./list.ms";
	}
	
	
	
}
