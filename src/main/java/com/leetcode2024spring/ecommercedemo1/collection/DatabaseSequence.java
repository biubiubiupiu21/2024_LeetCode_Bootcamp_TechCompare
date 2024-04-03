package com.leetcode2024spring.ecommercedemo1.collection;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class DatabaseSequence {
    @Id
    private String id;

    @Setter
    @Getter
    private long seq;

}
