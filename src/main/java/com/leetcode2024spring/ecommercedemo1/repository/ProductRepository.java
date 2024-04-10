package com.leetcode2024spring.ecommercedemo1.repository;

import com.leetcode2024spring.ecommercedemo1.collection.Product;
import com.leetcode2024spring.ecommercedemo1.collection.User;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

@Document(collection = "Product")
public interface ProductRepository extends MongoRepository<Product,String> {
    Product findByproductStringId(String productStringId);
}
