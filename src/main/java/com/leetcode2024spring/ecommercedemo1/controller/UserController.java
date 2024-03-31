package com.leetcode2024spring.ecommercedemo1.controller;

import com.leetcode2024spring.ecommercedemo1.collection.User;
import com.leetcode2024spring.ecommercedemo1.service.UserService;
import com.leetcode2024spring.ecommercedemo1.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserServiceImp userService;

    @GetMapping("/getUser")
    public int get(){
        return 123;
    }

    @PostMapping("/addUser")
    public String save(@RequestBody User user1){
        return userService.save(user1);
    }

}
