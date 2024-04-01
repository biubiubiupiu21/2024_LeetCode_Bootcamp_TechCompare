package com.leetcode2024spring.ecommercedemo1.collection;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Data
@Builder

class price_history {
    private Timestamp time;
    private double price;
}

class Specification {
    private String processor;
    private String ram;
    private String storage;
    private String display;
    private String graphics;
    private String battery;
    private String os;
}

class Review {
    private String comment;
    private int rating;
    private Timestamp time;
    private String user_id;
}

public class Product {
    @Id
    private int id;
    private String product_name;
    private double current_price;
    private String category;
    private String brand;
    private String model;
    private Specification[] specifications;
//    private String image;
    private price_history[] price_history;
    private Review[] review;
}


