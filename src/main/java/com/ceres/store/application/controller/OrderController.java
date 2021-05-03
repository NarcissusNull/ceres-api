package com.ceres.store.application.controller;

import com.ceres.store.application.dto.OrderCreateRequest;
import com.ceres.store.application.dto.OrderDto;
import com.ceres.store.application.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "create")
    public OrderDto create(@RequestBody OrderCreateRequest request) {
        return orderService.create(request);
    }
}
