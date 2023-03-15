package com.example.mnshopz.repository;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.mnshopz.entity.Products;


@Repository
@Component
public interface ProductsRepository extends JpaRepository<Products, Long>
{
	
	  @Query(nativeQuery = true,value="Select * from products where product_id=111 ")
	  public List<Map<String,Object>> getProductDetails();
     
	
}
