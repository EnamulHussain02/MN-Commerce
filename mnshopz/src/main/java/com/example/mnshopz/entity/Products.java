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
@Table(name="products")
public class Products {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_Id")
	private Long product_Id;
	
	@Column(name="product_Name")
	private String product_Name;
	
	@Column(name="product_Description")
	private String product_Description;
	
	@Column(name="product_Price")
	private double product_Price;
	
	@Column(name="product_Status")
	private String product_Status;
	
	@Column(name="product_Barcode")
	private long product_Barcode;
	
	@Column(name="product_Quantity")
	private int product_Quantity;
	
	@Column(name="product_image")
	private String product_image;
	
	@Column(name="product_starratting")
	private String product_starratting;
	
	@Column(name="product_color")
	private String product_color;
	
	@Column(name="product_type")
	private String product_type;
	
	@Column(name="product_discount")
	private double product_discount;
	
	@Column(name="prod_desc1")
	private String prodDesc1;
	
	@Column(name="prod_desc2")
	private String prodDesc2;
	
	@Column(name="prod_desc3")
	private String prodDesc3;
	
	@Column(name="prod_desc4")
	private String prodDesc4;
	
	@Column(name="image1")
	private String image1;
	
	@Column(name="image2")
	private String image2;
	
	@Column(name="image3")
	private String image3;
	
	@Column(name="image4")
	private String image4;
	
	@Column(name="prodTitel")
	private String prodTitel;

	public String getProdDesc1() {
		return prodDesc1;
	}

	public void setProdDesc1(String prodDesc1) {
		this.prodDesc1 = prodDesc1;
	}

	public String getProdDesc2() {
		return prodDesc2;
	}

	public void setProdDesc2(String prodDesc2) {
		this.prodDesc2 = prodDesc2;
	}

	public String getProdDesc3() {
		return prodDesc3;
	}

	public void setProdDesc3(String prodDesc3) {
		this.prodDesc3 = prodDesc3;
	}

	public String getProdDesc4() {
		return prodDesc4;
	}

	public void setProdDesc4(String prodDesc4) {
		this.prodDesc4 = prodDesc4;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	public String getProdTitel() {
		return prodTitel;
	}

	public void setProdTitel(String prodTitel) {
		this.prodTitel = prodTitel;
	}

	public Long getProduct_Id() {
		return product_Id;
	}

	public void setProduct_Id(Long product_Id) {
		this.product_Id = product_Id;
	}

	public String getProduct_Name() {
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	public String getProduct_Description() {
		return product_Description;
	}

	public void setProduct_Description(String product_Description) {
		this.product_Description = product_Description;
	}

	public double getProduct_Price() {
		return product_Price;
	}

	public void setProduct_Price(double product_Price) {
		this.product_Price = product_Price;
	}

	public String getProduct_Status() {
		return product_Status;
	}

	public void setProduct_Status(String product_Status) {
		this.product_Status = product_Status;
	}

	public long getProduct_Barcode() {
		return product_Barcode;
	}

	public void setProduct_Barcode(long product_Barcode) {
		this.product_Barcode = product_Barcode;
	}

	public int getProduct_Quantity() {
		return product_Quantity;
	}

	public void setProduct_Quantity(int product_Quantity) {
		this.product_Quantity = product_Quantity;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public String getProduct_starratting() {
		return product_starratting;
	}

	public void setProduct_starratting(String product_starratting) {
		this.product_starratting = product_starratting;
	}

	public String getProduct_color() {
		return product_color;
	}

	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public double getProduct_discount() {
		return product_discount;
	}

	public void setProduct_discount(double product_discount) {
		this.product_discount = product_discount;
	}	
}
