package com.batis.test.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batis.test.util.CommentPager;

@Service
public class BankBookService {
	//-------------------------------------------------------
	//	Comment
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		return bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
	}
	
	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager)throws Exception{
		//댓글 총 갯수
		commentPager.getRowNum();
		Long totalCount = bankBookCommentDAO.getCommentListTotalCount(commentPager);
		commentPager.makePage(totalCount);
		return bankBookCommentDAO.getCommentList(commentPager);
	}
	
	public int setCommentDelete(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		return bankBookCommentDAO.setCommentDelete(bankBookCommentDTO);
	}
	
	public int setCommentUpdate(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		return bankBookCommentDAO.setCommentUpdate(bankBookCommentDTO);
	}
	//--------------------------------------------------------------
	
	@Autowired
	private BankBookDAO dao;
	
	public int addBankBook(BankBookDTO dto){
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
	
	public int delete(BankBookDTO dto) {
		return dao.delete(dto);
	}

	
}
