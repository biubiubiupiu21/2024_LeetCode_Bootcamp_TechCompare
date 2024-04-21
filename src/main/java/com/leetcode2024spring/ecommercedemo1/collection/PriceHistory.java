package com.leetcode2024spring.ecommercedemo1.collection;

import lombok.Setter;

import java.util.Date;

public class PriceHistory {
        @Setter
        private Date time;
        private double price;

    public PriceHistory() {
    }


    public Date getTime() {
        return time;
    }

    public double getPrice() {
        return price;
    }

    public PriceHistory(Date time, double price) {
            this.time = time;
            this.price = price;
        }
    }
