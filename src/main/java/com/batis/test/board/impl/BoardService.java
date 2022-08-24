package com.batis.test.board.impl;

import java.util.List;

public interface BoardService {
	
	//글 목록
	public List<BoardDTO> getList(Long page)throws Exception;
	//글조회
	public BoardDTO getDetail(BoardDTO boardDTO)throws Exception;
	//글 쓰기
	public int setAdd(BoardDTO boardDTO)throws Exception;
	//글 수정
	public int setUpdate(BoardDTO boardDTO)throws Exception;
	//글 삭제
	public int setDelete(BoardDTO boardDTO)throws Exception;
}
