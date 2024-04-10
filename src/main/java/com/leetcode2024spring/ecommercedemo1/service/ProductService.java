package com.leetcode2024spring.ecommercedemo1.service;

import com.leetcode2024spring.ecommercedemo1.collection.Product;
import com.leetcode2024spring.ecommercedemo1.repository.ProductRepository;


public interface ProductService {
    String compareProductsByPrice(Product product1, Product product2);
    String compareProductsByCategory(Product product1, Product product2);

    Product findById(String id);

    Product findByProductId(String id);

    boolean sendReview(String id,String review);

    String[] getReviewById(String id);

}
