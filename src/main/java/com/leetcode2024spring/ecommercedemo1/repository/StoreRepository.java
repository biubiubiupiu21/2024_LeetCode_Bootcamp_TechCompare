package com.leetcode2024spring.ecommercedemo1.repository;

import com.leetcode2024spring.ecommercedemo1.collection.Store;
import com.leetcode2024spring.ecommercedemo1.collection.User;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

@Document(collection = "Store")
public interface StoreRepository extends MongoRepository<Store, Integer> {
}
