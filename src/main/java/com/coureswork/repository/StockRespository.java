package com.coureswork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coureswork.entity.Stock;

@Repository
public interface StockRespository extends JpaRepository<Stock, Long> {
    
}
