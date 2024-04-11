package com.leetcode2024spring.ecommercedemo1.repository;

import com.leetcode2024spring.ecommercedemo1.collection.Product;
import com.leetcode2024spring.ecommercedemo1.collection.Review;
import com.leetcode2024spring.ecommercedemo1.collection.User;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

@Document(collection = "Products")
public interface ProductRepository extends MongoRepository<Product,String> {
    Product findByProductStringId(String productStringId);

    List<Product> findByCategory(String category);

    List<Product> findByBrand(String brand);

    List<Product> findByProductNameMatches(String regex);


    List<Review> findByReview(String productStringId);

}
