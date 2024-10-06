package com.coureswork.service;

import org.springframework.stereotype.Service;

import com.coureswork.entity.User;

@Service
public interface UserService {
    User createUser(User user);
}
