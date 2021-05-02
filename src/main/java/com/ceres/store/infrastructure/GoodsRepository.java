package com.ceres.store.infrastructure;

import java.util.List;

import com.ceres.store.entity.GoodsEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<GoodsEntity, Long> {

    public List<GoodsEntity> findByNameLike(String value);
}
