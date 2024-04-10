package com.leetcode2024spring.ecommercedemo1.collection;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@Builder

@Document(collection = "Products")
public class Product {
    public static final String SEQUENCE_NAME = "product_sequence";
    //    @Id
    private String productStringId;

    private String productName;
    private double currentPrice;
    private String category;
    private String brand;
    private String model;
    private Specification specifications;
//    private String image;
    private List<PriceHistory> priceHistory;
    private List<Review> review;

    public Product(){
        priceHistory = new ArrayList<PriceHistory>();
        review = new ArrayList<>();
    }

    public Product(String productStringId,
                   String productName,
                   double currentPrice,
                   String category,
                   String brand,
                   String model,
                   Specification specifications,
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

    public void setCategory(String category) {
        this.category = category;
    }

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

    public Specification getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Specification specifications) {
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


