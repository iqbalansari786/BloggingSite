package com.blogging.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	
	private static final String ABS_PATH="C:\\Users\\Sonu\\Desktop\\bloggingApp\\BloggingApplication\\BloggingApplication\\blogging\\src\\main\\webapp\\assests\\images\\";
	private static  String REAL_PATH="";
	public static void saveFile(HttpServletRequest req, MultipartFile file, String imageCode) {
		REAL_PATH=req.getSession().getServletContext().getRealPath("/assests/images/");
		
		if(!new File(ABS_PATH).exists())
		{
			new File(ABS_PATH).mkdir();
			System.out.println("absolute path"+ABS_PATH);
		}
		if(!new File(REAL_PATH).exists())
		{
			new File(REAL_PATH).mkdir();
			System.out.println("absolute path"+REAL_PATH);
		}
		
		try
		{
			file.transferTo(new File(ABS_PATH +imageCode+ ".jpg"));
			file.transferTo(new File(REAL_PATH +imageCode+ ".jpg"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
