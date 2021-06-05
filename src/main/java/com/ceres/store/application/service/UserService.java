package com.ceres.store.application.service;

import java.util.Date;

import com.ceres.store.entity.UserEntity;
import com.ceres.store.infrastructure.UserRepository;
import com.google.common.base.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public UserEntity changeUserInfo(UserEntity user) {
        UserEntity re = userRepository.findById(user.getId()).get();
        if (user.getName() != null)
            re.setName(user.getName());
        if (user.getPassword() != null)
            re.setPassword(user.getPassword());
        if (user.getAddress() != null)
            re.setAddress(user.getAddress());
        return re;
    }

}
