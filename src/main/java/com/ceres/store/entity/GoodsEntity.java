package com.ceres.store.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "GOODS")
public class GoodsEntity {

    @Id
    Long id;
    String name;
    BigDecimal price;
    Long type;
    String describe;
    Date createdAt;
    Date updatedAt;
}
