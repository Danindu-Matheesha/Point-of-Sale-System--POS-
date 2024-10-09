package com.coureswork.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coureswork.entity.Stock;
import com.coureswork.repository.StockRespository;
import com.coureswork.service.StockService;

@Service
public class StockServiceImpl implements StockService{
    
    @Autowired
    private StockRespository stockRespository;

    @Override
    public List<Stock> getAllStocks(){
        return stockRespository.findAll();
    }

    @Override
    public Stock createStock(Stock stock){
        return stockRespository.save(stock);
    }
}
