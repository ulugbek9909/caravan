package com.caravan.caravan.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class GuideProfileDTO {
    private UUID id;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    @NotNull(message = "Phone number Required!")
    private String phoneNumber;
    @NotNull(message = "Content Required!")
    private String content;
    private Boolean isHiring;
    private Double guideRate;
    private String profileId;
}
