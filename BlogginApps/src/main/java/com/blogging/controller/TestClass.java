package com.blogging.controller;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.dom4j.tree.BackedList;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.web.client.RestTemplate;



public class TestClass {
	public static void main(String args[])
	{
		
	
		//RestTemplate re=new RestTemplate();
		//String forObject = re.getForObject("http://newsapi.org/v2/everything?q=bitcoin&from=2020-02-28&sortBy=publishedAt&apiKey=a1fd3224aa5f4293a59960abf3fa539c",String.class);
		
		// URL url = new URL("http://newsapi.org/v2/everything?q=bitcoin&from=2020-02-28&sortBy=publishedAt&apiKey=a1fd3224aa5f4293a59960abf3fa539c",String.class);
	     
		/* DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));  */
		boolean checkPass = checkPass("sonu","$2a$10$je0c2S8/4ZoCy0UHhJljWOKFy896IHL29GjK92yV35D7wnlt03mTO");
		//$2a$10$MFL7dYfg5C7wJaLRfIXLVeTMvWCtr1oOOZC03uLxvPo01Zok2qV8.
		
		//$2a$10$vEmO7okHtXr5TjEE/jplsucdjcjTViTezTkMAoJ8MQR/KT0xctxuO
		System.out.println(checkPass);
		String s=BCrypt.hashpw("sonu",BCrypt.gensalt());
	       System.out.println(s);
	
		
	}
	
	public static String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	public static  boolean checkPass(String plainPassword, String hashedPassword) {
		if (BCrypt.checkpw(plainPassword, hashedPassword))
		{
			
			System.out.println("matched");
			return true;
		}
		else
			return false;
	}

}
