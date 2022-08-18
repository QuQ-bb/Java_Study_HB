package com.batis.test.bankBook;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
	
	@Autowired
	BankBookService service;
	
	@RequestMapping(value = "list.ms", method = RequestMethod.GET)
	public void list(HttpServletRequest request) {
		System.out.println("list Controller");
		
		request.setAttribute("bankBookList", service.getList());
	}
	
	@RequestMapping(value = "detail.ms", method = RequestMethod.GET)
	public void detail(HttpServletRequest request,BankBookDTO dto) {
		System.out.println("detail Controller");
		System.out.println(dto.getBookNum());
		BankBookDTO dtobb = service.getDetail(dto);
		request.setAttribute("bankBook", dtobb);
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
	public void update() {
		System.out.println("상풍 update 페이지");
	}
	
	@RequestMapping(value = "update.ms", method = RequestMethod.POST)
	public String update(BankBookDTO dto) {
		System.out.println("상품 db update");
		
		service.update(dto);
		return "redirect:./list.ms";
	}
	
	
	
}
