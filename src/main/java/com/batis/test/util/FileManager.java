package com.batis.test.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
//	@Autowired
//	private ServletContext servletContext; 
	//FileManager를 사용하고자 하면 servletContext를
	//1.autowired해서 객체주입하던지
	//2.매개변수로 불러오기
	
	
	//save
	public String saveFile(String path,ServletContext servletContext,MultipartFile multipartFile)throws Exception{
		String realPath = servletContext.getRealPath(path);
		// 클래스마다 첨부파일을 저장하는경로가 다르기때문에 매개변수로 path로 받아온다
		System.out.println(realPath);
		
		//2. 폴더(directory)체크
		File file = new File(realPath);
		if(file.exists()) {
			file.mkdirs();
		}
		
		//3.저장할 파일명 생성
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		file = new File(file, fileName);
		multipartFile.transferTo(file);
		
		
		return fileName;
	}

}
