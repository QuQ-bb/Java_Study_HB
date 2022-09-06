package com.batis.test.bankBookComments;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.batis.test.bankBook.BankBookCommentDAO;
import com.batis.test.bankBook.BankBookCommentDTO;

public class bankBookCommentDAOTest {
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;

	@Test
	public void commenttest()throws Exception {
		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
		bankBookCommentDTO.setBookNum(5L);
		bankBookCommentDTO.setWriter("지각아님");
		bankBookCommentDTO.setContents("와라라라랄");
		
		int result = bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
		assertEquals(1, result);
	}

}
