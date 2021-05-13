package com.ceres.store.application.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.ceres.store.application.dto.GoodsCreateRequest;
import com.ceres.store.entity.GoodsEntity;
import com.ceres.store.entity.TypeEntity;
import com.ceres.store.infrastructure.CartRepository;
import com.ceres.store.infrastructure.GoodsRepository;
import com.ceres.store.infrastructure.TypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private CartRepository cartRepository;

    public List<GoodsEntity> search() {
        return goodsRepository.findAll().stream().filter(goods -> !goods.isDeleted()).collect(Collectors.toList());
    }

    public List<TypeEntity> queryTypes() {
        return typeRepository.findAll();
    }

    public GoodsEntity create(GoodsCreateRequest request) {
        return goodsRepository.save(
                GoodsEntity.builder().name(request.getName()).price(request.getPrice()).main(request.getImages().get(0))
                        .describe(request.getImages().stream().collect(Collectors.joining(","))).build());
    }

    public List<GoodsEntity> queryGoods(int size) {
        return goodsRepository.findAll().stream().filter(goods -> !goods.isDeleted()).collect(Collectors.toList())
                .subList(0, size);
    }

    public GoodsEntity getDetail(Long id) {
        return goodsRepository.findById(id).get();
    }

    public List<GoodsEntity> search(String value) {
        return goodsRepository.findByNameLike("%" + value + "%").stream().filter(goods -> !goods.isDeleted())
                .collect(Collectors.toList());
    }

    public List<GoodsEntity> searchCart(Long user) {
        return cartRepository.findAllByUser(user).stream().map(cart -> goodsRepository.findById(cart.getGoods()).get())
                .collect(Collectors.toList());
    }

    public void removeCart(Long id, Long user) {
        cartRepository.deleteAll(cartRepository.findAllByUserAndGoods(user, id));
    }

    @Transactional
    public void delete(Long id) {
        GoodsEntity goods = goodsRepository.findById(id).get();
        goods.setDeleted(true);
    }

    @Transactional
    public GoodsEntity update(GoodsEntity request) {
        GoodsEntity goods = goodsRepository.findById(request.getId()).get();
        if (Objects.nonNull(request.getName())) {
            goods.setName(request.getName());
        }
        if (Objects.nonNull(request.getPrice())) {
            goods.setPrice(request.getPrice());
        }
        if (Objects.nonNull(request.getType())) {
            goods.setType(request.getType());
        }
        return goods;
    }

}
