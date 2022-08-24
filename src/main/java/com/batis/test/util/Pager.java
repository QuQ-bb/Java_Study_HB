package com.batis.test.util;

public class Pager {
	
	//멤버변수 선언
	//파라미터를 담을 변수
	//JSP에서 꺼내서 사용할 변수
	//mapper에서 꺼내서 사용할 변수
	private Long page;			//파라미터가 담길 변수
	private Long startNum;		//jsp에서 꺼내서 사용할 변수
	private Long lastNum;
	private Long startRow;		//
	private Long lastRow;
	private Long perPage;		//한 페이지에 출력한 글의 갯수
	private Long perBlock;		//한 페이지에 출력할 번호의 갯수
	
	
	public Pager() {
		this.perPage =10L;
		this.perBlock =5L;
	}
	
//	1.mapper에서 사용할 값 계산
	public void getRowNum()throws Exception{
		this.startRow = (this.getPage()-1)*getPerPage()+1;
		this.lastRow = this.getPage()*getPerPage();
	}
//	2. jsp에서 사용 할 값 게산
	public void getNum(Long totalCount)throws Exception{
		//2. totalCount로 totalPage구하기 ex)100
		Long totalPage = totalCount/this.getPage();
		if(totalCount%this.getPerPage() !=0) {
			totalPage++;
		}
//		3. totalPage로 totalBlock 구하기
	Long totalBlock = totalPage/this.getPerBlock();
	if(totalPage%this.getPerBlock() != 0) {
		totalBlock++;
	}
	
//	4. page로 curBlock찾기
	Long curBlock = this.getPage()/this.getPerBlock();
	if(this.getPage()%this.getPerBlock() != 0) {
		curBlock++;
	}
	//5.curBlock으로 startNum ,lastNum 구하기
	this.startNum = (curBlock -1)*this.getPerBlock()+1;
	this.lastNum = curBlock*this.getPerBlock();
	
	
	}
	
	public Long getPage() {
		if(this.page ==null) {
			this.page = 1L;
		}
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
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
	public Long getPerPage() {
		if(this.perPage == null) {
			this.perPage = 10L;
		}
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getPerBlock() {
		return perBlock;
	}
	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}

}
