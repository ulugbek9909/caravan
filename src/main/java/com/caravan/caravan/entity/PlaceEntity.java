package com.caravan.caravan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "place")
@Getter
@Setter
public class PlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "text", nullable = false)
    private String description;

    @Column(name = "district_id")
    private String districtId;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "district_id", updatable = false, insertable = false)
//    private DistrictEntity district;

    @Column
    private Integer tripCount = 0;
}
