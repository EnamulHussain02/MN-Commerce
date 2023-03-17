package com.example.mnshopz.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.mnshopz.entity.Customer;

@Repository
@Component
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	@Transactional
	@Modifying
	@Query(nativeQuery = true,value="insert into customer values(cname,cnumber,cpassowrd,caddress) ")
	 public String setCustomerDetails(@Param("cname")String cname, @Param("cnumber")long cnumber,@Param("cpassword")String cpassword,@Param("caddress")String caddress);

}
