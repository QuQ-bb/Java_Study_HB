package com.batis.test.bankAccount;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.batis.test.bankMembers.BankMembersDTO;

@Repository
public class BankAccountDAO {
	
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.batis.test.bankAccount.BankAccountDAO.";
	
	public int addAccount(BankAccountDTO dto) {
		return session.insert(NAMESPACE+"add", dto);
	}
	
	public List<BankAccountDTO> myAccount(BankMembersDTO bankMembersDTO)throws Exception{
		return session.selectList(NAMESPACE+"myAccount",bankMembersDTO);
	}

}
