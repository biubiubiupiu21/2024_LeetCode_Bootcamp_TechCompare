package com.leetcode2024spring.ecommercedemo1.collection;

class Location{
    private double longitude;
    private double latitude;
}

class Inventory{
    private String product_id;
    private int quantity;
}
public class Store {
    private String name;
    private Location location;
    private String address;
    private Inventory[] inventory;
}
