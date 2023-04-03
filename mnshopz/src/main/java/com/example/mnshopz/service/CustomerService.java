package com.example.mnshopz.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.mnshopz.repository.CustomerRepository;

@Service
public class CustomerService
{
	@Autowired
	CustomerRepository customerRepository;
	
	private static final Logger logger=LoggerFactory.getLogger(CustomerService.class);
	
	public Map<String,Object> setUsers(Map<String,Object> users){
		String name=(String) users.get("cname");
		String num=(String) users.get("cnumber");
		String password=(String) users.get("cpassword");
		String address =(String) users.get("cadderss");
		String type=(String) users.get("c_type");

		 long number=Long.parseLong(num);
		List<Map<String, Object>> result= customerRepository.checkCustomer(number);
		Map<String, Object> userInfo=new HashMap<>();
		
		logger.info("check"+ result);
		if(result.isEmpty())
		{
			customerRepository.setCustomer(address, name, number, password,type);
			userInfo.put("Details", result);
		}
		else {
			userInfo.put("Details", "201");
		}
		return userInfo;
		
	}
	
	public Map<String, Object> verifyUser(Map<String, Object> userLogin) {
		String num=(String) userLogin.get("cnumber");
		String password=(String) userLogin.get("cpassword");
		
		Long number =Long.parseLong(num);
		logger.info("check"+number);
		Map<String, Object> userData = customerRepository.verifyUser(number,password);
		Map<String,Object> result=new HashMap<>();
		if(userData.isEmpty()) {
			
			result.put("status", "300");
		}
		else {					
			result.put("mobilenumber",userData.get("c_number"));
			result.put("type",userData.get("c_type"));
			
		}
		logger.info("check"+result);
		return result;
	}
}
