package com.batis.test.board.impl;

import java.util.List;

import com.batis.test.util.Pager;

public interface BoardDAO {
	
	//글목록
	public List<BoardDTO> getList(Pager pager)throws Exception;
	//글 총 갯수
	public Long getCount(Pager pager)throws Exception;
	//글 상세보기
	public BoardDTO getDetail(BoardDTO boardDTO)throws Exception;
	//글 쓰기
	public int setAdd(BoardDTO boardDTO)throws Exception;
	//사진추가
	public int setAddFile(BoardFileDTO boardFileDTO)throws Exception;
	//글 수정
	public int setUpdate(BoardDTO boardDTO)throws Exception;
	//글 삭제
	public int setDelete(BoardDTO boardDTO)throws Exception;
}
