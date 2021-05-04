package com.ceres.store.application.service;

import java.util.Date;

import com.ceres.store.entity.UserEntity;
import com.ceres.store.infrastructure.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity login(UserEntity user) {
        return userRepository.findByNameAndPassword(user.getName(), user.getPassword())
                .orElseGet(() -> new UserEntity());
    }

    public UserEntity signup(UserEntity user) {
        if (userRepository.findByName(user.getName()).isPresent()) {
            return UserEntity.builder().id(0l).build();
        } else {
            user.setRole("custormer");
            user.setCreatedAt(new Date());
            user.setUpdatedAt(new Date());
            return userRepository.save(user);
        }
    }

}
