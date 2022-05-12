package com.caravan.caravan.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "region")
@Entity
@Data
public class RegionEntity extends BaseEntity {

    @Column(name = "nameUz")
    private String nameUz;
    @Column(name = "nameRu")
    private String nameRu;
    @Column(name = "nameEn")
    private String nameEn;
    @Column(name = "key")
    private String key;

}
