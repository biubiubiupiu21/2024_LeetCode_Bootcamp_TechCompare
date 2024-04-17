package com.leetcode2024spring.ecommercedemo1.collection;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
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

    public void setProductStringId(String productStringId) {
        this.productStringId = productStringId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSpecifications(Specification specifications) {
        this.specifications = specifications;
    }

    public void setPriceHistory(List<PriceHistory> priceHistory) {
        this.priceHistory = priceHistory;
    }

//<<<<<<< HEAD
//    public List<Review> getReview() {
//        return this.review;
//    }
//
//=======
//>>>>>>> 646df16869f0e8794830920f1a982ba77f8f4733
    public void setReview(Review review) {
        this.review.add(review);
//        review.setProduct(this); // Ensuring the bidirectional link is maintained
        System.out.println("Add review: " + review);
    }
}


