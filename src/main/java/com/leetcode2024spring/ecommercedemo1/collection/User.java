package com.leetcode2024spring.ecommercedemo1.collection;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "User")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private String firebase_id;
    private String email;
    private String password;
    private String[] wishlist;

    public User(String firebase_id, String email, String password, String[] wishlist) {
        this.firebase_id = firebase_id;
        this.email = email;
        this.password = password;
        this.wishlist = wishlist;
    }

}
