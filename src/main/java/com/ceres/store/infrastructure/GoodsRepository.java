package com.ceres.store.infrastructure;

import com.ceres.store.entity.GoodsEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<GoodsEntity, Long> {
    
}
