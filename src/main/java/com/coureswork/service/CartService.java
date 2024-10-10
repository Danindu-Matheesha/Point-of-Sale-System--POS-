package com.coureswork.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coureswork.entity.Cart;

@Service
public interface CartService {
    List<Cart> getAllCarts();
    Cart createCart(Cart cart);
}
