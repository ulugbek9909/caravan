package com.caravan.caravan.dto;

import com.caravan.caravan.enums.GuideStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GuideDTO extends BaseDTO {

    // TODO: 14-May-22 optional boladigan boldi
//    @NotNull(message = "Phone Number required")
    private String secondPhoneNumber;

    // TODO: 14-May-22 optional boladigan boldi
//    @NotNull(message = "Biography required")
    private String biography;

    private GuideStatus activity;

    private Double guideRate;

    private Long profileId;

}
