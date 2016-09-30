package com.niit.ShoppingCart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingCart.dao.ProductDAO;
import com.niit.ShoppingCart.dao.SupplierDAO;
import com.niit.ShoppingCart.model.Category;
import com.niit.ShoppingCart.model.Product;
import com.niit.ShoppingCart.model.Supplier;

@Controller
public class SupplierController {
	
	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	
	private Supplier supplier;
	
	@RequestMapping(value = "/addSupplier", method = RequestMethod.GET)
	public String listSuppliers(Model model) {

		model.addAttribute("supplier", new Supplier());
		model.addAttribute("supplierList", this.supplierDAO.list());

		return "addSupplier";
	}
	@RequestMapping(value = "/sadd", method = RequestMethod.POST)
	public String addSupplier(@ModelAttribute("supplier") Supplier supplier) {

		supplierDAO.save(supplier);
		// return "supplier";//see once its correct or not
		return "admin";
	}
	@ModelAttribute
	public Supplier returnObject()
	{
		return new Supplier();
	}
	@RequestMapping(value = "/Deletesupplier{supId}")
	public ModelAndView Deletesupplier(@Valid @PathVariable("supId") String supId) throws Exception {

		
		supplier = supplierDAO.getId(supId);
		ModelAndView mv = new ModelAndView("addSupplier");
		productDAO.orphanremoval1(supplier.getSupId());
		supplierDAO.delete(supplier);
		mv.addObject("supplierList", supplierDAO.list());
		mv.addObject("listsupp", 0);
		return mv;
	}

	@RequestMapping("sup{supId}")
	public ModelAndView sup(@PathVariable("supId") String supId, ModelMap model){
		ModelAndView mv = new ModelAndView("updateSupplier");
		System.out.println("edit supplier");
		//supplier=supplierDAO.get(supId);
		System.out.println("supplier list");
		model.addAttribute("supplier",this.supplierDAO.get(supId));
		model.addAttribute("listSuppliers",this.supplierDAO.list());		
	
		return mv;
	
	}
	@RequestMapping(value = "/editsupplier", method = RequestMethod.POST)
	public ModelAndView editsup(@ModelAttribute("supplier") Supplier supp,BindingResult result,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("admin");
		System.out.println("hai");
		supplierDAO.update(supp);
		mv.addObject("supplierList", supplierDAO.list());
		
		return mv;
	}
}
