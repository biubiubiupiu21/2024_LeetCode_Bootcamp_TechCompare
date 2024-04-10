package com.leetcode2024spring.ecommercedemo1.collection;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

class Location{
    private double longitude;
    private double latitude;
}

class Inventory{
    private String productStringId;
    private int quantity;
}

@Data
@Builder

@Document(collection = "Store")
public class Store {
//    @Id
    private String name;
    private Location location;
    private String address;
    private Inventory[] inventory;
}
