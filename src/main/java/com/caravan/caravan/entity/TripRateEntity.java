package com.caravan.caravan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "trip_rate")
@Getter
@Setter
public class TripRateEntity extends BaseEntity {

    @Column(name = "profile_id", nullable = false)
    private Long profileId;
    @JoinColumn(name = "profile_id", insertable = false, updatable = false)
    @ManyToOne
    private ProfileEntity profile;

    @Column(name = "trip_id", nullable = false)
    private Long tripId;
    @JoinColumn(name = "trip_id", insertable = false, updatable = false)
    @ManyToOne
    private TripEntity trip;

    @Column(name = "mark")
    private Integer mark;

}