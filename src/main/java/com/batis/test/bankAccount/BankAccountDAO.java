package com.batis.test.bankAccount;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankAccountDAO {
	
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.batis.test.bankAccount.";
	
	public int addAccount(BankAccountDTO dto) {
		return session.insert(NAMESPACE+"add", dto);
	}

}
