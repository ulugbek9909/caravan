package com.caravan.caravan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "guide_location")
@Getter
@Setter
public class GuideLocationEntity extends BaseEntity {

    @Column(name = "guide_id", nullable = false)
    private Long guideId;
    @JoinColumn(name = "guide_id", insertable = false, updatable = false)
    @ManyToOne
    private PlaceEntity place;

    @Column(name = "district_id", nullable = false)
    private Long districtId;
    @JoinColumn(name = "district_id", insertable = false, updatable = false)
    @ManyToOne
    private DistrictEntity district;

}