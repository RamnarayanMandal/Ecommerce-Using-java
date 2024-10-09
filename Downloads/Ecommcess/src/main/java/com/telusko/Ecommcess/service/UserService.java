package com.telusko.Ecommcess.service;

import com.telusko.Ecommcess.model.User;
import com.telusko.Ecommcess.respsitory.UserResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserResp userResp;

    public List<User> getAlluser() {
        return userResp.findAll();
    }

    public User getUserById(int id) {
        return userResp.findById(id).orElse(null);
    }

    public User getUserByEmail(String email) {
        return userResp.findByEmail(email);
    }

    public User getUserbyPhone(String phone) {
        return userResp.findByPhone(phone);
    }

    public User createUser(User user) {
        // Check if the email already exists
        if (getUserByEmail(user.getEmail()) != null) {
            System.out.println(user.getEmail());
            throw new IllegalArgumentException("Email already exists");
        }

        // Check if the phone already exists
        if (getUserbyPhone(user.getPhone()) != null) {
            System.out.println(user.getPhone());
            throw new IllegalArgumentException("Phone number already exists");
        }

        return userResp.save(user);
    }


    public User updateUserby(int id, User user) {
        Optional<User> existingUserOpt = userResp.findById(id);

        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();
            // Update the necessary fields
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setAddress(user.getAddress());
            existingUser.setPhone(user.getPhone());
            existingUser.setPassword(user.getPassword());

            // Save the updated user back to the repository
            return userResp.save(existingUser);
        } else {
            return null; // or throw an exception if user not found
        }
    }

    public User deleteUser(int id) {
        Optional<User> existingUserOpt = userResp.findById(id);
        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();
            userResp.delete(existingUser);
            return existingUser;
        }
        return null;
    }


}
