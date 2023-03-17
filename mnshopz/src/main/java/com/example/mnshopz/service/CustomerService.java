package com.example.mnshopz.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mnshopz.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	public void saveCustomer(Map<String, Object> customer) {
		String name =(String) customer.get("cname");
		String num=(String) customer.get("cnumber");
		String password =(String) customer.get("cpassword");
		String address =(String) customer.get("caddress");
		
		long number=Long.parseLong(num);
		
		customerRepository.setCustomerDetails(name, number, password, address);
		
		
	}
	
	
	}
