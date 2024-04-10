package com.leetcode2024spring.ecommercedemo1.collection;

import java.sql.Timestamp;
import java.util.Date;

public class PriceHistory {
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
