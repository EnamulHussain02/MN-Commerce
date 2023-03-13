package com.example.mnshopz.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.mnshopz.entity.Products;
import com.example.mnshopz.repository.ProductsRepository;


@Service
@Component
public class ProductsServiceImpl{

	@Autowired
	 private ProductsRepository productsRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductsServiceImpl.class);

	
	public Map<String, Object> getAllProducts() {
		Map<String, Object> products=new HashMap<>();
		try{
			List<Products> allProducts=productsRepository.findAll();
		    products.put("Products", allProducts);
		}catch(Exception e){
			
		}
		return products;
	}
	
//	public Map<String, Map> get



}
