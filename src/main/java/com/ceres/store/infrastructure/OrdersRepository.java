package com.ceres.store.infrastructure;

import java.util.List;

import com.ceres.store.entity.OrdersEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity, Long> {
    public List<OrdersEntity> findAllByUser(Long user);
}
