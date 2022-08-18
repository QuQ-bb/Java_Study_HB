package com.batis.test.bankAccount;

import java.sql.Date;

public class BankAccountDTO {
	private Integer AccountNum;
	private String UserName;
	private Long BookNum;
	private Date AccountDate;
	
	
	public Integer getAccountNum() {
		return AccountNum;
	}
	public void setAccountNum(Integer accountNum) {
		AccountNum = accountNum;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public Long getBookNum() {
		return BookNum;
	}
	public void setBookNum(Long bookNum) {
		BookNum = bookNum;
	}
	public Date getAccountDate() {
		return AccountDate;
	}
	public void setAccountDate(Date accountDate) {
		AccountDate = accountDate;
	}
	
	

}
