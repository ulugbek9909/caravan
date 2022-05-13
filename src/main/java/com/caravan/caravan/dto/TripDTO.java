package com.caravan.caravan.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TripDTO {

    private Long id;

    @NotBlank(message = "Name required")
    private String name;

    private Integer maxPeople;

    private Integer minPeople;

    private String description;

    private Long guideId;

    private String phoneNumber;
}
