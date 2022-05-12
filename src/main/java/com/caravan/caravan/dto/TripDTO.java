package com.caravan.caravan.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class TripDTO {
    private UUID id;
    private String name;
    private Integer maxPeople;
    private Integer minPeople;
    private String description;
    private UUID guideId;
    private String phoneNumber;
}
