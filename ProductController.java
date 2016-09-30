package com.niit.ShoppingCart.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.ShoppingCart.dao.CategoryDAO;
import com.niit.ShoppingCart.dao.ProductDAO;
import com.niit.ShoppingCart.dao.SupplierDAO;
import com.niit.ShoppingCart.model.Category;
import com.niit.ShoppingCart.model.Product;
import com.niit.ShoppingCart.model.Supplier;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private Product product;

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	
	private Category category;
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private Supplier supplier;
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String listSuppliers(Model model) {

		model.addAttribute("product", new Product());
		model.addAttribute("productList", this.productDAO.list());
		model.addAttribute("category", category);
		model.addAttribute("categoryList", this.categoryDAO.list());
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", this.supplierDAO.list());

		return "addProduct";
	}
	@RequestMapping(value="/addprod", method = RequestMethod.POST)
	public String Productregister(@Valid @ModelAttribute("product") Product prod,Model model, BindingResult result,
						HttpServletRequest request) throws IOException {
					//ModelAndView mv = new ModelAndView("bootstrap");
			
					@SuppressWarnings("unused")
					String filename;
					@SuppressWarnings("unused")
					byte[] bytes;
					System.out.println(prod.getName());
			
				System.out.println("image uploaded");
			
					System.out.println("myproduct controller called");
					MultipartFile image = prod.getImage();
					Path path;
					path = Paths.get(
							"E:/maven/ShoppingCartFront/src/main/webapp/resources/images/" + prod.getName() + ".jpg");
			
					System.out.println("Path = " + path);
					System.out.println("File name = " + prod.getImage().getOriginalFilename());
					if (image != null && !image.isEmpty()) {
						try {
							image.transferTo(new File(path.toString()));
							System.out.println("Image Saved in:" + path.toString());
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("Image not saved");
						}
					}
					Category category = categoryDAO.getId(prod.getCategory().getCatid());
					//categoryDAO.save(category);
					Supplier supplier = supplierDAO.getId(prod.getSupplier().getSupId());
					prod.setCategory(category);	
					prod.setSupplier(supplier);
					prod.setCatid(category.getCatid());
					prod.setSupId(supplier.getSupId());
					productDAO.save(prod);
					
					return "admin";
				}
	
	@RequestMapping("proddelete{prodid}")
	public String removeSupplier(@ModelAttribute("product") Product prod) throws Exception {
	
		//supplier = supplierDAO.get(supId);
		
		ModelAndView mv = new ModelAndView("admin");
		
		if(product==null)
			
		{
			mv.addObject("error messaege","could not delete the supplier");
		}
		else
		{
			productDAO.delete(prod);
		}
		return "admin";
	}
	@RequestMapping(value = "/pupdate{prodid}")
	public ModelAndView UpdatecatPage(@PathVariable("prodid") String prodid) throws Exception {
		ModelAndView mv = new ModelAndView("updateProduct");
		System.out.println(prodid);
		product = productDAO.get(prodid);
		mv.addObject("product", product);
		mv.addObject("categoryList", categoryDAO.list());
		mv.addObject("supplierList", supplierDAO.list());
		
		return mv;
	}
	@ModelAttribute
	public Product returnObject()
	{
		return new Product();
	}

	@RequestMapping(value = "/updateprod", method = RequestMethod.POST)
	public ModelAndView Updateproduct(@Valid @ModelAttribute("product") Product prod, BindingResult result,
			HttpServletRequest request) throws IOException {
		ModelAndView mv = new ModelAndView("admin");
		category = categoryDAO.getId(prod.getCategory().getCatid());
		supplier = supplierDAO.getId(prod.getSupplier().getSupId());
		prod.setSupplier(supplier);
		prod.setCategory(category);
		prod.setCatid(category.getCatid());
		prod.setSupId(supplier.getSupId());
		productDAO.update(prod);
		//mv.addObject("listprod", 0);
		return mv;
	}
	@RequestMapping("/viewdetails")
	public ModelAndView viewItems() throws JsonGenerationException, JsonMappingException, IOException {
		List<Product> list = productDAO.list();
		System.out.println("user list=" + list);
		ObjectMapper om = new ObjectMapper();
		String listjson = om.writeValueAsString(list);
		System.out.println(listjson);
		return new ModelAndView("viewdetails", "listofitem", listjson);
	}

	
	String setName;
	List<Product> plist;

	@SuppressWarnings("unchecked")
	@RequestMapping("/GsonCon")
	public @ResponseBody String getValues() throws Exception {
		String result = "";
		plist = productDAO.list();
		Gson gson = new Gson();
		result = gson.toJson(plist);
		return result;

	}
	

}
