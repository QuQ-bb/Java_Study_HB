package com.batis.test.board.notice;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.batis.test.MyAbstracttest;
import com.batis.test.board.impl.BoardDTO;

public class NoticeDAOTest extends MyAbstracttest {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void listTest()throws Exception{
		BoardDTO boardDTO = new BoardDTO();
		List<BoardDTO> al =noticeDAO.getList();
		assertNotEquals(0, al);
	}
//	public void detailTest()throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setNum(2L);
//		 boardDTO = noticeDAO.getDetail(boardDTO);
//	}
	
//	public void addTest()throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setTitle("제목test");
//		boardDTO.setContents("내용test");
//		boardDTO.setWriter("작성자test");
//		int result = noticeDAO.setAdd(boardDTO);
//		System.out.println(result);
//	}
	
//	public void updateTest()throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setTitle("제목수정");
//		boardDTO.setContents("내용수정");
//		boardDTO.setNum(1L);
//		int result = noticeDAO.setUpdate(boardDTO);
//		System.out.println(result);
//	}
//	
//	public void deleteTest()throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setNum(2L);
//		noticeDAO.setDelete(boardDTO);
//	}

}
