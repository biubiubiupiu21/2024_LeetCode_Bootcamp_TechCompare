package com.leetcode2024spring.ecommercedemo1.collection;

import java.sql.Timestamp;
import java.util.Date;

public class Review {
    private String comment;
    private int rating;
    private Date time;
    private String email;

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setEmail(String email) {

        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public Review(String comment, int rating, Date time, String email) {
        this.comment = comment;
        this.rating = rating;
        this.time = time;
        this.email = email;
    }
}
