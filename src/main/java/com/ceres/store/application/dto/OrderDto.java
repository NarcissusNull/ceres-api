package com.ceres.store.application.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto{
    
    private Long id;
    private Long user;
    private List<Long> goods;
    private List<Long> nums;
}
 