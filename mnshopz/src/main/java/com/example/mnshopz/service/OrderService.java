package com.example.mnshopz.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mnshopz.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public Map<String, Object> orderDetails(){
		
		List<Map<String, Object>> receivedDetails=orderRepository.sendOrderDetails();
		Map<String, Object> finalData= new HashMap<>();
		finalData.put("orders", receivedDetails);
		return finalData;
		
	}
}
