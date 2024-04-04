package com.leetcode2024spring.ecommercedemo1.repository;

import com.leetcode2024spring.ecommercedemo1.collection.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    User findByEmail(String email);

}
