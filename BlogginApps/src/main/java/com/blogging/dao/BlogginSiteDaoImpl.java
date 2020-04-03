package com.blogging.dao;



import java.awt.image.RescaleOp;
import java.io.Serializable;
import java.util.List;

import javax.ejb.CreateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blogging.modal.Categories;
import com.blogging.modal.NewPost;
import com.blogging.modal.RegisterUser;
import com.blogging.utitlity.UtilityClass;

@Repository
public class BlogginSiteDaoImpl implements BlogginSiteDao {
	@Autowired
	private SessionFactory sessionfactory;

	@Override
	@Transactional
	public boolean registerUser(RegisterUser registerAttribute) {
		
		try
		{
			 
		 registerAttribute.setSalt(BCrypt.gensalt());
	    String s=BCrypt.hashpw(registerAttribute.getPassword(),registerAttribute.getSalt());
		
		 Session currentSession = sessionfactory.getCurrentSession();
		 currentSession.save(registerAttribute);
		 
	     registerAttribute.setPassword(s);
		
		
		 return true;
		 
		}
		catch (Exception e) {
			return false;
		}
		
	}

	@Transactional
	@Override
	public List<NewPost> getAllpost() {
		
		boolean statu=true;
		Query createQuery = sessionfactory.getCurrentSession().createQuery("from NewPost where status=:status");
		createQuery.setParameter("status", statu);
		
		return createQuery.list();
	}
	@Transactional
	@Override
	public NewPost getArticlebasedOnImageCode(String imageCode) {
		
		
		return sessionfactory.getCurrentSession().get(NewPost.class, imageCode);
	}

	@Override
	@Transactional
	public RegisterUser getLogin(String email, String userPassword) {
		
	
		Query createQuery = sessionfactory.getCurrentSession().createQuery("from RegisterUser where email=:email",RegisterUser.class);
		createQuery.setParameter("email", email);
		
	
		RegisterUser list = (RegisterUser) createQuery.uniqueResult();
		
		
		
		
		
	
		if(list!=null && BCrypt.checkpw(userPassword,list.getPassword()))
			
		{
	

			System.out.println("password matched");
			
			return list;
				
			
			
		}
		else
		{
		System.out.println("password not mathced");
		return null;
		}
	
		
	
	}

	@Override
	@Transactional
	public boolean saveCategory(Categories c) {
		
		try
		{
	      sessionfactory.getCurrentSession().save(c);
	      System.out.println("data saved");
	      return true;
		}
		catch (Exception e) {
			  System.out.println("data  not saved");
		
			return false;
		}
		
	}

	@Override
	@Transactional
	public List<Categories> getAllCategory() {
	
		return sessionfactory.getCurrentSession().createQuery("from Categories").list();
	}

	@Override
	@Transactional
	public boolean savePost(NewPost newPost) {
		try
		{
	      sessionfactory.getCurrentSession().save(newPost);
	      System.out.println("data saved");
	      return true;
		}
		catch (Exception e) {
			  System.out.println("data  not saved");
		
			return false;
		}
		
	}

	@Override
	@Transactional
	public List<NewPost> getTotalPost() {
		Query createQuery = sessionfactory.getCurrentSession().createQuery("from NewPost");
		
		return createQuery.list();
	}

	@Override
	@Transactional
	public List<RegisterUser> getRegisteredUser() {
		Query createQuery = sessionfactory.getCurrentSession().createQuery("from RegisterUser");
		
		
	
		return createQuery.list();
	}

	@Override
	@Transactional
	public int deleteById(String id) {
		Session currentSession = sessionfactory.getCurrentSession();
		
		try
		{
		NewPost newPost = currentSession.get(NewPost.class, id);
		currentSession.delete(newPost);
		System.out.println("deleted");
		return 1;
		}
		catch (Exception e) {
			return 0;
		}
		
	
	}

	@Override
	@Transactional
	public NewPost getallpostByImageid(String imageid) {
		
		return sessionfactory.getCurrentSession().get(NewPost.class, imageid);
	}

	@Override
	@Transactional
	public boolean updatePost(NewPost newPost) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().saveOrUpdate(newPost);
		
		return true;
	}



}
