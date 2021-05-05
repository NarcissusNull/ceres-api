package com.ceres.store.infrastructure;

import java.util.List;

import com.ceres.store.entity.CartEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {

    public List<CartEntity> findAllByUser(Long user);

    public List<CartEntity> findAllByUserAndGoods(Long user, Long goods);
}
