package com.leetcode2024spring.ecommercedemo1.collection;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder

@Document(collection = "Products")
public class Product {
    //public static final String SEQUENCE_NAME = "product_sequence";
    //    @Id
    private String productStringId;

    private String productName;
    private double currentPrice;
    private String category;
    private String brand;
    private String model;
    private Map<String, String> specifications;
//    private String image;
    private List<PriceHistory> priceHistory;
    private List<Review> review;

    private static final Map<String, Map<String, String>> DEFAULT_SPECIFICATIONS = new HashMap<>();

    static {
        // Initialize default specifications for laptops
       Map<String, String> laptopSpecs = new HashMap<>();
    }

    // Product constructor
    public Product() {
        priceHistory = new ArrayList<>();
        review = new ArrayList<>();
        // Initialize specifications with empty map to avoid null pointers
        specifications = new HashMap<>();
    }

    // Setter for category with specifications initialization
    public void setCategory(String category) {
        this.category = category;
        this.specifications = new HashMap<>(DEFAULT_SPECIFICATIONS.getOrDefault(category, new HashMap<>()));
    }


    public Product(String productStringId,
                   String productName,
                   double currentPrice,
                   String category,
                   String brand,
                   String model,
                   Map<String, String> specifications,
                   List<PriceHistory> priceHistory,
                   List<Review> review) {

        this.productStringId = productStringId;
        this.productName = productName;
        this.currentPrice = currentPrice;
        this.category = category;
        this.brand = brand;
        this.model = model;
        this.specifications = specifications;
        this.priceHistory = priceHistory;
        this.review = review;
    }

    public String getProductStringId() {
        return productStringId;
    }

    public void setProductStringId(String productStringId) {
        this.productStringId = productStringId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getCategory() {
        return category;
    }

//    public void setCategory(String category) {
//        this.category = category;
//    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Map<String, String> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Map<String, String> specifications) {
        this.specifications = specifications;
    }

    public List<PriceHistory> getPriceHistory() {
        return priceHistory;
    }

    public void setPriceHistory(List<PriceHistory> priceHistory) {
        this.priceHistory = priceHistory;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review.add(review);
    }
}


