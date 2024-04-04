package com.leetcode2024spring.ecommercedemo1.dataload;

import com.leetcode2024spring.ecommercedemo1.collection.User;
import com.leetcode2024spring.ecommercedemo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDataLoader implements CommandLineRunner {

    @Autowired
    private UserService userService;

    private void loadUserData() {
        User user1 = new User("firebaseone", "user123@example.com", "qwertyui234567",
                new String[]{"6607a4070a643e317ddb8ef1","6607a4070a643e317ddb8ef0"});
        userService.save(user1);

        User user2 = new User("firebaseone", "user456@example.com", "2345tghjopl",
                new String[]{"6607a4070a643e317ddb8eeb", "6607a4070a643e317ddb8eec"});
        userService.save(user2);

        User user3 = new User("firebaseone", "user789@example.com", "65esxcvhj",
                new String[]{"6607a4070a643e317ddb8ef5", "6607a4070a643e317ddb8ef9"});
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
            System.out.println("Already" + userCount + "users loaded!");
        }
    }
}

