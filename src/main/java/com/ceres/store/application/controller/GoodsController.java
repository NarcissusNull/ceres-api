package com.ceres.store.application.controller;

import java.util.List;

import com.ceres.store.application.dto.GoodsCreateRequest;
import com.ceres.store.application.service.GoodsService;
import com.ceres.store.entity.GoodsEntity;
import com.ceres.store.entity.TypeEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping(value = "/types")
    public List<TypeEntity> queryTypes() {
        return goodsService.queryTypes();
    }

    @PostMapping(value = "create")
    public GoodsEntity create(@RequestBody GoodsCreateRequest request) {
        return goodsService.create(request);
    }

    @GetMapping(value = "/{size}")
    public List<GoodsEntity> queryGoods(@PathVariable("size") int size) {
        return goodsService.queryGoods(size);
    }

    @GetMapping(value = "/detail/{id}")
    public GoodsEntity getDetail(@PathVariable("id") Long id) {
        return goodsService.getDetail(id);
    }

    @GetMapping(value = "/search/{value}")
    public List<GoodsEntity> search(@PathVariable("value") String value) {
        return goodsService.search(value);
    }

}
