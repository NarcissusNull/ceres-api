package com.ceres.store.application.service;

import java.util.List;
import java.util.stream.Collectors;

import com.ceres.store.application.dto.GoodsCreateRequest;
import com.ceres.store.entity.GoodsEntity;
import com.ceres.store.entity.TypeEntity;
import com.ceres.store.infrastructure.GoodsRepository;
import com.ceres.store.infrastructure.TypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private TypeRepository typeRepository;

    public List<GoodsEntity> search() {
        return goodsRepository.findAll();
    }

    public List<TypeEntity> queryTypes() {
        return typeRepository.findAll();
    }

    public GoodsEntity create(GoodsCreateRequest request) {
        return goodsRepository.save(GoodsEntity.builder()
            .name(request.getName())
            .price(request.getPrice())
            .main(request.getImages().get(0))
            .describe(request.getImages().stream().collect(Collectors.joining(",")))
            .build());
	}

    public List<GoodsEntity> queryGoods(int size) {
        return goodsRepository.findAll().subList(0, size);
    }

}
