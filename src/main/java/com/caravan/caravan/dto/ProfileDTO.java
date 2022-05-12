package com.caravan.caravan.dto;

import com.caravan.caravan.annotation.ValidEmail;
import com.caravan.caravan.enums.ProfileGender;
import com.caravan.caravan.enums.ProfileRole;
import com.caravan.caravan.enums.ProfileStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDTO {

    private UUID id;
    @NotBlank(message = "name is required!!")
    private String name;
    @NotBlank(message = "surname is required!!")
    @Size(min = 4,max = 30,message = "surname size(4-30) required!!")
    private String surname;
    @ValidEmail(message = "email is required")
    @Size(min = 4,max = 50,message = "email size(4-50)  valid!!")
    private String email;
    @NotBlank(message = "phone number is required")
    private String phoneNumber;
    private ProfileRole role;
    private ProfileStatus status;
    private ProfileGender gender;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    //attach qolib ketgan
}
