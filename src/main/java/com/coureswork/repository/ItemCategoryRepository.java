package com.coureswork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coureswork.entity.ItemCategory;

@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Long> {
    
}
