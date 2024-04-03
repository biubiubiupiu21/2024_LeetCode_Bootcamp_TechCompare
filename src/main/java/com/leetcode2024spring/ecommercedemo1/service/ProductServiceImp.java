package com.leetcode2024spring.ecommercedemo1.service;

import com.leetcode2024spring.ecommercedemo1.collection.Product;
import com.leetcode2024spring.ecommercedemo1.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp {
    @Autowired
    private ProductRepository productRepository;

    private SequenceGeneratorService sequenceGeneratorService;

    public ProductServiceImp(ProductRepository productRepository, SequenceGeneratorService sequenceGeneratorService) {
        this.productRepository = productRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    public Product createProduct(Product product) {
        // Only set a new ID if the product doesn't already have one
        if (product.getProduct_string_id() == null) {
            product.setProduct_string_id(sequenceGeneratorService.generateSequence(Product.SEQUENCE_NAME).toString());
        }
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }


}

