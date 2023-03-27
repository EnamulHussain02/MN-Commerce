package com.example.mnshopz.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mnshopz.service.CustomerService;
import com.example.mnshopz.service.ProductsServiceImpl;
import com.google.gson.Gson;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductsServiceImpl.class);
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProductsServiceImpl productService;
	
	@GetMapping("/landing")
	public String landing() 
	{
		return "landing";
	}
	
	@GetMapping("/registration")
	public String reister() {
		return "register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/viewProduct")
	public String products() {
		return "viewProduct";
	}
	
	@GetMapping("/viewProduct2")
	public String products2() {
		return "viewProduct2";
	}
	
	@GetMapping("/viewProduct3")
	public String products3() {
		return "viewProduct3";
	}
	
	@GetMapping("/viewProduct4")
	public String products4() {
		return "viewProduct4";
	}
	
	@GetMapping("/viewProduct5")
	public String products5() {
		return "viewProduct5";
	}
	
	@GetMapping("/viewProduct6")
	public String products6() {
		return "viewProduct6";
	}
	
	@GetMapping("/viewProduct7")
	public String products7() {
		return "viewProduct7";
	}
	
	@GetMapping("/viewProduct8")
	public String products8() {
		return "viewProduct8";
	}
	
	@GetMapping("/viewProduct9")
	public String products9() {
		return "viewProduct9";
	}
	
	@GetMapping("/addProduct")
	public String addNewProduct() {
		return "addProduct";
	}
	
	@PostMapping("/newUser")
	@ResponseBody
	public String viewUser(@RequestBody Map<String,Object> userRegistration) {
		Map<String,Object> result=customerService.setUsers(userRegistration);
		String userDetails=new Gson().toJson(result);
		return userDetails;
	}
	
	
	@PostMapping("/userLogin")
	@ResponseBody
	public String loginUser(@RequestBody Map<String,Object> userLogin) {
		Map<String,Object> loginDetails=customerService.verifyUser(userLogin);
		String result=new Gson().toJson(loginDetails);
		return result;
	}
	
	
	@PostMapping("/addNewProducts")
	@ResponseBody
	public String addProducts(@RequestBody Map<String,Object> newProduct) {
		logger.info("Hello"+newProduct);
		String products=productService.setProducts(newProduct);
		return products;
		
	}	
	
	@PostMapping("/products")
	@ResponseBody
	public String sendProducts(){
		
		String finalProducts="";
		try {		
				Map<String, Object> productData=productService.getAllProducts();
				logger.info("check"+productData);
				
			finalProducts=new Gson().toJson(productData);
			logger.info(finalProducts);
		}
		catch (Exception e) {
			logger.info("Error is"+e);
		}
		return finalProducts;
	}
	
	
}
