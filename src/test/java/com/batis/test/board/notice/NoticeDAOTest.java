package com.batis.test.board.notice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.batis.test.MyAbstracttest;

public class NoticeDAOTest extends MyAbstracttest {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
//	public void listTest()throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		List<BoardDTO> al =noticeDAO.getList();
//		assertNotEquals(0, al);
//	}
	
	public void countTest()throws Exception{
		long result = noticeDAO.getCount();
		
		assertEquals(102L, result);
	}
//	public void detailTest()throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setNum(2L);
//		 boardDTO = noticeDAO.getDetail(boardDTO);
//	}
	
//	public void addTest()throws Exception{
//		
//		for(int i=0; i<100; i++) {
//			BoardDTO boardDTO = new BoardDTO();
//			boardDTO.setTitle("제목test"+i);
//			boardDTO.setContents("내용test"+i);
//			boardDTO.setWriter("작성자test"+i);
//			int result = noticeDAO.setAdd(boardDTO);
//			
//			if(i%10==0) {
//				Thread.sleep(500);
//			}
//		}
//		System.out.println("Finish");
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
