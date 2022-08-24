package com.batis.test.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batis.test.board.impl.BoardDTO;
import com.batis.test.board.impl.BoardService;
@Service
public class NoticeService implements BoardService{
	
	@Autowired
	private NoticeDAO noticeDAO;

	@Override
	public List<BoardDTO> getList(Long page) throws Exception {
		System.out.println("page== "+page);
		
		Long perPage = 10L;
		//page		startrow		 lastrow
		// 1			1				10
		// 2			11				20
		// 3			21				30
		Long startRow = (page-1)*perPage+1;
		Long lastRow = page*perPage;
		
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("startRow", startRow);
		map.put("lastRow", lastRow);
		
//		===============================================================
		
		
		System.out.println("StartRow== "+startRow);
		System.out.println("lastRow== "+lastRow);
				
		return noticeDAO.getList(map);
	}
	

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setAdd(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setDelete(boardDTO);
	}

}
