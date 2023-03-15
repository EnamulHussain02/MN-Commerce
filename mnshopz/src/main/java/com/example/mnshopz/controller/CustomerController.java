package com.example.mnshopz.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mnshopz.service.ProductsServiceImpl;
import com.google.gson.Gson;

@Controller
public class CustomerController {

	@Autowired
	ProductsServiceImpl productService;

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@GetMapping("/customer")

	public String listCustomer(Model model) 
	{
		model.addAttribute("customer",productService.getAllProducts());
		return "customer";
	}

	@GetMapping("/registration")
	public String viewRegistration(Model model) 
	{
		model.addAttribute("register",productService.getAllProducts());
		return "register";
	}
	
//	@PostMapping("/viewdata")
//	public void myMethod(@RequestBody String data) {
//	    // Handle the JSON data in the request body
//	    System.out.println(data);
//	  }
//
//	@PostMapping("/login")
//	public String viewLogin() {
//		return "login";
//	}
//	
//	@PostMapping("/product")
//	@ResponseBody
//	public String getProductDetails() {
//		Map<String, Object> ps = productService.getAllProducts();
//		String getdata = new Gson().toJson(ps);
//		return getdata;
//	}


}
