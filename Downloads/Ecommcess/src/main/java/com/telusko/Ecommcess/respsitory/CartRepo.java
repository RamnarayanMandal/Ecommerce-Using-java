package com.telusko.Ecommcess.respsitory;

import com.telusko.Ecommcess.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface CartRepo extends JpaRepository<Cart, Integer> {

    List<Cart> findByuserId(int userId);
}
