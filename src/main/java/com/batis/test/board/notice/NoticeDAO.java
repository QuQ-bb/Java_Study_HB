package com.batis.test.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.batis.test.board.impl.BoardDAO;
import com.batis.test.board.impl.BoardDTO;
import com.batis.test.board.impl.BoardFileDTO;
import com.batis.test.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE ="com.batis.test.board.NoticeDAO.";

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}
	@Override
	public Long getCount(Pager pager)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getCount",pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getDetail",boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAdd",boardDTO);
	}
	public int setAddFile(BoardFileDTO boardFileDTO)throws Exception{
		System.out.println("파일 DAO");
		return sqlSession.insert(NAMESPACE+"setAddFile",boardFileDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate",boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete",boardDTO);
	}
	
	
	
}
