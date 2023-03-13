package com.example.mnshopz.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.mnshopz.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long>
{
	   
	
	
}
