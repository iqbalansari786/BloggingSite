package com.blogging.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

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
import com.blogging.modal.NewPost;
import com.blogging.modal.RegisterUser;
import com.blogging.utitlity.UtilityClass;

@Controller

public class MainController {
@Autowired
HttpServletRequest request;
	
	@Autowired
	private BlogginSiteDao blogginDao;
	
	@RequestMapping(value= {"/home","/"})
	public ModelAndView homePage()
	{
		ModelAndView mv=new ModelAndView("index");
		if(request.getSession().getAttribute("username")!=null)
		{
			mv.addObject("LoggedUserStatus",true);
		}
		else
		{
			mv.addObject("LoggedUserStatus",false);
		}
		
		
		mv.addObject("title", "home");
		mv.addObject("loginAttribute",new RegisterUser());
		
		
		mv.addObject("userClickedHome",true);
		return mv;
	}
	
	@RequestMapping(value= "/registerForm")
	public ModelAndView registerForm(Model model)
	{
		System.out.println("Register controller called");
		model.addAttribute("loginAttribute",new RegisterUser());
		model.addAttribute("registerAttribute",new RegisterUser());
		
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("LoggedUserStatus",false);
		mv.addObject("title", "Register");
		mv.addObject("userClickedRegister",true);
		return mv;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView loginUser(@Valid @ModelAttribute("loginAttribute") RegisterUser loginUser,BindingResult bindingResult,HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		ModelAndView mv=new ModelAndView("index");
		/*if(bindingResult.hasErrors())
		{
			mv.addObject("title", "Login");
			mv.addObject("userClickedHome",true);
			System.out.println("Binding value is not filled");
			
			return mv;
			
		}
		*/
		String password=loginUser.getPassword();
		
		mv.addObject("title", "Login");
		
		mv.addObject("userClickedHome",true);
		System.out.println("email"+loginUser.getEmail()+""+loginUser.getPassword());
		
		RegisterUser result=blogginDao.getLogin(loginUser.getEmail(),password);
		
		
	
		
		if(result!=null)
		 {
			
			
			   session.setAttribute("username", loginUser.getEmail());
				System.out.println("logged"+result.getRole());
				mv.addObject("loggedUserEmail",loginUser.getEmail());
				mv.addObject("logginErrormsg","Succesfully logged in.");
				
				mv.addObject("loggedUserName",result.getFirstName());
				mv.addObject("LoggedUserStatus",true);
				
			
				return mv;
			
		
		}
		else 
		{
			mv.addObject("LoggedUserStatus",false);
			System.out.println("not logged");
			mv.addObject("logginErrormsg","sorry some error is there..");
			return mv;
		}
		
		
	}
	
	
	@RequestMapping(value= "/register",method=RequestMethod.POST)
	public ModelAndView registeringUser(@Valid @ModelAttribute("registerAttribute") RegisterUser registerAttribute,BindingResult bindingResult,Model model,HttpServletRequest req)
	{
		
		 boolean resutl=false;
		String confirmPassowrd=req.getParameter("confirmPassword");
		System.out.println("Registering into table");
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("LoggedUserStatus",false);
		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("loginAttribute",new RegisterUser());
			mv.addObject("title", "Register");
			mv.addObject("userClickedRegister",true);
			System.out.println("binding value is not entered correctly");
			return mv;
			
		}
		
		model.addAttribute("loginAttribute",new RegisterUser());
		
		if(registerAttribute.getPassword().equals(confirmPassowrd))
		{
			  resutl=blogginDao.registerUser(registerAttribute);
		}
		else
		{
			   model.addAttribute("registerUserMsg","plz write same password in confirm password!");
				
				mv.addObject("title", "Register");
				mv.addObject("userClickedRegister",true);
				return mv;
		}
	 
	   if(resutl ==  true)
	   {
		   model.addAttribute("registerUserMsg","you have successfully registered !");
		   
			
			
			mv.addObject("title", "Register");
			mv.addObject("userClickedRegister",true);
			return mv;
			
	   }
	   else
	   {
		
		   model.addAttribute("registerUserMsg","you have done some error!");
		
			mv.addObject("title", "Register");
			mv.addObject("userClickedRegister",true);
			return mv;
	   }
		
	   
		
	}
		
	
	@RequestMapping(value= "/readArticle/{imageCode}")
	public ModelAndView readArticle(@PathVariable("imageCode") String imageCode,Model model)
	{
		
		System.out.println("imagecode"+imageCode);
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("LoggedUserStatus",false);
		mv.addObject("loginAttribute",new RegisterUser());
		mv.addObject("title", "Article");
		NewPost newPost=blogginDao.getArticlebasedOnImageCode(imageCode);
		
		model.addAttribute("singleArticle",newPost);
		
		System.out.println(newPost.getDescription());
		mv.addObject("userClickedReadArticle",true);
		return mv;
	}
	@ModelAttribute("allPost")
	
	public List<NewPost> allPost()
	{
		
		List<NewPost> allpost = blogginDao.getAllpost();
		
		return allpost;
		
	}

	
	@RequestMapping(value= {"/adminlogin"})
	public ModelAndView adminLogin(@RequestParam(name="error",required=false)String error,
			@RequestParam(name="logout",required=false)String logout,
			
			Model model,HttpServletRequest req) {
		
		System.out.println("admin controller called"+req.getParameter("username"));
		ModelAndView mv=new ModelAndView("adminLogin");
		if(error!=null)
		{
			mv.addObject("errormsg","invalid username and password !");
		}
		if(logout!=null)
		{
			mv.addObject("errormsg","Succesfully log out !");
		}

	
		mv.addObject("title","admin Login");
		
		
		
		return mv;
	}
	
	
	
	@RequestMapping(value= {"/access-denied"})
	public ModelAndView accessdenied(Model model) {
		System.out.println("admin controller called");
		ModelAndView mv=new ModelAndView("errorView");

		

	
		mv.addObject("title","Access denied");
		mv.addObject("description","sorry you have not permision to use this page thank you.");
		
		
		
		return mv;
		
	}
	
	
@ModelAttribute("recentPost")
	
	public List<NewPost> recentPost()
	{
		
		List<NewPost> allpost = blogginDao.getAllpost();
		Collections.sort(allpost, new Comparator<NewPost>() {
			  public int compare(NewPost o1, NewPost o2) {
			      return o1.getCreatedDate().compareTo(o2.getCreatedDate());
			  }
			});
		
		
		return allpost;
		
	}

@RequestMapping(value= {"/SignOut"})
public ModelAndView signOut()
{
	
	request.getSession().invalidate();
	ModelAndView mv=new ModelAndView("index");
	mv.addObject("title", "Logged Out");
	mv.addObject("loginAttribute",new RegisterUser());
	mv.addObject("LoggedUserStatus",false);
	
	
	mv.addObject("userClickedHome",true);
	return mv;
}





}
