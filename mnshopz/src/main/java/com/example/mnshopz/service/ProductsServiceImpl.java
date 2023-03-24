package com.example.mnshopz.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mnshopz.entity.Products;
import com.example.mnshopz.repository.ProductsRepository;


@Service
public class ProductsServiceImpl{

	@Autowired
	ProductsRepository productsRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductsServiceImpl.class);

	
	public Map<String, Object> getAllProducts() {
		List<Map<String, Object>> allProducts=productsRepository.getProductDetails();
		Map<String,Object> resultData= new HashMap<>();
		resultData.put("products", allProducts);
		    return resultData;
	}
	

}
