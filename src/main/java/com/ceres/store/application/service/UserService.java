package com.ceres.store.application.service;

import com.ceres.store.entity.UserEntity;
import com.ceres.store.infrastructure.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity login(UserEntity user) {
        return userRepository.findByNameAndPassword(user.getName(), user.getPassword()).orElseGet(() -> new UserEntity());
    }

}
