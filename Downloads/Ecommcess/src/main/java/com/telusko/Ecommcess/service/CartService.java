package com.telusko.Ecommcess.service;

import com.telusko.Ecommcess.model.Cart;
import com.telusko.Ecommcess.respsitory.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepo cartRepo;

    public List<Cart> getAllCart() {
        return cartRepo.findAll();
    }

    public List<Cart> getAllItemsByUserId(String userId) {
        return cartRepo.findByuserId(Integer.parseInt(userId));
    }

    public Cart getCartById(String id) {
        return  cartRepo.findById(Integer.parseInt(id)).orElse(null);
    }

    public Cart addcart(Cart cart) {
        return cartRepo.save(cart);
    }
}
