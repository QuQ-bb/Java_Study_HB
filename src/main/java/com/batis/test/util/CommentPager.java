package com.batis.test.util;

public class CommentPager {
	
	//Mapper에서 사용
	private Long startRow;
	private Long lastRow;
	private Long bookNum;
	
	private Long page;
	private Long perPage;
	
	//startRow
	public void getRowNum()throws Exception{
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPage()*this.getPerPage();		
	}
	
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}


	public Long getPage() {
		if(this.page==null || this.page <1) {
			this.page=1L;
		}
		return page;
	}


	public void setPage(Long page) {
		this.page = page;
	}

	//생성자에 넣어줘도 되고 GETTER를 이용해서 기본값 넣어주기
	public Long getPerPage() {
		if(this.perPage==null || this.perPage<1) {
			this.perPage= 5L;
		}
		return perPage;
	}


	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

}
