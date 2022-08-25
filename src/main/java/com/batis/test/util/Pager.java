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
	
	
	private boolean pre;		//이전 블럭의 유무 : 이전불륵이 있으면 true, 없으면 false
	private boolean next;		//다음 블럭의 유무 : 다음블럭이 있으면 true, 없으면 false
	
	//검색 컬럼의 종류
	private String kind;
	//검색어
	private String search;
	
	
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
		Long totalPage = (totalCount-1)/this.getPerPage()+1;
		System.out.println("getPage"+this.getPerPage());
		System.out.println("토탈 페이지"+totalPage);
//		2-1 totalPage보다 pager가 더 클 경우
		if(this.getPage() > totalPage) {
			this.setPage(totalPage);
		}
//		3. totalPage로 totalBlock 구하기
		Long totalBlock = (totalPage-1)/this.getPerBlock()+1;

		System.out.println("토탈 블럭"+totalBlock);
	//	4. page로 curBlock찾기
		Long curBlock = this.getPage()/this.getPerBlock();
		if(this.getPage()%this.getPerBlock() != 0) {
			curBlock++;
		}
		System.out.println("현재블럭"+curBlock);
		//5.curBlock으로 startNum ,lastNum 구하기
		this.startNum = (curBlock -1)*this.getPerBlock()+1;
		this.lastNum = curBlock*this.getPerBlock();
		
		//6. curBlock이 마지막 Block(totalBlock과 같을 때)
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
			System.out.println("현재블럭"+curBlock);
			System.out.println("마지막 블럭"+totalBlock);
			System.out.println("되라 넘새끼"+this.lastNum);
			System.out.println("전체 수"+totalPage);
		}
		
		//7. 이전,다음블럭의 유무
		if(curBlock >1) {
			pre =true;
		}
		if(curBlock < totalBlock) {
			next = true;
		}
	}//getNum
	
	
	public Long getPage() {
		if(this.page ==null || this.page <= 0) {
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

	public boolean isPre() {	//is로 return되는것은 boolean 맞냐 안맞냐 체크해주는것
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}
