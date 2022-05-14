package com.caravan.caravan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "district")
@Getter
@Setter
public class DistrictEntity extends BaseEntity {

    @Column(columnDefinition = "text")
    private String district;

    @Column(name = "region_id")
    private Long regionId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", insertable = false, updatable = false)
    private RegionEntity region;

}