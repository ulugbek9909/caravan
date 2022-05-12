package com.caravan.caravan.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "trip")
public class TripEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @Lob
    @Column(name = "name")
    private String name;

    @Column(name = "\"maxPeople\"")
    private Integer maxPeople;

    @Column(name = "\"minPeople\"")
    private Integer minPeople;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "guide_id")
    private UUID guideId;

    @Lob
    @Column(name = "phone_number")
    private String phoneNumber;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public Integer getMinPeople() {
        return minPeople;
    }

    public void setMinPeople(Integer minPeople) {
        this.minPeople = minPeople;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getGuideId() {
        return guideId;
    }

    public void setGuideId(UUID guideId) {
        this.guideId = guideId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}