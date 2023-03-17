package com.example.mnshopz.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mnshopz.entity.Customer;
import com.example.mnshopz.repository.CustomerRepository;
import com.example.mnshopz.service.CustomerService;
import com.example.mnshopz.service.ProductsServiceImpl;

@Controller
public class CustomerController {

	@Autowired
	ProductsServiceImpl productService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerRepository customerRepository;

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	List<Customer> cusData=new ArrayList();
	
	@GetMapping("/registration")
	public String viewRegistration() 
	{
		return "register";
	}
	
	@PostMapping("/register")
	public String saveCustomer(@RequestBody Map<String,Object>  customer) {		
		String name=(String) customer.get("cname");
		logger.info(name);
		customerService.saveCustomer(customer);
		return "customer";
	}
		
	@GetMapping("/customer")
	public String listCustomer() 
	{
		
		return "customer";
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
