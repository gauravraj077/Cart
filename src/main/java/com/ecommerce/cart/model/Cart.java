package com.ecommerce.cart.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "cart")
public class Cart {

	@Column(name = "Id")
	private int id;

	@Column(name = "cartId")
	private String cartId;

	@Column(columnDefinition = "varchar(255) default 'Not Null'")
	private String productName;

	@Column(columnDefinition = "double(25) default 'Not Null'")
	private Double productPrice;

	@Column(columnDefinition = "varchar(255) default 'Not Null'")
	private String productDescription;

	@Column(name = "quantity")
	private int quantity;

	@CreatedDate
	@Column(name = "created_date")
	private Date createdDate;

	@LastModifiedDate
	@Column(name = "last_modified_date")
	private Date lastModifiedDate;

	public Cart() {
		this.cartId = UUID.randomUUID().toString();
		//if(this.createdDate ==null){
		  //   this.createdDate = new Date();}
	}

	public Cart(String productName, Double productPrice, String productDescription, String productCategory,
			Date lastModifiedDate, int quantity, Date createdDate) {
		super();
		this.cartId = UUID.randomUUID().toString();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.lastModifiedDate = lastModifiedDate;
		this.createdDate = createdDate;

	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getCartId() {
		if (this.cartId == null)
			return UUID.randomUUID().toString();

		return this.cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Date getCreatedDate() {
	

		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
