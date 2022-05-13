package com.caravan.caravan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "guid_location")
public class GuidLocationEntity extends BaseEntity{
    @Column(name = "guid_id")
    private Long guidId;

    @Column(name = "district_id")
    private Long districtId;

}