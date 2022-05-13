package com.caravan.caravan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "facility")
public class FacilityEntity extends BaseEntity {

    @Column(name = "title")
    private String title;


    @Column(name = "description")
    private String description;

    @Column(name = "trip_id")
    private Long tripId;

}