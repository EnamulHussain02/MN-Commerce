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
	
	public Map<String, Object> setProducts(Map<String,Object> products){
		String productImage=(String) products.get("product_image");
		String productColor=(String) products.get("product_color");
		String productType=(String) products.get("product_type");
		String productDiscount =(String) products.get("product_discount");
		String productBarcode =(String) products.get("product_barcode");
		String productDescription1 =(String) products.get("prod_desc1");
		String productDescription2 =(String) products.get("prod_desc2");
		String productDescription3 =(String) products.get("prod_desc3");
		String productDescription4 =(String) products.get("prod_desc4");
		String productName =(String) products.get("product_name");
		String productPrice =(String) products.get("product_price");
		String productQuantity =(String) products.get("product_quantity");		

		String productDescription =productName;
		String prodTitel=productName;	
		int discount=Integer.parseInt(productDiscount);
		int barcode=Integer.parseInt(productBarcode);
		int price=Integer.parseInt(productPrice);
		int quantity=Integer.parseInt(productQuantity);
		int starRatting=4;
		
		int data=productsRepository.saveProduct(productImage,productColor,productType,discount,barcode,productDescription,productName,price,quantity,starRatting, productDescription1, productDescription2, productDescription3, productDescription4,prodTitel);
		Map<String, Object> result=new HashMap<>();
		if(data==1) {
			result.put("Success", 200);
		}		
		return result;		
	}
	
	public Map<String, Object> getProduct(Map<String, Object> products)
	{
		String prodId=(String) products.get("prodId");
		Long productId=Long.valueOf(prodId);
		logger.info(prodId);
		List<Map<String,Object>> resultProducts=productsRepository.getProductDetail(productId);
		Map<String, Object> result= new HashMap<>();
		result.put("product", resultProducts);
		logger.info("product"+result);
		return result;
	}

}
