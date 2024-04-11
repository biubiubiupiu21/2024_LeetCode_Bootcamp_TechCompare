package com.leetcode2024spring.ecommercedemo1.repository;

import com.leetcode2024spring.ecommercedemo1.collection.Product;
import com.leetcode2024spring.ecommercedemo1.collection.Review;
import com.leetcode2024spring.ecommercedemo1.collection.User;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

@Document(collection = "Products")
public interface ProductRepository extends MongoRepository<Product,String> {
    Product findByProductStringId(String productStringId);

    List<Product> findByCategory(String category);

    List<Product> findByBrand(String brand);

    List<Product> findByProductNameMatches(String regex);

    //specifying a MongoDB query with two parts: value and fields.
    //value = "{}" ---- select all in SQL
    //{category : 1} specifies which fields to include or exclude in the documents. The number 1 is used to include the field, while a 0 would exclude it.
    @Query(value = "{}", fields = "{category : 1}")
    List<Product> findAllCategories();

    @Query(value = "{}", fields = "{brand : 1}")
    List<Product> findAllBrands();

    List<Review> findByReview(String productStringId);

}
