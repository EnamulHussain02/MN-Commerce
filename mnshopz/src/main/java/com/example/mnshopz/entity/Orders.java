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
	private Long o_id;
	
	public Long getO_id() {
		return o_id;
	}

	public void setO_id(Long o_id) {
		this.o_id = o_id;
	}

	public void setProduct_detail_id(Long product_detail_id) {
		this.product_detail_id = product_detail_id;
	}

	@Column(name="payment_via")
	private String payment_via;
	
	@Column(name="payment_date")
	private String payment_date;
	
	@Column(name="customer_number")
	private Long customer_number;
	
	@Column(name="product_detail_id")
	private Long product_detail_id;
	
	@Column(name="total")
	private int total;
	
	
	public Orders() {
		
	}
	
	public Orders(Long o_id, String payment_via, String payment_date, long customer_number, long product_detail_id,
			int total) {
		super();
		this.o_id = o_id;
		this.payment_via = payment_via;
		this.payment_date = payment_date;
		this.customer_number = customer_number;
		this.product_detail_id = product_detail_id;
		this.total = total;
	}

	public String getPayment_via() {
		return payment_via;
	}

	public void setPayment_via(String payment_via) {
		this.payment_via = payment_via;
	}

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public long getCustomer_number() {
		return customer_number;
	}

	public void setCustomer_number(Long customer_number) {
		this.customer_number = customer_number;
	}

	public long getProduct_detail_id() {
		return product_detail_id;
	}

	public void setProduct_detail_id(long product_detail_id) {
		this.product_detail_id = product_detail_id;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	
}
