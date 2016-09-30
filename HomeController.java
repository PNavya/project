package com.niit.ShoppingCart.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingCart.dao.CategoryDAO;
import com.niit.ShoppingCart.dao.SupplierDAO;
import com.niit.ShoppingCart.dao.UserDetailsDAO;
import com.niit.ShoppingCart.model.Category;
import com.niit.ShoppingCart.model.Supplier;
import com.niit.ShoppingCart.model.UserDetails;

//import com.niit.ShoppingCart.model.Product;

@Controller
public class HomeController {
	
	
	@Autowired
	private UserDetails user;
	@Autowired
	private UserDetailsDAO userdetailsDAO;
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category category;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	Supplier supplier;
	
	@RequestMapping("/")
	public ModelAndView show()
	{
		ModelAndView mv=new ModelAndView("bootstrap");
		return mv;
	}

	@RequestMapping("/Login")
	public ModelAndView showSignin()
	{
		ModelAndView mv=new ModelAndView("Login");
		return mv;
	}

	
	@ModelAttribute
	public UserDetails returnObject()
	{
		return new UserDetails();
	}
	
	
}
