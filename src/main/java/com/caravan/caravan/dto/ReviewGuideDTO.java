package com.caravan.caravan.dto;

import lombok.Data;

@Data
public class ReviewGuideDTO {
    private Long id;
    private String content;
    private Long guideId;
    private Long profileId;
    private String type;
}
