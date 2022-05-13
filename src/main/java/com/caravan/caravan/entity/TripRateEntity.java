package com.caravan.caravan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "trip_rate")
public class TripRateEntity extends BaseEntity{
    @Column(name = "profile_id")
    private Long profileId;

    @Column(name = "trip_id")
    private Long tripId;

    @Column(name = "mark")
    private Integer mark;


}