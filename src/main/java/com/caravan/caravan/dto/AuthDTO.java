package com.caravan.caravan.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthDTO {

    @NotBlank(message = "phoneNumber not valid")
    @Size(min = 5,max = 25,message = "phoneNumber not valid")
    private String phoneNumber;
}
