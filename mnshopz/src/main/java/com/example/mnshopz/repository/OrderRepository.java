package com.example.mnshopz.repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.mnshopz.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long>{

	@Query(nativeQuery=true, value= " select orders.o_id, orders.payment_date, orders.total, products.prodDesc1, products.prodTitel, products.product_image\r\n"
			+ " from orders \r\n"
			+ " inner join products on orders.product_detail_id = products.product_id "
			+ "where orders.customer_number=?1")
	public List<Map<String,Object>> sendOrderDetails(Long customerNumber);
	
	@Query(nativeQuery=true, value="select customer.c_name from orders "
			+ "inner join customer on orders.customer_number= customer.c_number "
			+ "where orders.customer_number=?1")
	public List<Map<String, Object>> getUserName(Long customerNumber);	
	
	@Transactional
	@Modifying
	@Query(nativeQuery=true, value= "insert into orders ( payment_via, payment_date, customer_number, product_detail_id, total) values( ?1, ?2, ?3, ?4, ?5)")
	public int setOrders(String payVia, Date payDate,Long customerNumber, Long productId, int total );
}
