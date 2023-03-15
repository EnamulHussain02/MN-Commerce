package com.example.mnshopz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="products")
public class Products {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_Id")
	private Long pId;
	
	@Column(name="product_Name")
	private String pName;
	
	@Column(name="product_Description")
	private String pDescription;
	
	@Column(name="product_Price")
	private double pPrice;
	
	@Column(name="product_Status")
	private String pStatus;
	
	@Column(name="product_Barcode")
	private long pBarcode;
	
	@Column(name="product_Quantity")
	private int pQuantity;
	
	@Column(name="product_image")
	private String pImage;
	
	@Column(name="product_starratting")
	private String p_Starratting;
	
	@Column(name="product_color")
	private String p_color;
	
	@Column(name="product_type")
	private String p_Type;
	
	@Column(name="product_discount")
	private double p_discount;
	
	@Override
	public String toString() {
		return "Products [pId=" + pId + ", pName=" + pName + ", pDescription=" + pDescription + ", pPrice=" + pPrice
				+ ", pStatus=" + pStatus + ", pBarcode=" + pBarcode + ", pQuantity=" + pQuantity + ", pImage=" + pImage
				+ ", p_Starratting=" + p_Starratting + ", p_color=" + p_color + ", p_Type=" + p_Type + ", p_discount="
				+ p_discount + "]";
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	public double getpPrice() {
		return pPrice;
	}

	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}

	public String getpStatus() {
		return pStatus;
	}

	public void setpStatus(String pStatus) {
		this.pStatus = pStatus;
	}

	public long getpBarcode() {
		return pBarcode;
	}

	public void setpBarcode(long pBarcode) {
		this.pBarcode = pBarcode;
	}

	public int getpQuantity() {
		return pQuantity;
	}

	public void setpQuantity(int pQuantity) {
		this.pQuantity = pQuantity;
	}

	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}

	public String getP_Starratting() {
		return p_Starratting;
	}

	public void setP_Starratting(String p_Starratting) {
		this.p_Starratting = p_Starratting;
	}

	public String getP_color() {
		return p_color;
	}

	public void setP_color(String p_color) {
		this.p_color = p_color;
	}

	public String getP_Type() {
		return p_Type;
	}

	public void setP_Type(String p_Type) {
		this.p_Type = p_Type;
	}

	public double getP_discount() {
		return p_discount;
	}

	public void setP_discount(double p_discount) {
		this.p_discount = p_discount;
	}
	
}
