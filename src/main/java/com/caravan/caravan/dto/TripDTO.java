package com.caravan.caravan.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TripDTO {
    private UUID id;
    private String name;
    private Integer maxPeople;
    private Integer minPeople;
    private String description;
    private UUID guideId;
    private String phoneNumber;
}
