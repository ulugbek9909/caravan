package com.caravan.caravan.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ReviewTripDTO extends BaseDTO {

    @NotBlank(message = "content not valid")
    private String content;
    @NotNull
    private Long tripId;
    @NotNull
    private Long profileId;

}
