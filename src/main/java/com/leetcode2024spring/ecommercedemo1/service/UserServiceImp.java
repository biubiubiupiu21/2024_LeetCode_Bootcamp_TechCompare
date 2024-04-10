package com.leetcode2024spring.ecommercedemo1.service;

import com.leetcode2024spring.ecommercedemo1.collection.Product;
import com.leetcode2024spring.ecommercedemo1.collection.User;
import com.leetcode2024spring.ecommercedemo1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public class UserServiceImp implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public String save(User user){
        User savedUser = userRepository.save(user);
        return "save successfully";
    }

    public long count() {
        return userRepository.count();
    }


    @Override
    public User findByEmail(String email) {
        System.out.println(111);
        return userRepository.findByEmail(email);
    }

    @Override
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userRepository.save(user);
        return ResponseEntity.ok(registeredUser);
    }

    @Override
    public boolean loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }


}
