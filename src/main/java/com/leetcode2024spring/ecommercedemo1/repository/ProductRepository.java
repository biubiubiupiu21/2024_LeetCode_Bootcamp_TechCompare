package com.leetcode2024spring.ecommercedemo1.repository;

import com.leetcode2024spring.ecommercedemo1.collection.Product;
import com.leetcode2024spring.ecommercedemo1.collection.Review;
import com.leetcode2024spring.ecommercedemo1.collection.User;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

@Document(collection = "Product")
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

    //$gte stands for "greater than or equal to"
    //$lte stands for "less than or equal to"
    @Query("{'currentPrice' : { $gte: ?0, $lte: ?1 }}")
    List<Product> findByPriceRange(Double minPrice, Double maxPrice);

    //ne=not equal, ?1 = the second parameter
    @Query("{'category': ?0, 'productStringId': {$ne: ?1}}")
    List<Product> findByCategoryAndIdNot(String category, String excludeProductId);

    @Query("{'productStringId': {$in: ?0}}")
    List<Product> findByIdIn(List<String> productIds);

    List<Review> findByReview(String productStringId);

}
