package com.leetcode2024spring.ecommercedemo1.service;

import com.leetcode2024spring.ecommercedemo1.collection.Product;
import com.leetcode2024spring.ecommercedemo1.collection.User;
import com.leetcode2024spring.ecommercedemo1.collection.wlist;
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
        String email = user.getEmail();
        List<User> lst = userRepository.findAll();
        boolean flag = true;
        for (User each: lst){
            if (each.getEmail().equals(email)){
                flag = false;
                break;
            }
        }
        if (flag==false){
            return ResponseEntity.badRequest().build();
        }
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
        List<wlist> pIdList = userRepository.findByEmail(email).getWishlist();
        List<wlist> newlist = new ArrayList<>();
        for(wlist s: pIdList){
            String pid = s.getProductStringId();
            if(pid.equals(productStringId)) return false;
            newlist.add(s);
        }
        newlist.add(new wlist(new Date(), productStringId));

        Update update = new Update();
        update.set("wishlist", newlist); // Replace the entire hobbies array with the new list

        mongoTemplate.updateFirst(query, update, User.class);
        return true;
    }

    @Override
    public boolean updateWishlist(@RequestParam String email, @RequestParam String productStringId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        boolean flag = false;
        List<wlist> pIdList = userRepository.findByEmail(email).getWishlist();
        List<wlist> newlist = new ArrayList<>();
        for(wlist s: pIdList){
            String pid = s.getProductStringId();
            if(pid.equals(productStringId)) flag = true;
            else newlist.add(s);
        }
        if(!flag) return false;
        Update update = new Update();
        update.set("wishlist", newlist); // Replace the entire hobbies array with the new list

        mongoTemplate.updateFirst(query, update, User.class);
        return true;
    }

    public boolean addToWishlist(@RequestParam String email, @RequestParam String productStringId) {
        // Find the user by email
        User user = userRepository.findByEmail(email);
        if (user == null) {
            // Return false or handle the case where user does not exist
            return false;
        }

        List<wlist> wishlist = user.getWishlist();

        // Check if the product is already in the wishlist
        for (wlist item : wishlist) {
            if (item.getProductStringId().equals(productStringId)) {
                // Product is already in the wishlist, return true or handle accordingly
                return true;
            }
        }

        // If not already in the wishlist, add the new product
        wishlist.add(new wlist(new Date(), productStringId));

        // Create an Update object
        Update update = new Update();
        update.set("wishlist", wishlist);  // Set the updated wishlist

        // Create a query object for the update operation
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));

        // Execute the update operation
        mongoTemplate.updateFirst(query, update, User.class);
        return true;
    }

    public boolean removeFromWishlist(@RequestParam String email, @RequestParam String productStringId) {
        // 查找用户
        User user = userRepository.findByEmail(email);
        if (user == null) {
            // 用户不存在，返回 false
            return false;
        }
        System.out.println(111);

        List<wlist> wishlist = user.getWishlist();
        boolean productFound = false; // 标记是否找到产品
        System.out.println(222);

        // 检查产品是否在愿望清单中，并移除
        Iterator<wlist> iterator = wishlist.iterator();
        while (iterator.hasNext()) {
            wlist item = iterator.next();
            if (item.getProductStringId().equals(productStringId)) {
                iterator.remove();  // 使用迭代器安全移除
                productFound = true;
            }
        }
        System.out.println(333);

        // 如果产品未找到，返回 false
        if (!productFound) {
            return false;
        }
        System.out.println(444);

        // 创建更新对象
        Update update = new Update();
        update.set("wishlist", wishlist);  // 设置更新后的愿望清单

        // 创建查询对象
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        System.out.println(555);

        // 执行更新操作
        mongoTemplate.updateFirst(query, update, User.class);
        return true;
    }
}
