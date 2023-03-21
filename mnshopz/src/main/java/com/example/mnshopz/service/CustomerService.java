package com.example.mnshopz.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mnshopz.repository.CustomerRepository;

@Service
public class CustomerService
{
	@Autowired
	CustomerRepository customerRepository;
	
	
	
	private static final Logger logger=LoggerFactory.getLogger(CustomerService.class);
	
	public String setUsers(Map<String,Object> users){
		String name=(String) users.get("cname");
		String num=(String) users.get("cnumber");
		String password=(String) users.get("cpassword");
		String address =(String) users.get("cadderss");

		 long number=Long.parseLong(num);
		Map<String, Object> result= customerRepository.checkCustomer(number);
		customerRepository.setCustomer(address, name, number, password);
		logger.info("check" + number);
//		if(result.isEmpty())
//		{
//			
//			
//			return "Registred Successfully";
//		}
//		else {
//			return "Already Existing User";
//		}
		return "Already Existing User";
	}
}
