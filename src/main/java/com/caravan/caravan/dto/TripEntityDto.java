package com.caravan.caravan.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class TripEntityDto{
    private UUID id;
    private String name;
    private Integer maxPeople;
    private Integer minPeople;
    private String description;
    private UUID guideId;
    private String phoneNumber;
}
