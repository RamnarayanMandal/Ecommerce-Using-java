package com.telusko.Ecommcess.respsitory;

import com.telusko.Ecommcess.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserResp extends JpaRepository<User, Integer> {
    User findByEmail(String email);


    User findByPhone(String phone);
}
