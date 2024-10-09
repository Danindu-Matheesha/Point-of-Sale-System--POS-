package com.coureswork.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coureswork.dto.StockDTO;
import com.coureswork.entity.Item;
import com.coureswork.entity.Stock;
import com.coureswork.service.ItemService;
import com.coureswork.service.StockService;

@RestController
public class StockController {
    
    @Autowired
    private StockService stockService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/stock")
    public ResponseEntity<List<Stock>> getAllStock(){
        List<Stock> stocks = stockService.getAllStocks();

        return ResponseEntity.status(200).body(stocks);
    }

    @PostMapping("/stock")
    public ResponseEntity<Stock> createStock(@RequestBody StockDTO stockDTO){
        Stock stock = new Stock();
        stock.setQuantity(0.0);

        List<Long> itemIds = stockDTO.getItemIds();
        List<Item> stockedItems = new ArrayList<>();

        itemIds.forEach(itemId -> {
            Item item = itemService.getItemById(itemId);

            if (item != null) {
                stockedItems.add(item);

                stock.setQuantity(item.getQuantity() - stock.getQuantity());
            }
        });

        stock.setItemedStocks(stockedItems);
        stockService.createStock(stock);

        return ResponseEntity.status(201).body(stock);
    }

//     @PostMapping("/stock")
// public ResponseEntity<Stock> createStock(@RequestBody StockDTO stockDTO) {
//     Stock stock = new Stock();
//     stock.setQuantity(0.0);

//     List<Long> itemIds = stockDTO.getItemIds();
//     List<Item> stockedItems = new ArrayList<>();

//     for (Long itemId : itemIds) {
//         Item item = itemService.getItemById(itemId);

//         if (item != null) {
//             stockedItems.add(item);

//             // Check if the item's quantity is not null before subtracting
//             Integer itemQuantity = item.getQuantity();
//             if (itemQuantity != null) {
//                 stock.setQuantity(itemQuantity - stock.getQuantity());
//             } else {
//                 // Handle the null case (e.g., log a warning or set a default value)
//                 System.out.println("Item with ID " + itemId + " has a null quantity.");
//             }
//         }
//     }

//     stock.setItemedStocks(stockedItems);
//     stockService.createStock(stock);

//     return ResponseEntity.status(201).body(stock);
// }

}
