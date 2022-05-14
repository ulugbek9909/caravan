package com.caravan.caravan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "trip_place")
public class TripPlace extends BaseEntity{
    @Column(name = "trip_id")
    private Long tripId;

    @Column(name = "place_id")
    private Long placeId;

    @Column(name = "number")
    private Integer number;

}