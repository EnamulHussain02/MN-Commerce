package com.example.mnshopz.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mnshopz.service.CustomerServiceImpl;
import com.example.mnshopz.service.ProductsServiceImpl;
import com.google.gson.Gson;

@Controller
public class CustomerController {

	@Autowired
	public ProductsServiceImpl productService;

	@Autowired
	public CustomerServiceImpl customerService;

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@GetMapping("/customer")
	public String listCustomer(Model model) {

		model.addAttribute("customer", customerService.getAllCustomer());
		return "customer";
	}

	@GetMapping("/registration")
	public String viewRegistration(Model model) {
		model.addAttribute("registration", customerService.getAllCustomer());
		return "register";
	}
	
	@GetMapping("/login")
	public String viewLogin(Model model) {
		model.addAttribute("login", customerService.getAllCustomer());
		return "login";
	}

	@PostMapping("/product")
	@ResponseBody
	public String product() {

		logger.info("output");
		Gson gson = new Gson();
		String data = "";
		Map<String, Object> prod = productService.getAllProducts();

		try {
			data = gson.toJson(prod);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return data;

	}

}
