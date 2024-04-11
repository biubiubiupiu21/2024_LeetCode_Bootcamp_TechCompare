package com.leetcode2024spring.ecommercedemo1.service;

import com.leetcode2024spring.ecommercedemo1.collection.Product;
import com.leetcode2024spring.ecommercedemo1.collection.Review;
import com.leetcode2024spring.ecommercedemo1.repository.ProductRepository;
import io.micrometer.common.util.internal.logging.InternalLogger;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp {

    //private static final Logger log = LoggerFactory.getLogger(ProductServiceImp.class);

    @Autowired
    private ProductRepository productRepository;

    //private SequenceGeneratorService sequenceGeneratorService;

    public ProductServiceImp(ProductRepository productRepository, SequenceGeneratorService sequenceGeneratorService) {
        this.productRepository = productRepository;
        //this.sequenceGeneratorService = sequenceGeneratorService;
    }



    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getById(String id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        List<Product> products = productRepository.findAll();
        for (Product p:products){
            System.out.println(p.getCategory());
        }
        System.out.println(123);

        return optionalProduct.orElse(null); // Return null if product is not found
    }

    public Product getByProductStringId(String id) {
        Product product = (productRepository.findByProductStringId(id));
        System.out.println(12345);
        System.out.println(product.getProductName());
        System.out.println(product.getCategory());
        List<Product> products = productRepository.findAll();
        for (Product p:products){
            System.out.println(p.getCategory());
        }

        return product; // Return null if product is not found
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }


    public List<Product> searchProductsByName(String name) {
//        log.info("Searching for products with name containing: {}", name);
        List<Product> products = productRepository.findByProductNameMatches(name);
//        log.info("Found {} products", products.size());
        return productRepository.findByProductNameMatches(name);
    }

    public List<String> getAllCategories() {
        return productRepository.findAllCategories().stream()
                .map(Product::getCategory)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> getAllBrands() {
        return productRepository.findAllBrands().stream()
                .map(Product::getBrand)
                .distinct()
                .collect(Collectors.toList());
    }

    public String compareProductsByPrice(Product product1, Product product2) {
        // need to add more detailed information
        double price1 = product1.getCurrentPrice();
        double price2 = product2.getCurrentPrice();
        String ans = "";
        if (price1>price2){
            ans = "The first product has a higher price";
        }
        else if (price1==price2){
            ans = "They have the same price";
        }
        else{
            ans = "The second product has a higher price";
        }
        return ans;
    }

    public String compareProductsByCategory(Product product1, Product product2) {
        // need to add more detailed information
        String ans = "";
        String s1 = product1.getCategory();
        String s2 = product2.getCategory();
        if (s1.equals(s2)){
            return "Same Category";
        }
        return "Different Category";
    }

    public String sendReview(String id, Review review){
        // find authentation by firebase_id
        Product product = productRepository.findByProductStringId(id);
        // includes comment, rating etc.
        product.setReview(review);
        return review.getComment();
    }

    public List<Review> getReviewById(String id){
        Product product = productRepository.findByProductStringId(id);
        // includes comment, rating etc.
        List<Review> reviews = product.getReview();
        return reviews;
    }



}

