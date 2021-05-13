package com.ceres.store.infrastructure;

import java.util.List;

import com.ceres.store.entity.ItemsEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<ItemsEntity, Long> {
    public List<ItemsEntity> findByOrder(Long order);
}
