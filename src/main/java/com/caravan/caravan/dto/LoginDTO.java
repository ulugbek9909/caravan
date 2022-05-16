package com.caravan.caravan.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class LoginDTO {
    @NotBlank
    @Size(min = 10,max = 20,message = "phone number not valid!")
    private String phoneNumber;

}
