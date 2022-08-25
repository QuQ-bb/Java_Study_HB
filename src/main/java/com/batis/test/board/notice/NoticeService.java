package com.batis.test.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batis.test.board.impl.BoardDTO;
import com.batis.test.board.impl.BoardService;
import com.batis.test.util.Pager;
@Service
public class NoticeService implements BoardService{
	
	@Autowired
	private NoticeDAO noticeDAO;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		//총 글 갯수
		Long totalCount = noticeDAO.getCount(pager);
		
		pager.getNum(totalCount);
		pager.getRowNum();
		
		
//		Long perPage = 10L;
//		//page		startrow		 lastrow
//		// 1			1				10
//		// 2			11				20
//		// 3			21				30
//		Long startRow = (pager.getPage()-1)*perPage+1;
//		Long lastRow = pager.getPage()*perPage;
//		
//		Map<String, Long> map = new HashMap<String, Long>();
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
//		
//		===============================================================
//		JSP 페이지 번호 출력 1 - ??
//		1. 글의 총 갯수
//		2. 글의 총 갯수를 이용해서 총 페이지 수 구하기
//		Long totalCount = noticeDAO.getCount();
//		Long totalPage = ((totalCount-1)/perPage)+1;
//		
//		Long totalPage = totalCount/perPage;
//		if(totalCount%perPage != 0) {
//			totalPage = totalPage+1;
//			totalPage++;
//		}
//		
//		
//		3. Block : 한 페이지에 있는 버튼을 1Block이라고 하자
//		perBlock : 한 페이지에 출력할 번호의 수
//		Long perBlock =5L;
//		Long totalBlock = (totalPage-1)/perBlock+1;
//		Long totalBlock = totalPage/perBlock;
//		if(totalPage%perBlock != 0) {
//			totalBlock++;
//		}
//		
//		4. page로 현재 Block 번호 찾기
//		page 	curBlock
//		 1			1
//		 2			1
//		 5			1
//		 6			2
//		 ..			..
//		 11			3
//		
//		Long curBlock = ((page-1)/perBlock)+1;
//		
//		Long curBlock = (page/perBlock);
//		if(page%perBlock != 0) {
//			curBlock++;
//		}
//		
//		5. curBlock로 시작번호와 끝번호 알아오기
//		curBlock	startNum	lastNum
//			1			1			5
//			2			6			10
//			3			11			15
//		Long startNum = ((curBlock-1)*perBlock)+1;
//		Long lastNum =curBlock*perBlock;
//		
//		
//		System.out.println("StartRow== "+startRow);
//		System.out.println("lastRow== "+lastRow);
//		System.out.println("totalCount == "+totalCount);
//		System.out.println("totalPage == "+totalPage);
				
		return noticeDAO.getList(pager);
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
