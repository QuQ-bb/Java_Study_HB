package com.batis.test.board.impl;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.batis.test.file.FileDTO;

public class BoardFileDTO extends FileDTO{
	@Autowired
	private ServletContext servletContext;
	
	private Long num;

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}
	
//	public void setAddFile(BoardDTO boardDTO,MultipartFile[] files)throws Exception{
//		String realPath = servletContext.getRealPath("resources/upload/qna");
//		System.out.println(realPath);
//		
//		for(MultipartFile qnaFile: files) {
////			저장할 폴더의 정보를 가지는 자바 객체 생성
//			File file = new File(realPath);
//			
//			if(qnaFile.isEmpty()) {
//				continue;
//			}//if문 end
//			if(!file.exists()) {
//				file.mkdirs();
//			}//if문 end
//			String fileName = UUID.randomUUID().toString();
//			
//			fileName = fileName+"_"+qnaFile.getOriginalFilename();
//			file = new File(file, fileName);
//			qnaFile.transferTo(file);
//			
//			BoardFileDTO boardFileDTO = new BoardFileDTO();
//			boardFileDTO.setFileName(fileName);
//			boardFileDTO.setOriName(qnaFile.getOriginalFilename());
//			boardFileDTO.setNum(boardDTO.getNum());
//			
//		}//for문 end
//	}
}
