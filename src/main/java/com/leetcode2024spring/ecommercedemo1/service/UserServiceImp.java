package com.leetcode2024spring.ecommercedemo1.service;

import com.leetcode2024spring.ecommercedemo1.collection.Product;
import com.leetcode2024spring.ecommercedemo1.collection.User;
import com.leetcode2024spring.ecommercedemo1.repository.UserRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Service
public class UserServiceImp implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String save(User user){
        User savedUser = userRepository.save(user);
        return "save successfully";
    }

    public long count() {
        return userRepository.count();
    }


    @Override
    public User findByEmail(@RequestParam String email) {
        System.out.println(111);
        return userRepository.findByEmail(email);
    }

    @Override
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userRepository.save(user);
        return ResponseEntity.ok(registeredUser);
    }

    @Override
    public boolean loginUser(@RequestParam String email, @RequestParam String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean upsertWishlist(@RequestParam String email, @RequestParam String productStringId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));

        List<String> pIdList = userRepository.findByEmail(email).getWishlist();
        List<String> newlist = new ArrayList<>();
        if(pIdList.contains(productStringId)) return false;
        for(String s: pIdList){
            newlist.add(s);
            System.out.println(s);
        }
        newlist.add(productStringId);

        Update update = new Update();
        update.set("wishlist", newlist); // Replace the entire hobbies array with the new list

        mongoTemplate.updateFirst(query, update, User.class);
        return true;
    }

    @Override
    public boolean updateWishlist(@RequestParam String email, @RequestParam String productStringId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));

        List<String> pIdList = userRepository.findByEmail(email).getWishlist();
        List<String> newlist = new ArrayList<>();
        if(!pIdList.contains(productStringId)) return false;
        for(String s: pIdList){
            newlist.add(s);
            System.out.println(s);
        }
        newlist.remove(productStringId);

        Update update = new Update();
        update.set("wishlist", newlist); // Replace the entire hobbies array with the new list

        mongoTemplate.updateFirst(query, update, User.class);
        return true;
    }

}
