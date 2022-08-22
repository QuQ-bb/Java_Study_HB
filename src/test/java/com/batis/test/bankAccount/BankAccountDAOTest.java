package com.batis.test.bankAccount;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.batis.test.MyAbstracttest;
import com.batis.test.bankMembers.BankMembersDTO;

public class BankAccountDAOTest extends MyAbstracttest{
	
	@Autowired
	private BankAccountDAO bankAccountDAO;

	@Test
	public void accounttest()throws Exception {
		BankAccountDTO bankAccountDTO = new BankAccountDTO();
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName("ID1");
			List<BankAccountDTO> al = bankAccountDAO.myAccount(bankMembersDTO);
			assertNotEquals(0, al.size());
	}

}
