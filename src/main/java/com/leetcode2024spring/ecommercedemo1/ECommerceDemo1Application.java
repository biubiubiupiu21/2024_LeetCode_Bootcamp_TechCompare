package com.leetcode2024spring.ecommercedemo1;


import com.leetcode2024spring.ecommercedemo1.collection.*;
import com.leetcode2024spring.ecommercedemo1.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.*;
import java.sql.Timestamp;

@SpringBootApplication
public class ECommerceDemo1Application {

    public static void main(String[] args) {

        SpringApplication.run(ECommerceDemo1Application.class, args);
    }

//<<<<<<< HEAD
//    @Bean
//    CommandLineRunner runner(ProductRepository repository){
//        return args -> {
//
//            Map<String, String> laptopSpecs = new HashMap<>();
//            laptopSpecs.put("processor", "Intel Core i7");
//            laptopSpecs.put("ram", "16GB");
//            laptopSpecs.put("storage", "512GB SSD");
//            laptopSpecs.put("display", "6.7-inch AMOLED (3200 x 1440) 120Hz");
//            laptopSpecs.put("graphics", "Adreno 660");
//            laptopSpecs.put("battery", "4500mAh");
//            laptopSpecs.put("os", "Android 11");
//            Specification specs = new Specification(laptopSpecs);
//
//            List<PriceHistory> priceHistories = new ArrayList<PriceHistory>();
//            priceHistories.add(new PriceHistory(new Timestamp(System.currentTimeMillis() - 10 * 24 * 60 * 60 * 1000L), 1200.00));
//            priceHistories.add(new PriceHistory(new Timestamp(System.currentTimeMillis()), 1100.00));
//
////            Price_history[] priceHistories = {
////                    new Price_history(new Timestamp(System.currentTimeMillis() - 10 * 24 * 60 * 60 * 1000L), 1200.00),
////                    new Price_history(new Timestamp(System.currentTimeMillis()), 1100.00)
////            };
//
//            List<Review> reviews = new ArrayList<>();
//            reviews.add(new Review( "Great!",5, Timestamp.valueOf("2023-01-08 00:00:00"),"user123@example.com"));
//            reviews.add(new Review("Will back again",5, Timestamp.valueOf("2023-01-11 00:00:00"),"user456@example.com"));
//
//
////            Review[] reviews ={
////                    new Review( "Great!",5, Timestamp.valueOf("2023-01-08 00:00:00"),34),
////                    new Review("Will back again",5, Timestamp.valueOf("2023-01-11 00:00:00"),9)
////            };
//
//            Product product = new Product("109", "custom-id-laptop-109",1100.00,"Laptop","Dell","G15",specs,priceHistories,reviews);
//            repository.save(product);
//
//        };
//    }
//=======

//    CommandLineRunner runner(ProductRepository repository){
//        return args -> {
//
//            Map<String, String> laptopSpecs = new HashMap<>();
//            laptopSpecs.put("processor", "Intel Core i7");
//            laptopSpecs.put("ram", "16GB");
//            laptopSpecs.put("storage", "512GB SSD");
//            laptopSpecs.put("display", "6.7-inch AMOLED (3200 x 1440) 120Hz");
//            laptopSpecs.put("graphics", "Adreno 660");
//            laptopSpecs.put("battery", "4500mAh");
//            laptopSpecs.put("os", "Android 11");
////            Specification specs = new Specification(laptopSpecs);
//
//            List<PriceHistory> priceHistories = new ArrayList<PriceHistory>();
//            priceHistories.add(new PriceHistory(new Timestamp(System.currentTimeMillis() - 10 * 24 * 60 * 60 * 1000L), 1200.00));
//            priceHistories.add(new PriceHistory(new Timestamp(System.currentTimeMillis()), 1100.00));
//
////            PriceHistory[] priceHistories = {
////                    new PriceHistory(new Timestamp(System.currentTimeMillis() - 10 * 24 * 60 * 60 * 1000L), 1200.00),
////                    new PriceHistory(new Timestamp(System.currentTimeMillis()), 1100.00)
////            };
//
//            List<Review> reviews = new ArrayList<>();
//            reviews.add(new Review( "Great!",5, Timestamp.valueOf("2023-01-08 00:00:00"),"test1@nyu.edu"));
//            reviews.add(new Review("Will back again",5, Timestamp.valueOf("2023-01-11 00:00:00"),"test2@nyu.edu"));
//            Review[] reviews ={
//                    new Review( "Great!",5, Timestamp.valueOf("2023-01-08 00:00:00"),34),
//                    new Review("Will back again",5, Timestamp.valueOf("2023-01-11 00:00:00"),9)
//            };
//
//            Product product = new Product("109", "custom-id-laptop-109",1100.00,"Laptop","Dell","G15",specs,priceHistories,reviews);
//            repository.save(product);
//
//        };
//    }

}
