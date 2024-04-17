package com.leetcode2024spring.ecommercedemo1.controller;

import com.leetcode2024spring.ecommercedemo1.collection.Product;
import com.leetcode2024spring.ecommercedemo1.collection.User;
import com.leetcode2024spring.ecommercedemo1.service.ProductServiceImp;
import com.leetcode2024spring.ecommercedemo1.service.UserService;
import com.leetcode2024spring.ecommercedemo1.service.UserServiceImp;
import com.leetcode2024spring.ecommercedemo1.util.JwtTokenUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImp userService;
    @Autowired
    private ProductServiceImp productService;


    @GetMapping("/getUser")
    public User findByEmail(String email){
        return userService.findByEmail(email);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        boolean loginSuccess = userService.loginUser(user.getEmail(), user.getPassword());
        if (loginSuccess) {
            JwtTokenUtil jwt = new JwtTokenUtil();
            String token = jwt.generateToken(user.getEmail());

            // 将 Token 放在响应头部中返回给客户端
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + token);

            return ResponseEntity.ok()
                    .headers(headers)
                    .body("Login successful");
        } else {
            return ResponseEntity.badRequest().body("Login failed");
        }
    }



    @GetMapping("/getWishlist")
    public List<Product> getWishlist(String email){
        List<String> pIdList = userService.findByEmail(email).getWishlist();
        List<Product> res = new LinkedList<>();
        for(String s : pIdList){
            Product pro = productService.getByProductStringId(s);
            res.add(pro);
        }
        return res;
    }



    @PostMapping("/addProductToWishlist")
    public ResponseEntity<Boolean> upsertWishlist(String email, String productStringId){
        boolean addSuccess = userService.upsertWishlist(email, productStringId);
        return ResponseEntity.ok(addSuccess);
    }

    @PostMapping("/deleteProductFromWishlist")
    public ResponseEntity<Boolean> updateWishlist(String email, String productStringId){
        boolean addSuccess = userService.updateWishlist(email, productStringId);
        return ResponseEntity.ok(addSuccess);
    }

    @GetMapping("/home")
    public String home() {
        return "home.html"; // 返回html文件的名称，Spring Boot会自动查找位于resources/static或resources/templates目录下的HTML文件
    }
}
