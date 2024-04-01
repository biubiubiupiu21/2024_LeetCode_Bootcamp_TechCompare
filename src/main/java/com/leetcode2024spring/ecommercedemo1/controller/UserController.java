package com.leetcode2024spring.ecommercedemo1.controller;

import com.leetcode2024spring.ecommercedemo1.collection.Product;
import com.leetcode2024spring.ecommercedemo1.collection.User;
import com.leetcode2024spring.ecommercedemo1.service.ProductServiceImp;
import com.leetcode2024spring.ecommercedemo1.service.UserService;
import com.leetcode2024spring.ecommercedemo1.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserServiceImp userService;
    private ProductServiceImp productService;

    @GetMapping("/getUser")
    public int get(){
        return 123;
    }

    @PostMapping("/addUser")
    public String save(@RequestBody User user1){
        return userService.save(user1);
    }

    @GetMapping("/getWishlist")
    public List<Product> getWishlist(@RequestBody int user_id){
        User currUser =  userService.getUser(user_id);
        int[] wishlist = currUser.getWishlist();
        List<Product> res = new LinkedList<>();
        for(int product_id: wishlist){
            Product curr = productService.findProductById(product_id);
            res.add(curr);
        }
        return res;
    }

}
