package com.ceres.store.application.service;

import java.util.List;

import com.ceres.store.entity.GoodsEntity;
import com.ceres.store.infrastructure.GoodsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    public List<GoodsEntity> search() {
        return goodsRepository.findAll();
    }

}
