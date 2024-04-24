package com.leetcode2024spring.ecommercedemo1.collection;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Data
@Builder

@Document(collection = "Product")
public class Product {

    private String productStringId;

    private String productName;
    private double currentPrice;
    private String category;
    private String brand;
    private String model;
    private Map<String, String> specifications;
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


    // Setter for category with specifications initialization
    public void setCategory(String category) {
        this.category = category;
        this.specifications = new HashMap<>(DEFAULT_SPECIFICATIONS.getOrDefault(category, new HashMap<>()));
    }

    public void setProductStringId(String productStringId) {
        this.productStringId = productStringId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSpecifications(Map<String, String>  specifications) {
        this.specifications = specifications;
    }

    public void setPriceHistory(List<PriceHistory> priceHistory) {
        this.priceHistory = priceHistory;
    }

    public String getProductStringId() {
        return productStringId;
    }

    public String getProductName() {
        return productName;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public String getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Map<String, String> getSpecifications() {
        return specifications;
    }

    public List<PriceHistory> getPriceHistory() {
        return priceHistory;
    }

    public void setReview(Review review) {
        this.review.add(review);
//        review.setProduct(this); // Ensuring the bidirectional link is maintained
        System.out.println("Add review: " + review);
    }
}


