package com.batis.test.bankMembers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batis.test.bankAccount.BankAccountDAO;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
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
	public BankMembersDTO mypage(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.mypage(bankMembersDTO);
	}
//	public Map<String, Object> mypage(BankMembersDTO bankMembersDTO)throws Exception{
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		List<BankAccountDTO> al = bankAccountDAO.myAccount(bankMembersDTO);
//		bankMembersDTO = bankMembersDAO.mypage(bankMembersDTO);
//		map.put("list",al);
//		map.put("dto", bankMembersDTO);
//		
//		return	map; 
//	}
}
