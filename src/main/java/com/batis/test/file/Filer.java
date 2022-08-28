package com.batis.test.file;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.batis.test.board.impl.BoardFileDTO;

@Component
public class Filer {
	@Autowired
	private ServletContext servletContext;
	
	public int setAddFile(MultipartFile[] files)throws Exception{
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
//			boardFileDTO.setNum(boardDTO.getNum());
			
//			int result =.setAddFile(boardFileDTO);
		}//for문 end 
		
		return 0;
	}

}
