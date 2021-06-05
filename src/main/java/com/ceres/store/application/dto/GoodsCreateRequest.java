package com.ceres.store.application.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class GoodsCreateRequest {
    
    private String name;
    private BigDecimal price;
    private long type;
    private List<String> images;
    private String size;
}
