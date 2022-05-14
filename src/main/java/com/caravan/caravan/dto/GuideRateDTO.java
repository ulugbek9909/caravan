package com.caravan.caravan.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
public class GuideRateDTO {
    private Long id;
    private Long guideId;
    private Long profileId;
    @Min(value = 1,message = "min value 1")
    @Max(value = 5,message = "max value 5")
    private Integer mark;
}
