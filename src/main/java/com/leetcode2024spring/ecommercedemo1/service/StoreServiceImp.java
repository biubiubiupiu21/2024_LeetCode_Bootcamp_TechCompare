package com.leetcode2024spring.ecommercedemo1.service;

import com.leetcode2024spring.ecommercedemo1.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImp implements StoreService{

    @Autowired
    private StoreRepository storeRepository;
}
