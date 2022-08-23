package com.batis.test.bankAccount;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.batis.test.bankMembers.BankMembersDTO;


@Controller
@RequestMapping(value="/account/*")
public class BankAccountController {
	
	@Autowired
	private BankAccountService service;

	@RequestMapping(value="add.ms" , method = RequestMethod.GET)
	public String addAccount(BankAccountDTO dto, HttpSession session) throws Exception{
		System.out.println("통장 가입 실행");
		
		
		BankMembersDTO member = (BankMembersDTO)session.getAttribute("member");
		dto.setUserName(member.getUserName());
		
		int chk = service.addAccount(dto);
		if(chk==1) {
			System.out.println("가입 완료");
		}else {
			System.out.println("가입 실패");
		}
		
		return "redirect:../bankbook/list.ms";
	}
}
