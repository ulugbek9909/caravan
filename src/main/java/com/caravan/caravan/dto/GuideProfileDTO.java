package com.caravan.caravan.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class GuideProfileDTO {
    private UUID id;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String phoneNumber;
    private String content;
    private Boolean isHiring;
    private Double guideRate;
    private String profileId;
}
