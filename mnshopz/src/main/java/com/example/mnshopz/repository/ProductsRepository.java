package com.example.mnshopz.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.mnshopz.entity.Products;


@Repository
public interface ProductsRepository extends JpaRepository<Products, String>
{
	
//	  @Query(value="SELECT * FROM mn_commerce.products; ",nativeQuery = true)//Works
//	  public List<Products> getProductDetails();
	     
	
}
