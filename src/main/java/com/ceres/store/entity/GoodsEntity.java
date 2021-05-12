package com.ceres.store.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
    Date createdAt;
    Date updatedAt;
    
    @Column(name="deleted",columnDefinition="tinyint default 0")
    boolean deleted;
}
