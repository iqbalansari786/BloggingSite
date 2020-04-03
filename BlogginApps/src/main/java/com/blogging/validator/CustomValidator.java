package com.blogging.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.blogging.modal.NewPost;

public class CustomValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return NewPost.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors error) {
		
		NewPost newPost=(NewPost)target;
		if(newPost.getFile() == null || 
				newPost.getFile().getOriginalFilename().equals("")) {
			error.rejectValue("file", null, "plz select image file to upload !");
			return;
		}
		if(! (newPost.getFile().getContentType().equals("image/gif"))||
				(newPost.getFile().getContentType().equals("image/jpeg"))
				
				||
				(newPost.getFile().getContentType().equals("image/png")))
		{
			error.rejectValue("file", null, "plz select only proper image format !");
			return;
			
			
		}
	
		
	}

}
