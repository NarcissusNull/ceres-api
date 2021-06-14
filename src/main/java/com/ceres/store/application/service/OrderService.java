package com.ceres.store.application.service;

import java.util.List;
import java.util.stream.Collectors;

import com.ceres.store.application.dto.OrderCreateRequest;
import com.ceres.store.application.dto.OrderDto;
import com.ceres.store.entity.ItemsEntity;
import com.ceres.store.entity.OrdersEntity;
import com.ceres.store.infrastructure.ItemsRepository;
import com.ceres.store.infrastructure.OrdersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ItemsRepository itemsRepository;

    public OrderDto create(OrderCreateRequest request) {
        OrdersEntity order = ordersRepository.save(OrdersEntity.builder().user(request.getUser()).build());
        List<ItemsEntity> items = request.getGoods().stream()
                .map(goods -> ItemsEntity.builder().order(order.getId()).goods(goods).build())
                .collect(Collectors.toList());
                for (int i = 0; i < items.size(); i++) {
                    items.get(i).setNums(request.getNums().get(i));
                }
        List<ItemsEntity> saved = itemsRepository.saveAll(items);
        return OrderDto.builder().id(order.getId()).user(order.getUser())
                .goods(saved.stream().map(s -> s.getGoods()).collect(Collectors.toList())).build();
    }

}
