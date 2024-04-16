package com.leetcode2024spring.ecommercedemo1.controller;

import com.leetcode2024spring.ecommercedemo1.collection.Inventory;
import com.leetcode2024spring.ecommercedemo1.collection.Product;
import com.leetcode2024spring.ecommercedemo1.collection.Store;
import com.leetcode2024spring.ecommercedemo1.service.ProductServiceImp;
import com.leetcode2024spring.ecommercedemo1.service.StoreService;
import com.leetcode2024spring.ecommercedemo1.service.StoreServiceImp;
import com.leetcode2024spring.ecommercedemo1.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreServiceImp storeService;
    @Autowired
    private ProductServiceImp productService;

    @GetMapping("/getStoreByInventoryQuantity")
    public List<Store> getStoreByQuantity(String productStringId){
        List<Store> allStore = storeService.getAllStore();
        List<Store> res = new ArrayList<>();
        for(Store s: allStore){
            List<Inventory> inventories = s.getInventory();
            for(Inventory inv: inventories){
                if(inv.getProductStringId().equals(productStringId) && inv.getQuantity() != 0){
                    res.add(s);
                    break;
                }
            }
        }
        return res;
    }


}
