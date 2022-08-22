package com.batis.test.bankAccount;

import java.sql.Date;

import com.batis.test.bankBook.BankBookDTO;

public class BankAccountDTO {
	private Long AccountNum;
	private String UserName;
	private Long BookNum;
	private Date AccountDate;
	
	// 1 : 1의 관계일 때
	private BankBookDTO bankBookDTO;
	
	
	public Long getAccountNum() {
		return AccountNum;
	}
	public void setAccountNum(Long accountNum) {
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
	
	public BankBookDTO getBankBookDTO() {
		return bankBookDTO;
	}
	public void setBankBookDTO(BankBookDTO bankBookDTO) {
		this.bankBookDTO = bankBookDTO;
	}
	
	

}
