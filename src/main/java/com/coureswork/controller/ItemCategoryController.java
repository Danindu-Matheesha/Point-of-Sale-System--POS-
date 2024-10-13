package com.coureswork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coureswork.entity.ItemCategory;
import com.coureswork.service.ItemCategoryService;

@RestController
@CrossOrigin(origins = "*")
public class ItemCategoryController {
    
    @Autowired
    private ItemCategoryService itemCategoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<ItemCategory>> getACategories() {
        List <ItemCategory> itemCategories = itemCategoryService.getAllItemCategories();
        return ResponseEntity.status(200).body(itemCategories);
    }

    @PostMapping("/categories")
    public ResponseEntity<ItemCategory> createItemCategory(@RequestBody ItemCategory itemcategory) {
        ItemCategory createdItemCategory = itemCategoryService.createItemCategory(itemcategory);

        return ResponseEntity.status(201).body(createdItemCategory);
    }
    
}
