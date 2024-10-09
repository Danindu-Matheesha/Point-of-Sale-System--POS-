package com.coureswork.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coureswork.entity.ItemCategory;
import com.coureswork.repository.ItemCategoryRepository;
import com.coureswork.service.ItemCategoryService;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {
    
    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    @Override
    public List<ItemCategory> getAllItemCategories(){
        return itemCategoryRepository.findAll();
    }

    @Override
    public ItemCategory createItemCategory(ItemCategory itemCategory) {
        return itemCategoryRepository.save(itemCategory);
    }

    @Override
    public ItemCategory getItemCategoryById(Long itemcategoryid){
        return itemCategoryRepository.findById(itemcategoryid).orElse(null);
    }
}
