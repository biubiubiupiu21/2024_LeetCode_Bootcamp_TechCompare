package com.leetcode2024spring.ecommercedemo1.collection;

import java.sql.Timestamp;
import java.util.Date;

public class Review {
    private String comment;
    private int rating;
    private Date time;
    private int userId;

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }

    public Date getTime() {
        return time;
    }

    public int getUserId() {
        return userId;
    }

    public Review(String comment, int rating, Date time, int userId) {
        this.comment = comment;
        this.rating = rating;
        this.time = time;
        this.userId = userId;
    }
}
