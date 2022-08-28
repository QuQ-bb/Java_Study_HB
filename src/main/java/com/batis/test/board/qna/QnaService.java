package com.batis.test.board.qna;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.batis.test.board.impl.BoardDTO;
import com.batis.test.board.impl.BoardFileDTO;
import com.batis.test.board.impl.BoardService;
import com.batis.test.util.Pager;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private ServletContext servletContext;

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
	public int setAdd(BoardDTO boardDTO,MultipartFile [] files) throws Exception {
		int result = qnaDAO.setAdd(boardDTO);
		
		String realPath = servletContext.getRealPath("resources/upload/qna");
		System.out.println(realPath);
		
		for(MultipartFile qnaFile: files) {
//			저장할 폴더의 정보를 가지는 자바 객체 생성
			File file = new File(realPath);
			
			if(qnaFile.isEmpty()) {
				continue;
			}//if문 end
			if(!file.exists()) {
				file.mkdirs();
			}//if문 end
			String fileName = UUID.randomUUID().toString();
			
			fileName = fileName+"_"+qnaFile.getOriginalFilename();
			file = new File(file, fileName);
			qnaFile.transferTo(file);
			
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(qnaFile.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			
			qnaDAO.setAddFile(boardFileDTO);
		}//for문 end
		
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
