package com.example.mnshopz.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.mnshopz.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>
{
	@Query(nativeQuery=true, value="select * from customer where c_number=?1")
	public List<Map<String, Object>> checkCustomer(long number);
	
	@Modifying
	@Transactional
	@Query(nativeQuery=true,value="insert into customer( c_address, c_name, c_number, c_password, c_type) values(?1,?2,?3,?4,?5)")
	public void setCustomer(String address,String name, long number, String password, String type);
	
	
	@Query(nativeQuery=true, value="select * from customer where c_number=?1 && c_password=?2")
	public Map<String, Object> verifyUser(Long number, String password);

	
}