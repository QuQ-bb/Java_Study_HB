package com.batis.test.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.batis.test.MyAbstracttest;

public class FileManagerTest extends MyAbstracttest{

	@Autowired
	private FileManager fileManager;
	
	
//	@Test
//	public void setFileTest()throws Exception {
//		fileManager.saveFile("resources/upload/test");
//		System.out.println("Finish");
//	}

}
