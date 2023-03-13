package com.example.mnshopz.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.mnshopz.entity.Customer;
import com.example.mnshopz.repository.CustomerRepository;


@Service
@Component
public class CustomerServiceImpl {

	@Autowired
	CustomerRepository customerRepository;

	public Object getAllCustomer() {
		
		return null;
	}
	

}
