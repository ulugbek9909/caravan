package com.caravan.caravan.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlaceDTO {

    private String UUID;

    @NotBlank(message = "Title required")
    private String title;

    @NotBlank(message = "Description required")
    private String description;

    private String districtId;

    private Integer tripCount;
}
