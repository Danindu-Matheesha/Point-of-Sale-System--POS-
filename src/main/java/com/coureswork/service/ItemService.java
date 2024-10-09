package com.coureswork.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coureswork.entity.Item;

@Service
public interface ItemService {
    List<Item> getAllItems();
    Item createItem(Item item);
    Item updateItem(Long id, Item item);
    Item getItemById(Long id);
    void deleteItem(Long id);
}
