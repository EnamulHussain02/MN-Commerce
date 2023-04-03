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
import com.example.mnshopz.service.OrderService;
import com.example.mnshopz.service.ProductsServiceImpl;
import com.google.gson.Gson;

@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(ProductsServiceImpl.class);

	@Autowired
	CustomerService customerService;

	@Autowired
	ProductsServiceImpl productService;
	
	@Autowired
	OrderService orderService;

	@GetMapping("/landing")
	public String landing() {
		return "landing";
	}

	@GetMapping("/logLanding")
	public String LogLAnding() {

		return "landinglgin";
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
	
	@GetMapping("/addProduct")
	public String addproduct() {
		return "addProduct";
	}

	@GetMapping("/viewOrder")
	public String viewOrders() {
		return "showOrder";
	}

	@PostMapping("/sendProduct")
	@ResponseBody
	public String sendProduct(@RequestBody Map<String, Object> product) {
		Map<String, Object> receivedData = productService.getProduct(product);
		String productData = new Gson().toJson(receivedData);
		logger.info(productData);
		return productData;
	}

	@PostMapping("/newUser")
	@ResponseBody
	public String viewUser(@RequestBody Map<String, Object> userRegistration) {
		logger.info("CHeck"+userRegistration);
		Map<String, Object> result = customerService.setUsers(userRegistration);
		
		String userDetails = new Gson().toJson(result);
		return userDetails;
	}

	@PostMapping("/userLogin")
	@ResponseBody
	public String loginUser(@RequestBody Map<String, Object> userLogin) {
		Map<String, Object> loginDetails = customerService.verifyUser(userLogin);
		logger.info("check" + loginDetails);
		String result = new Gson().toJson(loginDetails);
		return result;
	}

	@PostMapping("/addNewProducts")
	@ResponseBody
	public String addProducts(@RequestBody Map<String, Object> newProduct) {
		logger.info("Hello" + newProduct);
		Map<String, Object> insertResult=new HashMap<>();		
		insertResult= productService.setProducts(newProduct);
		String products =new Gson().toJson(insertResult);
		logger.info(products);
		return products;

	}

	@PostMapping("/products")
	@ResponseBody
	public String sendProducts() {

		String finalProducts = "";
		try {
			Map<String, Object> productData = productService.getAllProducts();
			logger.info("check" + productData);

			finalProducts = new Gson().toJson(productData);
			logger.info(finalProducts);
		} catch (Exception e) {
			logger.info("Error is" + e);
		}
		return finalProducts;
	}

	@PostMapping("/orders")
	@ResponseBody
	public String sendOrders(@RequestBody Map<String,Object> orderUser) {
		logger.info("check"+orderUser);
		Map<String, Object> result = orderService.orderDetails(orderUser);
		String orderData = new Gson().toJson(result);
		logger.info("check"+orderData);
		return orderData;
	}
	
	@PostMapping("/setOrders")
	@ResponseBody
	public String saveOrders(@RequestBody Map<String, Object> orderData) {
		logger.info("check"+orderData);
		Map<String, Object> response=orderService.setOrders(orderData);
		logger.info("check"+response);
		String orderResponse=new Gson().toJson(response);
		logger.info("check"+orderResponse);
		return orderResponse;

	}

}
