package com.coureswork.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coureswork.entity.ItemCategory;

@Service
public interface ItemCategoryService {
    List<ItemCategory> getAllItemCategories();
    ItemCategory createItemCategory(ItemCategory itemCategory);
    ItemCategory getItemCategoryById(Long itemcategoryid);
}
