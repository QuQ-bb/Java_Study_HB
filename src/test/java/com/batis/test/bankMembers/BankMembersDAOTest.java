package com.batis.test.bankMembers;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.batis.test.MyAbstracttest;


public class BankMembersDAOTest extends MyAbstracttest {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;

	@Test
//	public void mypageTest()throws Exception {
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		bankMembersDTO.setUserName("ID1");
//		bankMembersDTO = bankMembersDAO.mypage(bankMembersDTO);
//		System.out.println(bankMembersDTO.getEmail());
//	}
	
	public void idCheckTest()throws Exception{
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName("ID1");
		Long result = bankMembersDAO.getIdCheck(bankMembersDTO);
	}

}
