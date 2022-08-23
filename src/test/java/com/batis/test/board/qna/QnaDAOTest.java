package com.batis.test.board.qna;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.batis.test.MyAbstracttest;
import com.batis.test.board.impl.BoardDTO;

public class QnaDAOTest extends MyAbstracttest{

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
//	public void listTest()throws Exception{
//		List<BoardDTO> al = qnaDAO.getList();
//	}
	
//	public void detailTest()throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setNum(1L);
//	     boardDTO = qnaDAO.getDetail(boardDTO);
//	     assertNull(boardDTO);
//	}
//	public void addTest()throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setTitle("보내져test");
//		boardDTO.setContents("벌써배가고프냐?test");
//		boardDTO.setWriter("나test");
//		int result = qnaDAO.setAdd(boardDTO);
//		assertNotEquals(0, result);
//	}
//	public void updateTest()throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setTitle("먀");
//		boardDTO.setContents("릴라공주");
//		boardDTO.setNum(141L);
//		int result =  qnaDAO.setUpdate(boardDTO);
//		assertNotEquals(0, result);
//	}
	public void deleteTest()throws Exception{
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(12L);
		int resulut =qnaDAO.setDelete(boardDTO);
		assertNotEquals(1, resulut);
	}

}
