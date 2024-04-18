package com.leetcode2024spring.ecommercedemo1.collection;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class wlist {
    private Date addTime;
    private String productStringId;

    public wlist(){

    }

    public wlist(Date addTime, String productStringId){
        this.addTime = addTime;
        this.productStringId = productStringId;
    }
}