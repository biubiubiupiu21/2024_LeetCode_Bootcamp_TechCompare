package com.leetcode2024spring.ecommercedemo1.service;

import com.leetcode2024spring.ecommercedemo1.collection.Product;
import com.leetcode2024spring.ecommercedemo1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findProductById(int productID){
        return productRepository.findProductById(productID);
    }
}
