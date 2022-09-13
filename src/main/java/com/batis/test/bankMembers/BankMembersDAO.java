package com.batis.test.bankMembers;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankMembersDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.batis.test.bankMembers.BankMembersDAO.";
	
	//id중복 check
	public Long getIdCheck(BankMembersDTO bankMembersDTO)throws Exception{
		System.out.println("안녕하세요 중복체크 dao입니다.");
		return sqlSession.selectOne(NAMESPACE+"getIdCheck",bankMembersDTO);
	}
	
	//회원가입 이미지 추가
	public int setAddFile(BankMembersFileDTO bankMembersFileDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setAddFile",bankMembersFileDTO);
	}
	
	//회원가입
	public int join(BankMembersDTO bankMembersDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"join",bankMembersDTO);
	}
	//로그인
	public BankMembersDTO login(BankMembersDTO bankMembersDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"login",bankMembersDTO);
	}
	//ID찾기
	public List<BankMembersDTO> searchID(String search)throws Exception{
		return sqlSession.selectList(NAMESPACE+"searchID", search);
	}
	//mypage
	public BankMembersDTO mypage(BankMembersDTO bankMembersDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"mypage",bankMembersDTO);
	}
}
