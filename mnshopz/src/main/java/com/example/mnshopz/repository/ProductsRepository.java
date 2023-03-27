package com.example.mnshopz.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.mnshopz.entity.Products;

public interface ProductsRepository extends JpaRepository<Products,Long>
{
	
	  @Query(nativeQuery = true,value="Select * from products ")
	  public List<Map<String,Object>> getProductDetails();

	  @Modifying
	  @Transactional
	  @Query(nativeQuery=true, value = "insert into products( product_image, product_color, product_type, product_discount, product_barcode, product_description, product_name, product_price, product_quantity) "
	  		+ "values(?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9)")
	  public void saveProduct(String productImage, String productColor, String productType, int discount, int barcode,
			String productDescription, String productName, int price, int quantity);
     
	
}
