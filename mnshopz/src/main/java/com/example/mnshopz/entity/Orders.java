package com.example.mnshopz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="orders")
public class Orders {

			
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="o_id")
	private Long o_id;
	
	@Column(name="payment_via")
	private String payment_via;
	
	@Column(name="payment_date")
	private String payment_date;
	
	@Column(name="customer_detail_id")
	private long customer_detail_id;
	
	@Column(name="product_detail_id")
	private long product_detail_id;
	
	@Column(name="total")
	private int total;
}
