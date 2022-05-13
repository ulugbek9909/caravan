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

    private Long id;

    @NotBlank(message = "Name is required!!")
    private String name;

    @NotBlank(message = "Surname is required!!")
    private String surname;

    @ValidEmail(message = "Email is required")
    private String email;

    @NotBlank(message = "Phone Number is required")
    private String phoneNumber;

    private ProfileRole role;

    private ProfileStatus status;

    private ProfileGender gender;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private String photoId; // ATTACH UUID
    private AttachDTO photo;

}
