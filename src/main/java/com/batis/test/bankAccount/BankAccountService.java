package com.batis.test.bankAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {

	@Autowired
	private BankAccountDAO dao;
	
	public int addAccount(BankAccountDTO dto) throws Exception{
		return dao.addAccount(dto);
	}
}
