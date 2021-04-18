package com.ecommerce.cart.controller;

import com.ecommerce.cart.model.Cart;
import com.ecommerce.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/cart")
public class CartController {
	
    @Autowired
    CartService cartService;

    @GetMapping("")
    public List<Cart> list() {
        return cartService.listAllProduct();
    }

    @GetMapping("/getCartProduct/{id}")
    public ResponseEntity<Cart> get(@PathVariable Integer id) {
        try {
            Cart cart = cartService.getProduct(id);
            return new ResponseEntity<Cart>(cart, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/getCartProductByName/{productName}")
    public ResponseEntity<String> get(@PathVariable String productName) {
        try {
            List<Cart> cart = cartService.getProductByName(productName);
            System.out.println("o/p: " + cart.get(0).getProductPrice());
            return new ResponseEntity<String>( cart.toString(),HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
        	System.out.println("Exception raised: " + e);
            return new ResponseEntity<String>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
    
    @PostMapping("/insertCart")
    public void add(@RequestBody Cart Cart) {
        cartService.saveProduct(Cart);
    }
    @PutMapping("/updateCartById/{productId}")
    public ResponseEntity<?> update(@RequestBody Cart Cart, @PathVariable Integer productId) {
        try {
            Cart existProduct = cartService.getProduct(productId);
            Cart.setid(productId);
            cartService.saveProduct(Cart);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/updateCartByProductName/{productName}")
    public ResponseEntity<?> updateProductByName(@RequestBody Cart Cart, @PathVariable String productName) {
        try {
            
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/deleteCartProductById/{id}")
    public void delete(@PathVariable Integer id) {

        cartService.deleteProduct(id);
    }
}
