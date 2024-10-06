package com.coureswork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coureswork.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
    
}
