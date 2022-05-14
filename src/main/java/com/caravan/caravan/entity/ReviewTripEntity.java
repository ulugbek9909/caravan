package com.caravan.caravan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;
import java.util.UUID;
@Entity
@Getter
@Setter
@Table(name = "review_trip")
public class ReviewTripEntity extends BaseEntity {

    @Column(name = "content")
    private String content;

    @Column(name = "trip_id")
    private Long tripId;

    @Column(name = "profile_id")
    private Long profileId;

    @Column(name = "type")
    private String type;


    //TODO  create,getTripId,delete(owner)

    //TODO   for admin getProfileId,getTripId

}