package com.ceres.store.application.controller;

import java.util.List;

import com.ceres.store.application.dto.GoodsCreateRequest;
import com.ceres.store.application.service.GoodsService;
import com.ceres.store.entity.CartEntity;
import com.ceres.store.entity.GoodsEntity;
import com.ceres.store.entity.TypeEntity;
import com.ceres.store.infrastructure.CartRepository;

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

    @Autowired
    private CartRepository cartRepository;

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

    @GetMapping(value = "/cart/{id}/{user}")
    public CartEntity createCart(@PathVariable("id") Long id, @PathVariable("user") Long user) {
        return cartRepository.save(CartEntity.builder().goods(id).user(user).build());
    }

    @GetMapping(value = "/cart/search/{user}")
    public List<GoodsEntity> searchCart(@PathVariable("user") Long user) {
        return this.goodsService.searchCart(user);
    }

    @GetMapping(value = "/cart/remove/{user}/{id}")
    public void removeCart(@PathVariable("user") Long user, @PathVariable("id") Long id) {
        this.goodsService.removeCart(id, user);
    }

    @GetMapping(value = "/cart/clear/{user}")
    public void removeCart(@PathVariable("user") Long user) {
        cartRepository.deleteAll(cartRepository.findAllByUser(user));
    }


}
