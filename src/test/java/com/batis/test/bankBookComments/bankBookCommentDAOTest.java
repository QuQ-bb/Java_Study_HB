package com.batis.test.bankBookComments;

import org.springframework.beans.factory.annotation.Autowired;

import com.batis.test.MyAbstracttest;
import com.batis.test.bankBook.BankBookCommentDAO;

public class bankBookCommentDAOTest extends MyAbstracttest{
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;

//	@Test
	public void getCommentListtest()throws Exception {
//		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
//		bankBookCommentDTO.setBookNum(1659511239298L);
//		bankBookCommentDTO.setWriter("지각아님");
//		bankBookCommentDTO.setContents("와라라라랄");
//		
//		int result = bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
//		System.out.println(result);
//		assertEquals(1, result);
		
//		CommentPager commentPager = new CommentPager();
//		commentPager.setBookNum(2L);
//		commentPager.setPage(1L);
//		commentPager.getRowNum();
//		List<BankBookCommentDTO> al = bankBookCommentDAO.getCommentList(commentPager);
//		assertNotEquals(0, al.size());
	}

}
