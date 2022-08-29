package com.batis.test.board.impl;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.web.multipart.MultipartFile;

import com.batis.test.util.Pager;

public interface BoardService {
	
	//글 목록
	public List<BoardDTO> getList(Pager pager)throws Exception;
	//글조회
	public BoardDTO getDetail(BoardDTO boardDTO)throws Exception;
	//글 쓰기
	public int setAdd(BoardDTO boardDTO,ServletContext servletContext,MultipartFile [] files)throws Exception;
	//글쓰기 사진추가
//	public int setAddFile(BoardFileDTO boardFileDTO)throws Exception;
	//글 수정
	public int setUpdate(BoardDTO boardDTO)throws Exception;
	//글 삭제
	public int setDelete(BoardDTO boardDTO)throws Exception;
}
