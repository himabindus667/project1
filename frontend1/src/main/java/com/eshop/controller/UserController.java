package com.eshop.controller;




import java.util.Collection;

import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eshop.dao.ProductDAO;
import com.eshop.dao.UserDetailDAO;
import com.eshop.model.Product;
import com.eshop.model.UserDetail;



@Controller
public class UserController 
{
    @Autowired
    ProductDAO productDAO;
    
    @Autowired
    UserDetailDAO userDetailDAO;
    
    @RequestMapping(value="/userhome")
	public String showUserHome(Model m,HttpSession session)
	{
        m.addAttribute("pageinfo","Product Gallery");
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productList", listProducts);
        return "UserHome";
	}
    
    
    
    @RequestMapping(value="/addUser",method=RequestMethod.POST)
    public String addUser(Model m, @RequestParam("userName")String username,@RequestParam("customerName")String customerName,@RequestParam("customerAddr")String customerAddr, @RequestParam("password")String password)
    {
    	    	
    	UserDetail user=new UserDetail();
    	user.setCustomerAddr(customerAddr);
    	user.setCustomerName(customerName);
    	user.setEnabled(true);
    	user.setRole("ROLE_USER");
    	user.setPassword(password);
    	user.setUsername(username);
    	
    	userDetailDAO.registerUser(user);
				
		return "Login";
    	
	}
    
    
	
	
	@RequestMapping(value="/login_success")
	public String loginCheck(Model m,HttpSession session)
	{
		String page="";
		boolean loggedIn=false;
		
		SecurityContext securityContext=SecurityContextHolder.getContext();
		Authentication authentication=securityContext.getAuthentication();
		
		String username=authentication.getName();
		
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
			
			if(role.getAuthority().equals("ROLE_ADMIN"))
			{
				loggedIn=true;
				page="AdminHome";
				session.setAttribute("loggedIn",loggedIn);
				session.setAttribute("username",username);
			}
			else
			{
                m.addAttribute("pageinfo","User Home");
				
				List<Product> listProducts=productDAO.listProducts();
				m.addAttribute("productList", listProducts);

				loggedIn=true;
				page="UserHome";
				session.setAttribute("loggedIn",loggedIn);
				session.setAttribute("username",username);	
				
                			}
		}
		return page;
	}
}
