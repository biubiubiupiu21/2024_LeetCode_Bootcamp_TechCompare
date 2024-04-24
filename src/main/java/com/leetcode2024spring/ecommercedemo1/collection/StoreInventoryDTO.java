package com.leetcode2024spring.ecommercedemo1.collection;

public class StoreInventoryDTO {
    private Store store;
    private int quantity;

    // 构造函数
    public StoreInventoryDTO(Store store, int quantity) {
        this.store = store;
        this.quantity = quantity;
    }

    // Getter 和 Setter
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

