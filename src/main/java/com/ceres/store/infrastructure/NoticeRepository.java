package com.ceres.store.infrastructure;

import java.util.Optional;

import com.ceres.store.entity.NoticeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {
    public Optional<NoticeEntity> findByUser(Long user);
}
