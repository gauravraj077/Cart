package com.ecommerce.cart.repository;

import com.ecommerce.cart.model.Cart;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	
	 @Query("SELECT p FROM Cart p WHERE p.productName LIKE %?1%")
	 public List<Cart> findByProductName(String productName);

	public List<Cart> findByProductDescription(String productDescription);
	
	// @Query("update ecommerce.cart set quantity=?1,lastModifiedDate=?2 where productName=?3")
	// public List<Cart> updateProductQuantity(String quantity,Date lastModifiedDate ,String productName);

	public List<Cart> findByQuantity(int quantity);

	public List<Cart> findByCreatedDate(Date createdDate);

	public List<Cart> findByLastModifiedDate(Date lastModifiedDate);

	
	
	
}
