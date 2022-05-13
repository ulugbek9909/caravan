package com.caravan.caravan.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TripPlaceDTO {
    private Long id;
    private Long tripId;
    private Long placeId;
    private Integer number;
}
