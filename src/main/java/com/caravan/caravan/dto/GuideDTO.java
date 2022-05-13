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

    @NotNull(message = "Phone Number required")
    private String secondPhoneNumber;

    @NotNull(message = "Biography required")
    private String biography;

    private GuideStatus isHiring;

    private Double guideRate;

    private String profileId;

}
