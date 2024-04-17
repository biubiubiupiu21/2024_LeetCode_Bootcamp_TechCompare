package com.leetcode2024spring.ecommercedemo1.collection;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Inventory {
    private String productStringId;
    private int quantity;

    public Inventory(){

    }

    public Inventory(String productStringId, int quantity){
        this.productStringId = productStringId;
        this.quantity = quantity;
    }
}
