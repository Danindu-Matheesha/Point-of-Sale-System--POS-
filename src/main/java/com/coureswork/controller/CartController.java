package com.coureswork.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coureswork.dto.CartDTO;
import com.coureswork.entity.Cart;
import com.coureswork.entity.Item;
import com.coureswork.service.CartService;
import com.coureswork.service.ItemService;

@RestController
@CrossOrigin(origins = "*")
public class CartController {
    
    @Autowired
    private CartService cartService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/cart")
    public ResponseEntity<List<Cart>> getAllCarts(){
        List<Cart> carts = cartService.getAllCarts();

        return ResponseEntity.status(200).body(carts);
    }

    @PostMapping("/cart")
    public ResponseEntity<Cart> createCart(@RequestBody CartDTO cartDTO){
        Cart cart = new Cart();
        cart.setTotalPrice(0.0);

        List<Long> itemIds = cartDTO.getItemIds();
        List<Item> cartedItems = new ArrayList<>();

        itemIds.forEach(itemId ->{
            Item item = itemService.getItemById(itemId);

            if (item != null) {
                cartedItems.add(item);

                cart.setTotalPrice(cart.getTotalPrice() + item.getPrice());
            }
        });

        cart.setCartedItems(cartedItems);
        cartService.createCart(cart);

        return ResponseEntity.status(201).body(cart);
    }
}
