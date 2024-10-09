package com.telusko.Ecommcess.controller;

import com.telusko.Ecommcess.model.User;
import com.telusko.Ecommcess.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController  // This replaces @Controller and makes it return JSON
public class UserController {

    @Autowired
    UserService userServices;
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userServices.getAlluser();

        if (users.isEmpty()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);  // This will automatically return users as JSON
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        User user = userServices.getUserById(id);
        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);  // Automatically convert to JSON
    }

    @GetMapping("/user/email/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        User user = userServices.getUserByEmail(email);
        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);  // Automatically convert to JSON
    }

    @GetMapping("/user/phone/{phone}")
    public ResponseEntity<?> getUserByPhone(@PathVariable String phone) {
        User user = userServices.getUserbyPhone(phone);
        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);  // Automatically convert to JSON
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            User newUser = userServices.createUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);  // Automatically convert to JSON
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User user) {
        User Updateuser = userService.updateUserby(id,user);
        if (Updateuser == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Updateuser, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        User user = userServices.deleteUser(id);
        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
