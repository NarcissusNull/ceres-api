package com.ceres.store.application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceres.store.application.service.UserService;
import com.ceres.store.entity.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping(value="/login")
    public UserEntity postMethodName(@RequestBody UserEntity user) {
        return userService.login(user);
    }
    
}
