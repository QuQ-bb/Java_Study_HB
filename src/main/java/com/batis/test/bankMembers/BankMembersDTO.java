package com.batis.test.bankMembers;

import java.util.List;

import com.batis.test.bankAccount.BankAccountDTO;

public class BankMembersDTO {
	
	private String userName;
	private String password;
	private String name;
	private String email;
	private String phone;
	
	// 1 : N의 관계일 때 회원이 여러개의 계좌를 개발할수 있기때문에 LIST
	private List<BankAccountDTO> bankAccountDTOs;
	//파일
	private BankMembersFileDTO bankMembersFileDTO;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public List<BankAccountDTO> getBankAccountDTOs() {
		return bankAccountDTOs;
	}
	public void setBankAccountDTOs(List<BankAccountDTO> bankAccountDTOs) {
		this.bankAccountDTOs = bankAccountDTOs;
	}
	public BankMembersFileDTO getBankMembersFileDTO() {
		return bankMembersFileDTO;
	}
	public void setBankMembersFileDTO(BankMembersFileDTO bankMembersFileDTO) {
		this.bankMembersFileDTO = bankMembersFileDTO;
	}
	

}
