package com.telusko.Ecommcess.controller;

import com.telusko.Ecommcess.model.Cart;
import com.telusko.Ecommcess.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CartContoller {
    @Autowired
    CartService cartService;

    @GetMapping("/cart")
    public ResponseEntity<?> getAllCart() {
         List<Cart> carts = cartService.getAllCart();
         if (carts== null) {
             return new ResponseEntity <>(" cart is not found " , HttpStatus.NOT_FOUND);

         }
         return new ResponseEntity<>("cart is fetch successfully "+ carts , HttpStatus.OK);
    }

    @GetMapping("/cart/{userId}")
    public  ResponseEntity<?>getCart(@PathVariable String userId) {
        List<Cart> carts = cartService.getAllItemsByUserId(userId);
        if (carts == null) {
            return new ResponseEntity <>(" cart is not found " , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("cart is fetch successfully "+ carts , HttpStatus.OK);
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<?> getCartById(@PathVariable String id) {
            Cart cart = cartService.getCartById(id);
            if (cart == null) {
                return new ResponseEntity <>(" cart is not found " , HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("cart is fetch successfully "+ cart , HttpStatus.OK);
    }

    @PostMapping("/cart")
    public ResponseEntity<?> addCart(@RequestBody Cart cart) {
        Cart carts= cartService.addcart(cart);
        if (carts == null) {
            return new ResponseEntity <>("something worng while crating cart " , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("cart is created successfully "+ carts , HttpStatus.OK);
    }







}
