package com.caravan.caravan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "facility")
public class FacilityEntity extends BaseEntity {

    @Column(name = "title")
    private String title;


    @Column(name = "description")
    private String description;

    @Column(name = "trip_id")
    private Long tripId;

}