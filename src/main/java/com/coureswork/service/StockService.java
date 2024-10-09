package com.coureswork.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coureswork.entity.Stock;

@Service
public interface StockService {
    List<Stock> getAllStocks();
    Stock createStock(Stock stock);
}
