package com.ceres.store.application.controller;

import java.util.List;

import com.ceres.store.application.service.GoodsService;
import com.ceres.store.entity.GoodsEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping(value = "/search")
    public List<GoodsEntity> searchGoods() {
        return goodsService.search();
    }
    
}
