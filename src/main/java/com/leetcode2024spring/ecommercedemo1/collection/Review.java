package com.leetcode2024spring.ecommercedemo1.collection;

import java.sql.Timestamp;

public class Review {
    private String comment;
    private int rating;
    private Timestamp time;
    private int user_id;

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Review(String comment, int rating, Timestamp time, int user_id) {
        this.comment = comment;
        this.rating = rating;
        this.time = time;
        this.user_id = user_id;
    }
}
