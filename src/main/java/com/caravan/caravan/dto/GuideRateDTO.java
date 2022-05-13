package com.caravan.caravan.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GuideRateDTO {
    private Long id;
    private Long guideId;
    private Long profileId;
    private Integer mark;
}
