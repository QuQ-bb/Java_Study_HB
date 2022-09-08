package com.batis.test.board.impl;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommentDTO {

	private Long num;
	private String writer;
	private String contents;
	@JsonFormat(pattern ="yyyy-MM-dd")
	private Date regdate;
	
	
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}
