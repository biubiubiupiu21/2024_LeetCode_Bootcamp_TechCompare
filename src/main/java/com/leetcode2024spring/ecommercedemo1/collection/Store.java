package com.leetcode2024spring.ecommercedemo1.collection;

import org.springframework.data.annotation.Id;

class Location{
    private double longitude;
    private double latitude;
}

class Inventory{
    private int product_id;
    private int quantity;
}
public class Store {
    @Id
    private int id;
    private String name;
    private Location location;
    private String address;
    private Inventory[] inventory;
}
