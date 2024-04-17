package com.leetcode2024spring.ecommercedemo1.dataload;

import com.leetcode2024spring.ecommercedemo1.collection.User;
import com.leetcode2024spring.ecommercedemo1.collection.wlist;
import com.leetcode2024spring.ecommercedemo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.ArrayList;

import java.util.List;

@Component
public class UserDataLoader implements CommandLineRunner {

    @Autowired
    private UserService userService;

    private void loadUserData() {
        List<wlist> u1 = new ArrayList<>();
        List<wlist> u2 = new ArrayList<>();
        List<wlist> u3 = new ArrayList<>();
        u1.add(new wlist(new Date(), "2"));
        u1.add(new wlist(new Date(),"7"));
        u2.add(new wlist(new Date(), "19"));
        u2.add(new wlist(new Date(),"13"));
        u3.add(new wlist(new Date(),"1"));
        u3.add(new wlist(new Date(),"5"));
        User user1 = new User("firebaseone", "user123@example.com", "qwertyui234567",
                u1);
        userService.save(user1);

        User user2 = new User("firebaseone", "user456@example.com", "2345tghjopl",
                u2);
        userService.save(user2);

        User user3 = new User("firebaseone", "user789@example.com", "65esxcvhj",
               u3);
        userService.save(user3);

        System.out.println("Loaded users...");
    }

    @Override
    public void run(String... args) throws Exception {

        long userCount = userService.count();

        if (userCount == 0) {
            loadUserData();
            System.out.println("Loaded users...");
        }
        else{
            System.out.println("Already" + userCount + " users loaded!");
        }
    }
}

