package com.batis.test.board.impl;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.batis.test.file.FileDTO;

public class BoardFileDTO extends FileDTO{
	@Autowired
	private ServletContext servletContext;
	
	private Long num;

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}
}
