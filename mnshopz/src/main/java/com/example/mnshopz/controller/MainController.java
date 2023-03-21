package com.example.mnshopz.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.mnshopz.service.CustomerService;
import com.example.mnshopz.service.ProductsServiceImpl;
import com.google.gson.Gson;

@Controller
public class MainController {
	
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
	public String viewUser(@RequestBody Map<String,Object> userRegistration) {
		customerService.setUsers(userRegistration);
		return "landing";
	}
	
	@PostMapping("/products")
	public String sendProducts(){
		Map<String,Object> productData=productService.getAllProducts();
		String finalProducts;
		return finalProducts=new Gson().toJson(productData);
	}
}
