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
	private Long cId;
	
	@Column(name="c_Name")
	private String cName; 
	
	@Column(name="c_Number")
	private long cNumber;
	
	@Column(name="c_Address")
	private String cAddress;
	
	public Customer()
	{
		
	}
	public Customer(long cId, String cName, long cNumber, String cAddress) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cNumber = cNumber;
		this.cAddress = cAddress;
	}
	public long getcId() {
		return cId;
	}
	public void setcId(long cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public long getcNumber() {
		return cNumber;
	}
	public void setcNumber(long cNumber) {
		this.cNumber = cNumber;
	}
	public String getcAddress() {
		return cAddress;
	}
	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}
	
}
