package com.leetcode2024spring.ecommercedemo1.service;

import com.leetcode2024spring.ecommercedemo1.collection.Product;
import com.leetcode2024spring.ecommercedemo1.collection.User;
import com.leetcode2024spring.ecommercedemo1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String save(User user){
        return userRepository.save(user).getFirebase_id();
    }

    @Override
    public User getUser(int userId){
        return userRepository.findUserById(userId);
    }
}
