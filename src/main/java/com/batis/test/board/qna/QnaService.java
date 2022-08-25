package com.batis.test.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batis.test.board.impl.BoardDTO;
import com.batis.test.board.impl.BoardService;
import com.batis.test.util.Pager;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;

	public int setReply(QnaDTO qnaDTO)throws Exception{
		 BoardDTO boardDTO =qnaDAO.getDetail(qnaDTO);
		 QnaDTO parent = (QnaDTO)boardDTO;
		 
		 qnaDTO.setRef(parent.getRef());
		 qnaDTO.setStep(parent.getStep()+1);
		 qnaDTO.setDepth(parent.getDepth()+1);
		 
		 qnaDAO.setStepUpdate(parent);	//수정해주기 위해서 부모의 정보를 보내줌
		 int result = qnaDAO.setReplyAdd(qnaDTO);
		
		return result;
	}
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		System.out.println("qna service1");
		Long totalCount = qnaDAO.getCount(pager);
		System.out.println("토탈 카운트"+totalCount);
		System.out.println("qna service2");
		pager.getNum(totalCount);
		System.out.println("qna service3");
		pager.getRowNum();
		
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		System.out.println();
		System.out.println("Insert 전: "+boardDTO.getNum());
		int result = qnaDAO.setAdd(boardDTO);
		System.out.println("Insert 후: "+boardDTO.getNum());
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setDelete(boardDTO);
	}

}
