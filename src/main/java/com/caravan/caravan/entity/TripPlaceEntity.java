package com.caravan.caravan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "trip_place")
@Getter
@Setter
public class TripPlaceEntity extends BaseEntity {

    @Column(name = "trip_id", nullable = false)
    private Long tripId;
    @JoinColumn(name = "trip_id", insertable = false, updatable = false)
    @ManyToOne
    private TripEntity trip;

    @Column(name = "place_id", nullable = false)
    private Long placeId;
    @JoinColumn(name = "place_id", insertable = false, updatable = false)
    @ManyToOne
    private PlaceEntity place;

    @Column(name = "number")
    private Integer number;

}