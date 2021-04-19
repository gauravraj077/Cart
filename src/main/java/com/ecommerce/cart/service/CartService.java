package com.ecommerce.cart.service;

import com.ecommerce.cart.model.Cart;
import com.ecommerce.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.Date;
import java.util.List;
@Service
@Transactional
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    public List<Cart> listAllProduct() {
        return cartRepository.findAll();
    }

    public void saveProduct(Cart Cart) {
    	cartRepository.save(Cart);
    }

    public Cart getProduct(Integer productId) {
        return cartRepository.findById(productId).get();
    }
    
    public List<Cart> getProductByName(String productName) {
        return cartRepository.findByProductName(productName);
    }
    
    public List<Cart> getProductByDescription(String productDescription) {
        return cartRepository.findByProductDescription(productDescription);
    }
    
    
    public List<Cart> getProductByQuantity(int quantity) {
        return cartRepository.findByQuantity(quantity);
    }
    public List<Cart> getProductByCreatedDate(Date createdDate) {
        return cartRepository.findByCreatedDate(createdDate);
    }
    public List<Cart> getProductBylastModifiedDate(Date lastModifiedDate) {
        return cartRepository.findByLastModifiedDate(lastModifiedDate);
    }
    public void deleteProduct(Integer productId) {
    	cartRepository.deleteById(productId);
    }
}
