package com.batis.test.board.impl;

import java.util.List;

public class BoardDTO extends CommentDTO{

	private String title;
	private Long hit;
	
	//글하나에 boardFile을 여러개 갖고있다 1:N
 	private List<BoardFileDTO> boardFileDTOs;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getHit() {
		return hit;
	}

	public void setHit(Long hit) {
		this.hit = hit;
	}

	public List<BoardFileDTO> getBoardFileDTOs() {
		return boardFileDTOs;
	}

	public void setBoardFileDTOs(List<BoardFileDTO> boardFileDTOs) {
		this.boardFileDTOs = boardFileDTOs;
	}
	
	
}
