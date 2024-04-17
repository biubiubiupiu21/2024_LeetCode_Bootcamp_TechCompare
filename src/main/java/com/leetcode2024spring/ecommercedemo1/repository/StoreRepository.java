package com.leetcode2024spring.ecommercedemo1.repository;

import com.leetcode2024spring.ecommercedemo1.collection.Product;
import com.leetcode2024spring.ecommercedemo1.collection.Store;
import com.leetcode2024spring.ecommercedemo1.collection.User;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Collection;
import java.util.List;

@Document(collection = "Store")
public interface StoreRepository extends MongoRepository<Store, String> {
    @Query("{'storeStringId': {$in: ?0}}")
    List<Store> findByStoreStringIdIn(List<String> storeIds);


}
