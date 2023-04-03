package com.example.mnshopz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.stereotype.Component;



@Entity
@Table(name="customer")
@Component

@NamedQuery(name = "Customer", query = "SELECT u FROM Customer u")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long c_id;
	
	@Column(name="c_address")
	private String c_address; 
	
	@Column(name ="c_name")
	private String c_name;
	
	@Column(name="c_number")
	private Long c_number; 
	
	@Column(name="c_password")
	private String c_password;
	
	@Column(name="c_type")
	private String c_type;

	public String getC_password() {
		return c_password;
	}

	public void setC_password(String c_password) {
		this.c_password = c_password;
	}

	public String getC_type() {
		return c_type;
	}

	public void setC_type(String c_type) {
		this.c_type = c_type;
	}

	public Long getC_id() {
		return c_id;
	}

	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}

	public String getC_address() {
		return c_address;
	}

	public void setC_address(String c_address) {
		this.c_address = c_address;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public Long getC_number() {
		return c_number;
	}

	public void setC_number(Long c_number) {
		this.c_number = c_number;
	}

	
	
	
}
