package com.leetcode2024spring.ecommercedemo1.service;

import com.leetcode2024spring.ecommercedemo1.collection.Product;
import com.leetcode2024spring.ecommercedemo1.repository.ProductRepository;

import java.util.List;


public interface ProductService {
    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByBrand(String brand);

    List<Product> searchProductsByName(String name);

    String compareProductsByPrice(Product product1, Product product2);
    String compareProductsByCategory(Product product1, Product product2);

    Product findById(String id);

    Product findByProductId(String id);

    boolean sendReview(String id,String review);

    String[] getReviewById(String id);

}
