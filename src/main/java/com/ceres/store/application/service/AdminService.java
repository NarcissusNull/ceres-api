package com.ceres.store.application.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.ceres.store.entity.TypeEntity;
import com.ceres.store.infrastructure.TypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private TypeRepository typeRepository;

    public void createTypes(List<String> types) {
        List<TypeEntity> typeEntities = types.stream()
                .map(type -> TypeEntity.builder().name(type).createdAt(new Date()).updatedAt(new Date()).build())
                .collect(Collectors.toList());
        typeRepository.saveAll(typeEntities);
    }

}
