package com.leetcode2024spring.ecommercedemo1.dto;

import com.leetcode2024spring.ecommercedemo1.collection.PriceHistory;
import com.leetcode2024spring.ecommercedemo1.collection.Review;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor

public class ProductDTO {
    private String productStringId;

    private String productName;
    private double currentPrice;
    private String category;
    private String brand;
    private String model;
    private Map<String, String> specifications;
    private List<PriceHistory> priceHistory;
    private List<Review> review;

    public ProductDTO() {
        specifications = new HashMap<>(); // Ensure it's not null
        // Initialize other fields if necessary
    }

    public String getProductStringId() {
        return productStringId;
    }

    public void setProductStringId(String productStringId) {
        this.productStringId = productStringId;
    }

    // Getter and Setter for productName
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    // Getter and Setter for currentPrice
    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    // Getter and Setter for category
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Getter and Setter for brand
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Getter and Setter for model
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // Getter and Setter for specifications
    public Map<String, String> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Map<String, String> specifications) {
        this.specifications = specifications;
    }

    // Getter and Setter for priceHistory
    public List<PriceHistory> getPriceHistory() {
        return priceHistory;
    }

    public void setPriceHistory(List<PriceHistory> priceHistory) {
        this.priceHistory = priceHistory;
    }

    // Getter and Setter for review
    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }
}






