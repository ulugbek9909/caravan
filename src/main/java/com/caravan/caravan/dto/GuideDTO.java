package com.caravan.caravan.dto;

import com.caravan.caravan.enums.GuideStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class GuideDTO extends BaseDTO {

    @NotNull(message = "Phone Number required")
    private String secondPhoneNumber;

    @NotNull(message = "Biography required")
    private String biography;

    private GuideStatus isHiring;

    private Double guideRate;

    private String profileId;

}
