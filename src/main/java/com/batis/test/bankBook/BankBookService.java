package com.batis.test.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankBookService {

	@Autowired
	private BankBookDAO dao;
	
	public int addBankBook(BankBookDTO dto) {
		return dao.addBankBook(dto);
	}
	
	public List<BankBookDTO> getList() {
		return dao.getList();
	}
	
	public BankBookDTO getDetail(BankBookDTO dto) {
		return dao.getDetail(dto);
	}
	
	public int update(BankBookDTO dto) {
		return dao.update(dto);
	}
}
