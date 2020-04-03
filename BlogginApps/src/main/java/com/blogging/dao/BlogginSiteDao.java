package com.blogging.dao;


import java.util.List;

import com.blogging.modal.Categories;
import com.blogging.modal.NewPost;
import com.blogging.modal.RegisterUser;

public interface BlogginSiteDao {

	boolean registerUser(RegisterUser registerAttribute);

	public List<NewPost> getAllpost();

	public NewPost getArticlebasedOnImageCode(String imageCode);

	public RegisterUser getLogin(String email, String hashPassword);

	public boolean saveCategory(Categories c);

	public List<Categories> getAllCategory();

	boolean savePost(NewPost newPost);

	public List<NewPost> getTotalPost();

	public List<RegisterUser> getRegisteredUser();

	int deleteById(String id);

	NewPost getallpostByImageid(String imageid);

	boolean updatePost(NewPost newPost);


}
