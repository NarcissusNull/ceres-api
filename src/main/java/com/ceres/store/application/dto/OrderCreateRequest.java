package com.ceres.store.application.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderCreateRequest {

    private Long user;
    private List<Long> goods;
}
