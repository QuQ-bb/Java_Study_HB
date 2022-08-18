package com.batis.test.bankBook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankBookDAO {
	
	@Autowired
	private SqlSession session;
	private final String NAMESPACE="com.batis.test.bankBook.BankBookDAO.";
	
	public int addBankBook(BankBookDTO dto) {
		return session.insert(NAMESPACE+"addBankBook", dto);
	}
	
	public List<BankBookDTO> getList() {
		return session.selectList(NAMESPACE+"getList");
	}
	
	public BankBookDTO getDetail(BankBookDTO dto) {
		return session.selectOne(NAMESPACE+"getDetail", dto);
	}
	
	public int update(BankBookDTO dto) {
		return session.update(NAMESPACE+"update", dto);
	}
	
	public int delete(BankBookDTO dto) {
		return session.delete(NAMESPACE+"delete", dto);
	}
	

}
