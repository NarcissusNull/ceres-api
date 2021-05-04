package com.ceres.store.infrastructure;

import com.ceres.store.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
    public Optional<UserEntity> findByNameAndPassword(String name, String password);

    public Optional<UserEntity> findByName(String name);
}
