package com.caravan.caravan.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ReviewTripDTO {
    private Long id;
    private LocalDateTime createdDate;
    private String content;
    private Long tripId;
    private Long profileId;
    private String type;
}
