package com.example.mnshopz.controller;

import java.util.HashMap;
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
	
	@PostMapping("/newUser")
	@ResponseBody
	public String viewUser(@RequestBody Map<String,Object> userRegistration) {
		String result=customerService.setUsers(userRegistration);
		logger.info(result);
		return "newUser";
	}
	
	@PostMapping("/products")
	@ResponseBody
	public String sendProducts(){
		
		String finalProducts="";
		try {
			
		
		Map<String,Object> productData=new HashMap<>();
		productData=productService.getAllProducts();
		finalProducts=new Gson().toJson(productData);
		logger.info(finalProducts);
		
		}
		catch (Exception e) {
			logger.info("Error is"+e);
		}
		return finalProducts;
	}
}
