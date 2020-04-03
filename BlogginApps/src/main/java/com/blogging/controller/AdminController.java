package com.blogging.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blogging.dao.BlogginSiteDao;
import com.blogging.modal.Categories;
import com.blogging.modal.NewPost;
import com.blogging.modal.RegisterUser;
import com.blogging.validator.CustomValidator;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private BlogginSiteDao blogginDao;
	
	@RequestMapping(value= {"/adminHome"})
	public ModelAndView adminPanel(Model model) {
		int i=0;
		
		
		System.out.println("admin controller called");
		model.addAttribute("addpostAttribute",new NewPost());
		ModelAndView mv=new ModelAndView("adminControl");
		
		
		List<NewPost> totalPost=blogginDao.getTotalPost();
		List<Categories> allCategory = blogginDao.getAllCategory();
		List<RegisterUser> admin=blogginDao.getRegisteredUser();
		
		for(RegisterUser r:admin)
		{
			if(r.getRole().equals("admin"))
			{
				i++;
			}
		}
		
		mv.addObject("registeredUser",admin);
		mv.addObject("detailofcategory",allCategory);
		mv.addObject("totalnoPost", totalPost.size());
		mv.addObject("totalnoCategory", allCategory.size());
		mv.addObject("totalnoAdmin", i);
		
		mv.addObject("title","admin Control Panel");
		mv.addObject("adminClickedDashBoard",true);
		return mv;
	}
	

	
	@RequestMapping(value= {"/NewPost"})
	public ModelAndView adminNewPost(@RequestParam(value="editid",required=false)String imageid,Model model) {
		System.out.println("admin controller called");
		
		model.addAttribute("addpostAttribute",new NewPost());
		if(imageid!=null)
		{
			NewPost updatePost=blogginDao.getallpostByImageid(imageid);
			model.addAttribute("addpostAttribute",updatePost);
		}
		
		
		ModelAndView mv=new ModelAndView("adminControl");
		mv.addObject("title","New post");
		mv.addObject("adminClickedNewPost",true);
		return mv;
	}
	
	@RequestMapping(value= {"/addNewPost"},method=RequestMethod.POST)
	public ModelAndView adminaddPost(@Valid @ModelAttribute("addpostAttribute")NewPost newPost,BindingResult bindingResult,HttpServletRequest req,Model model) {
		System.out.println("admin controller called"+newPost.getDescription());
	
		
		new CustomValidator().validate(newPost, bindingResult);
		ModelAndView mv=new ModelAndView("adminControl");
		if(bindingResult.hasErrors())
		{
			mv.addObject("title","New post");
			mv.addObject("adminClickedNewPost",true);
			mv.addObject("addPostMsg","Some error is there !");
			return mv;
		}
	
	 boolean result=blogginDao.savePost(newPost);
	if(!newPost.getFile().getOriginalFilename().equals(""))
	{
		System.out.println("now it is in file"+newPost.getFile().getOriginalFilename());
		FileUploadUtility.saveFile(req,newPost.getFile(),newPost.getImageCode());	
		System.out.println("file savved");
	}
	

	System.out.println("result "+result);
	if(result == true)
	{
		
		mv.addObject("title","New post");
		mv.addObject("adminClickedNewPost",true);
		mv.addObject("addPostMsg","Created Post SuccessFully !");
		NewPost  newpostreset=new NewPost();
		model.addAttribute("addpostAttribute",newpostreset);
		
		return mv;
	}
		
		
	mv.addObject("addPostMsg","Cannot created Post try again !");
		mv.addObject("title","New post");
		mv.addObject("adminClickedNewPost",true);
		return mv;
	}
	
	@RequestMapping(value= {"/editPost"})
	public ModelAndView adminEditPost() {
		System.out.println("admin controller called");
		
		
		ModelAndView mv=new ModelAndView("adminControl");
		
		List<NewPost> totalPost=blogginDao.getTotalPost();
	
		mv.addObject("detailOfPost",totalPost);
		mv.addObject("title","Edit post");
		mv.addObject("adminClickedEditPost",true);
		return mv;
	}
	
	
	
	@RequestMapping(value= {"/addCategoryForm"})
	public ModelAndView adminAddCategoryForm() {
		System.out.println("admin controller called");
		
		
		ModelAndView mv=new ModelAndView("adminControl");
		mv.addObject("title","Adding categoriries");
		mv.addObject("adminClickedAddCategory",true);
		return mv;
	}
	
	
	
	@RequestMapping(value= {"/addCategories"})
	public ModelAndView adminAddCategories(HttpServletRequest req) {
		System.out.println("admin controller called"+req.getParameter("category"));
		boolean result=false;
		
		ModelAndView mv=new ModelAndView("adminControl");
		
		Categories c=new Categories();
	
		c.setCategories(req.getParameter("category").toUpperCase());
		if(!req.getParameter("category").isEmpty())
		{
			System.out.println("category"+req.getParameter("category"));
			 result=blogginDao.saveCategory(c);
		
		}
		else
		{
			System.out.println("sorry no vlaue");
			mv.addObject("msg","it sholud not be empy");
			mv.addObject("title","Adding categoriries");
			mv.addObject("adminClickedAddCategory",true);
			mv.addObject("addCategoryMsg","Sorry some error !");
			return mv;
		}
		

	if(result == true)
	{
		
		mv.addObject("title","Adding categoriries");
		mv.addObject("adminClickedAddCategory",true);
		mv.addObject("addCategoryMsg","Added successfully");
		return mv;
		
	}
	else
	{
		
	
		mv.addObject("title","Adding categoriries");
		mv.addObject("adminClickedAddCategory",true);
		mv.addObject("addCategoryMsg","Sorry some error !");
		return mv;
		
	}
	
	

	}
@RequestMapping("/adminLogout")
public String adminLogout(HttpServletRequest req,HttpServletResponse res)
{
	
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	if(authentication!=null)
	{
		new SecurityContextLogoutHandler().logout(req, res, authentication);
	}
	
	
	return "redirect:/adminlogin?logout";
}
	

	

	
	
	@ModelAttribute("categoryList")
	public Map<Integer,String> adminCategoryList()
	{
		Map<Integer,String> map=new HashMap<>();
		int i=0;
		 List<Categories> allCategory = blogginDao.getAllCategory();
		 if(allCategory.size()>0)
		 {
			 for(Categories c:allCategory)
			 {
				 
				 map.put(i,c.getCategories());
				 i++;
			 }
			 
			 return map;
			 
		 }
		 return null;
		
		
		 
	}
	
	@RequestMapping("/delete/{buttonid}")
	@ResponseBody
	public String deletePost(@PathVariable("buttonid") String id)
	{
		
		System.out.println("delting");
		
		int i=blogginDao.deleteById(id);
		if(i!=0)
		{
			return "Thank  you deleted succesfully !";
		}
		else
		{
			return "its not delted";
		}
		
			 
		 }
	
	@ModelAttribute("username")
	public String adminUserid()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username=auth.getName();

		System.out.println("user name"+username);
		return username;
			 
		 }
	
}
