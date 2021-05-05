package com.ceres.store.application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceres.store.application.service.UserService;
import com.ceres.store.entity.UserEntity;
import com.ceres.store.infrastructure.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    
    @PostMapping(value="/login")
    public UserEntity login(@RequestBody UserEntity user) {
        return userService.login(user);
    }

    @PostMapping(value="/signup")
    public UserEntity signup(@RequestBody UserEntity user) {
        return userService.signup(user);
    }

    @GetMapping(value = "/{id}")
    public UserEntity getUser(@PathVariable("id") Long id) {
        return userRepository.findById(id).get();
    }
    
}
