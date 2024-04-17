package com.leetcode2024spring.ecommercedemo1.controller;

import com.leetcode2024spring.ecommercedemo1.collection.PriceHistory;
import com.leetcode2024spring.ecommercedemo1.collection.Product;
import com.leetcode2024spring.ecommercedemo1.collection.Review;
import com.leetcode2024spring.ecommercedemo1.service.ProductServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductServiceImp productService;

    @GetMapping("/getall")
    public List<Product> fetchAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/getproduct")
    public Product getproduct() {
        Product product = productService.getByProductStringId("109");
        System.out.println(product.getProductName());
        System.out.println(product.getCategory());
        return product;
    }

    @GetMapping("/bycategory")
    public List<Product> getProductsByCategory(@RequestParam("category") String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/bybrand")
    public List<Product> getProductsByBrand(@RequestParam("brand") String brand) {
        return productService.getProductsByBrand(brand);
    }

    @GetMapping("/search")
    public List<Product> searchProductsByName(@RequestParam("name") String name) {
        return productService.searchProductsByName(name);
    }

    @GetMapping("/categories")
    public List<String> getAllCategories() {
        return productService.getAllCategories();
    }

    @GetMapping("/brands")
    public List<String> getAllBrands() {
        return productService.getAllBrands();
    }

    @GetMapping("/filterByPrice")
    public List<Product> getProductsByPriceRange(
            @RequestParam("minPrice") Double minPrice,
            @RequestParam("maxPrice") Double maxPrice) {
        return productService.getProductsByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/similar/{productId}")
    public List<Product> getSimilarProducts(
            @PathVariable String productId,
            @RequestParam(required = false) String category) {
        return productService.getOtherProductsInCategory(productId);
    }

    @GetMapping("/{productId}/reviews")
    public List<Review> getReviewsByProductId(@PathVariable String productId) {
        return productService.getReviewsByProductId(productId);
    }

    @GetMapping("/{productStringId}/price")
    public ResponseEntity<Double> getProductPrice(@PathVariable String productStringId) {
        Double price = productService.getPriceByProductId(productStringId);
        if (price == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(price);
    }

    @GetMapping("/{productStringId}/price-history")
    public ResponseEntity<List<PriceHistory>> getPriceHistoryByProductId(@PathVariable String productStringId) {
        List<PriceHistory> priceHistory = productService.getPriceHistoryByProductId(productStringId);
        if (priceHistory == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(priceHistory);
    }

    @GetMapping("/bystores")
    public ResponseEntity<List<Product>> getProductsByStoreIdsAndInventory(
            @RequestParam("storeIds") String[] storeIds) {
        List<Product> products = productService.findProductsByStoreIds(storeIds);
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }



    @PostMapping("/compare")
    public List<Product> compareProducts(
            @RequestParam("productId1") String productId1,
            @RequestParam("productId2") String productId2
    ) {
        List<Product> ans = new LinkedList<Product>();
        // Retrieve products from repository based on product IDs
        Product product1 = productService.getByProductStringId(productId1);
        Product product2 = productService.getByProductStringId(productId2);

        if (product1 != null && product2 != null) {
            // Perform comparison based on price
//            String priceComparison = productService.compareProductsByPrice(product1, product2);
//            // Perform comparison based on category
//            String categoryComparison = productService.compareProductsByCategory(product1, product2);
                ans.add(product1);
                ans.add(product2);
            // You can return both comparisons or choose to return one
            return ans;
        } else {
            return ans;
        }
    }
    @PostMapping("/sendreview")
    public String sendReview(@RequestParam("id")String id, @RequestBody Review review){
        return productService.sendReview(id,review);
    }
    @GetMapping("/getreview")
    public List<Review> getReview(@RequestParam("productStringId")String id){
        return productService.getReviewById(id);
    }

    @GetMapping("/getest")
    public Product getest(){
        return productService.gettest();
    }

    @GetMapping("/getest2")
    public void getest2(){
        productService.printAllProducts();
    }
}

