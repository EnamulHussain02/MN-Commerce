package com.example.mnshopz.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.mnshopz.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders,Long>{

	@Query(nativeQuery=true, value= " select orders.o_id, orders.payment_date, orders.total, products.product_description, products.product_name, products.product_image\r\n"
			+ " from orders \r\n"
			+ " inner join products on orders.product_detail_id = products.product_id ; ")
	public List<Map<String,Object>> sendOrderDetails();
}
