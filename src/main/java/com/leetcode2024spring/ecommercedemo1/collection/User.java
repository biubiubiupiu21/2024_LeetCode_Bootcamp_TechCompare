package com.leetcode2024spring.ecommercedemo1.collection;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.security.KeyStore;
import java.util.*;

@Data
@Document(collection = "User")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private String password;
    @Setter
    @Getter
    private List<wlist> wishlist;
    private String firebase_id;
    private String email;

    public User(String firebase_id, String email, String password, List<wlist> wishlist) {
        this.firebase_id = firebase_id;
        this.email = email;
        this.password = password;
        this.wishlist = wishlist;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<wlist> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<wlist> wishlist) {
        this.wishlist = wishlist;
    }

    public void addWishlist(wlist item) {
        this.wishlist.add(item);
    }

    public String getFirebase_id() {
        return firebase_id;
    }

    public void setFirebase_id(String firebase_id) {
        this.firebase_id = firebase_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}