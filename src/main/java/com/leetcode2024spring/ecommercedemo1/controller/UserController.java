package com.leetcode2024spring.ecommercedemo1.controller;

import com.leetcode2024spring.ecommercedemo1.collection.User;
import com.leetcode2024spring.ecommercedemo1.service.UserService;
import com.leetcode2024spring.ecommercedemo1.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserServiceImp userService;

//    @GetMapping("/getUser")
//    public int get(){
//        return 123;
//    }
//
//    @PostMapping("/addUser")
//    public String save(@RequestBody User user1){
//        return userService.save(user1);
//    }

    @GetMapping("/getUser")
    public User findByEmail(String email){
        return userService.findByEmail(email);
    }

    @PostMapping("/addUser")
    public String save(@RequestBody User user1){
        return userService.save(user1);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody User user) {
        boolean loginSuccess = userService.loginUser(user.getEmail(), user.getPassword());
        return ResponseEntity.ok(loginSuccess);
    }

}
