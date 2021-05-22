package com.ceres.store.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "GOODS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoodsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String main;
    BigDecimal price;
    @Column(name = "[type]")
    Long type;
    @Column(name = "[describe]")
    String describe;

    @CreationTimestamp
    Date createdAt;
    @UpdateTimestamp
    Date updatedAt;
    
    @Column(name="deleted",columnDefinition="tinyint default 0")
    boolean deleted;

    @Column(name="[rate]", columnDefinition="DECIMAL(10,2) DEFAULT 1.0")
    @ColumnDefault("1.0")
    BigDecimal rate;
}
