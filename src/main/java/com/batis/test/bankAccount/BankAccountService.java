package com.batis.test.bankAccount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batis.test.bankMembers.BankMembersDTO;

@Service
public class BankAccountService {

	@Autowired
	private BankAccountDAO dao;
	
	public int addAccount(BankAccountDTO dto) throws Exception{
		return dao.addAccount(dto);
	}
	public List<BankAccountDTO> myAccount(BankMembersDTO bankMembersDTO)throws Exception{
		return dao.myAccount(bankMembersDTO);
	}
}
