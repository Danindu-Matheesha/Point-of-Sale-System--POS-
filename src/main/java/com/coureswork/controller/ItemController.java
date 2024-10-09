package com.coureswork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coureswork.dto.ItemReqDTO;
import com.coureswork.entity.Item;
import com.coureswork.entity.ItemCategory;
import com.coureswork.service.ItemCategoryService;
import com.coureswork.service.ItemService;

@RestController
public class ItemController {
    
    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemCategoryService itemCategoryService;

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> items = itemService.getAllItems();

        return ResponseEntity.status(200).body(items);
    }

    @PostMapping("/items")
    public ResponseEntity<Item> createItem(@RequestBody ItemReqDTO itemReqDTO){
        Item item = new Item();
        item.setName(itemReqDTO.getName());
        item.setPrice(itemReqDTO.getPrice());
        item.setDescription(itemReqDTO.getDescription());
        item.setQuantity(itemReqDTO.getQuantity());

        ItemCategory itemCategory = itemCategoryService.getItemCategoryById(itemReqDTO.getItemcategoryId());
        item.setItemCategory(itemCategory);

        Item createdItem = itemService.createItem(item);

        return ResponseEntity.status(201).body(createdItem);
    }

    @GetMapping("/items/{itemId}")
    public ResponseEntity<Item> getItemById(@PathVariable Long itemId) {
        Item item = itemService.getItemById(itemId);

        if(item == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(item);
        }
    }

    @PutMapping("/items/{itemId}")
    public ResponseEntity<Item> updateItem(@PathVariable Long itemId, @RequestBody ItemReqDTO itemReqDTO){
        Item item = new Item();
        item.setName(itemReqDTO.getName());
        item.setPrice(itemReqDTO.getPrice());
        item.setDescription(itemReqDTO.getDescription());
        item.setQuantity(itemReqDTO.getQuantity());

        ItemCategory itemCategory = itemCategoryService.getItemCategoryById(itemReqDTO.getItemcategoryId());
        item.setItemCategory(itemCategory);

        try {
            itemService.updateItem(itemId, item);
        } catch (Exception error) {
            System.out.println(error);
        }

        return ResponseEntity.status(200).body(item);
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable Long itemId) {
        itemService.deleteItem(itemId);

        return ResponseEntity.status(200).body("Item Deleted");
    }

}
