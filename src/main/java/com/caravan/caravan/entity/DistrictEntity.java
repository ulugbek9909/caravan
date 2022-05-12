package com.caravan.caravan.entity;

import com.caravan.caravan.dto.RegionDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "district")
@Slf4j
public class DistrictEntity extends BaseEntity{
    @Column(name = "name_uz")
    private String nameUz;
    @Column(name = "name_ru")
    private String nameRu;
    @Column(name = "name_en")
    private String nameEn;
    @Column(name = "nkey")
    private String key;
    @Column(name = "region_id")
    private RegionDTO regionId;


}