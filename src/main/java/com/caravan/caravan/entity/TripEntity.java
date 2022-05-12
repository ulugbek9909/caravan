package com.caravan.caravan.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "trip")
public class TripEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @Lob
    @Column(name = "name")
    private String name;

    @Column(name = "maxPeople")
    private Integer maxPeople;

    @Column(name = "minPeople")
    private Integer minPeople;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "guide_id")
    @ManyToOne
    private GuideProfileEntity guideId;

    @Lob
    @Column(name = "phone_number")
    private String phoneNumber;

}