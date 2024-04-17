package com.leetcode2024spring.ecommercedemo1.collection;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Getter
@Setter

@Document(collection = "Store")
public class Store {
    private String name;
    private Location location;
    private String address;
    private List<Inventory> inventory;

    public Store(){
        inventory = new ArrayList<>();
    }

    public Store(String name, Location location, String address, List<Inventory> inventory){
        this.name = name;
        this.location = location;
        this.address = address;
        this.inventory = inventory;
    }
}


