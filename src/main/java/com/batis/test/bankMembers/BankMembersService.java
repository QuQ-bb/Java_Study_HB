package com.batis.test.bankMembers;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	@Autowired
	private ServletContext servletContext;
	
//	@Autowired
//	private BankAccountDAO bankAccountDAO;
	
	//회원가입
	public int join(BankMembersDTO bankMembersDTO,MultipartFile photo)throws Exception{
		int result = bankMembersDAO.join(bankMembersDTO);
//		1.HDD에 파일을 저장
//		 파일 저장시에 경로는 tomcat기준이 아니라 OS의 기준으로 설정
//		1) 파일저장 위치
//			webapp/resources/upload/member
//		내장객체 page,request,session,application 중 application을 통함
		
//		2) 저장할 폴더의 실제경로 반환(OS 기준)
		String realPath = servletContext.getRealPath("resources/upload/member");
		System.out.println("realPath == "+realPath);
		
//		
//		3) 저장할 폴더의 정보를 가지는 자바 객체 생성
		File file = new File(realPath);
		//System.out.println(file.isDirectory());	//false why? 파일이 없기떄문
//		System.out.println(file.exists());
		
		//File 첨부가 없을 때 구분
//		if(photo.getSize() != 0) {}
		
		if(!photo.isEmpty()) {
		
		if(!file.exists()) {
			file.mkdirs();//파일만들기
		}
		
		//4) 중복되지 않는 파일명 생성
		// --시간 이용,java api...
		
		//java api
//		Universial Unique ID
		String fileName= UUID.randomUUID().toString();
		System.out.println(fileName);
		
		//시간 이용
		Calendar ca = Calendar.getInstance();
		Long time = ca.getTimeInMillis();
		
		fileName =fileName+"_"+photo.getOriginalFilename();
		System.out.println("확장자 붙은 파일 명 == "+fileName);
		
		//). HDD에 파일저장
		//어느 폴더에 어떤 이름을 저장할 File 객체 생성
		file = new File(file,fileName);
//			1)MultipartFile 클래스의 transferTo 메서드 사용
			photo.transferTo(file);
//			2)FileCopyUtils 클래스의 copy 메서드 사용
			
		//2. 저장된 파일정보를 DB에 저장
		
		BankMembersFileDTO bankMembersFileDTO = new BankMembersFileDTO();
		bankMembersFileDTO.setFileName(fileName);
		bankMembersFileDTO.setOriName(photo.getOriginalFilename());
		bankMembersFileDTO.setUserName(bankMembersDTO.getUserName());
		bankMembersDAO.setAddFile(bankMembersFileDTO);
		
		
		}//isEmpty end	
		
		return result;
	}
	//로그인
	public BankMembersDTO login(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.login(bankMembersDTO);
	}
	public List<BankMembersDTO> searchID(String search)throws Exception{
		return bankMembersDAO.searchID(search);
	}
	public BankMembersDTO mypage(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.mypage(bankMembersDTO);
	}
//	public Map<String, Object> mypage(BankMembersDTO bankMembersDTO)throws Exception{
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		List<BankAccountDTO> al = bankAccountDAO.myAccount(bankMembersDTO);
//		bankMembersDTO = bankMembersDAO.mypage(bankMembersDTO);
//		map.put("list",al);
//		map.put("dto", bankMembersDTO);
//		
//		return	map; 
//	}
}
