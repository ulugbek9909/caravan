package com.caravan.caravan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "facility")
@Getter
@Setter
public class FacilityEntity extends BaseEntity {

    @Column(name = "title")
    private String title;


    @Column(name = "description")
    private String description;


    @Column(name = "trip_id", nullable = false)
    private Long tripId;
    @JoinColumn(name = "trip_id", insertable = false, updatable = false)
    @ManyToOne
    private TripEntity trip;

}