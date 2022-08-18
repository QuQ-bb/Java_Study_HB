package com.batis.test.bankMembers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	//회원가입
	public int join(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.join(bankMembersDTO);
	}
	//로그인
	public BankMembersDTO login(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.login(bankMembersDTO);
	}
	public List<BankMembersDTO> searchID(String search)throws Exception{
		return bankMembersDAO.searchID(search);
	}
}
