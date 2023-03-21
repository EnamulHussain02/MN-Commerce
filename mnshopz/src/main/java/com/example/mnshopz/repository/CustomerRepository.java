package com.example.mnshopz.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.mnshopz.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>
{
	@Query(nativeQuery=true, value="select * from customer where c_number=?1")
	public Map<String, Object> checkCustomer(long number);
	
	@Modifying
	@Transactional
	@Query(nativeQuery=true,value="insert into customer( c_address, c_name, c_number, c_password) values(?1,?2,?3,?4)")
	public void setCustomer(String address,String name, long number, String password);

	
}