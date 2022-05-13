package com.caravan.caravan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "trip_place")
public class TripPlace extends BaseEntity{
    @Column(name = "trip_id")
    private Long tripId;

    @Column(name = "place_id")
    private Long placeId;

    @Column(name = "number")
    private Integer number;

}