package com.leetcode2024spring.ecommercedemo1.service;

import com.leetcode2024spring.ecommercedemo1.collection.Product;
import com.leetcode2024spring.ecommercedemo1.collection.User;
import java.util.*;

public interface UserService {


    String save(User user);

    User getUser(int userId);
}
