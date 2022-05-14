package com.caravan.caravan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Table(name = "trip")
@Setter
@Entity
public class TripEntity extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "maxPeople")
    private Integer maxPeople;

    @Column(name = "minPeople")
    private Integer minPeople;

    @Column(name = "description")
    private String description;

    @Column(name = "guide_id")
    private Long guideId;
    @JoinColumn(name = "guide_id", updatable = false, insertable = false)
    @ManyToOne
    private GuideEntity guide;

    @Column(name = "phone_number")
    private String phoneNumber;

}