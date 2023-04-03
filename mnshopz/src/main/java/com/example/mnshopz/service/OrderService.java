package com.example.mnshopz.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mnshopz.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	

	private static final Logger logger = LoggerFactory.getLogger(ProductsServiceImpl.class);
	
	public Map<String, Object> orderDetails(Map<String,Object> orderNumber){
		
		String num=(String) orderNumber.get("customer_number");
		Long number =Long.parseLong(num);	
		
		List<Map<String, Object>> receivedDetails=orderRepository.sendOrderDetails(number);
		Map<String, Object> finalData= new HashMap<>();
		finalData.put("orders", receivedDetails);
		return finalData;
	}
	
	public Map<String, Object> setOrders(Map<String, Object> orderData){
		
		String payVia=(String) orderData.get("payment_via");		
		long millis=System.currentTimeMillis();  
		java.sql.Date date = new java.sql.Date(millis);		 
		String num=(String) orderData.get("customer_number");
		String prodId=(String) orderData.get("product_detail_id");
		
		int price = Integer.valueOf((Integer)orderData.get("total"));	
		Long number =Long.parseLong(num);		
		Long  productId=Long.parseLong(prodId);

		int result=orderRepository.setOrders(payVia,date,number,productId,price);
		List<Map<String,Object>> customerName=new ArrayList<>();
		if(result==1) {
			customerName=orderRepository.getUserName(number);
		}
			
		Map<String, Object> finalData = new HashMap<>();
		finalData.put("Success", customerName);
		
		return finalData;
		
	}
}
