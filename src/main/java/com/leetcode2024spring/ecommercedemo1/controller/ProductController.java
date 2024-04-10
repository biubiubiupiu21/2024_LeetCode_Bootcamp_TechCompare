package com.leetcode2024spring.ecommercedemo1.controller;

import com.leetcode2024spring.ecommercedemo1.collection.Product;
import com.leetcode2024spring.ecommercedemo1.collection.Review;
import com.leetcode2024spring.ecommercedemo1.service.ProductServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductServiceImp productService;

    @GetMapping("/getall")
    public List<Product> fetchAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/getproduct")
    public Product getproduct() {
        Product product = productService.getByProductStringId("109");
        System.out.println(product.getProductName());
        System.out.println(product.getCategory());
        return product;
    }


    @GetMapping("/compare")
    public String compareProducts(
            @RequestParam("productId1") String productId1,
            @RequestParam("productId2") String productId2
    ) {
        // Retrieve products from repository based on product IDs
        Product product1 = productService.getById(productId1);
        Product product2 = productService.getById(productId2);

        if (product1 != null && product2 != null) {
            // Perform comparison based on price
            String priceComparison = productService.compareProductsByPrice(product1, product2);
            // Perform comparison based on category
            String categoryComparison = productService.compareProductsByCategory(product1, product2);

            // You can return both comparisons or choose to return one
            return priceComparison + "<br>" + categoryComparison;
        } else {
            return "One or both products not found.";
        }
    }
    @PostMapping("/sendreview")
    public String sendReview(String id, Review review){
        return productService.sendReview(id,review);
    }
    @PostMapping("/getreview")
    public List<Review> getReview(String id){
        return productService.getReviewById(id);
    }
}

