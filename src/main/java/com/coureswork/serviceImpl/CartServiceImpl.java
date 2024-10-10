package com.coureswork.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coureswork.entity.Cart;
import com.coureswork.repository.CartRepository;
import com.coureswork.service.CartService;

@Service
public class CartServiceImpl implements CartService {
    
    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }

    @Override
    public Cart createCart(Cart cart){
        return cartRepository.save(cart);
    }
}
