package com.blogging.modal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.UUID;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class NewPost {

	  
	@Id
	
	private String imageCode;
	
	private String category;
	@NotBlank(message="plz enter content")
	private String description;
	private String title;
	private String createdDate;
	private boolean status;
	private String authorName;
	
	@Transient
	private MultipartFile file;

	public NewPost() {
		this.imageCode = "POST" + UUID.randomUUID().toString().substring(26).toUpperCase();
		this.createdDate= DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()); 
		this.status=false;
	}

	
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getImageCode() {
		return imageCode;
	}

	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
	


}
