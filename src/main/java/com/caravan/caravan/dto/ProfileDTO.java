package com.caravan.caravan.dto;

import com.caravan.caravan.annotation.ValidEmail;
import com.caravan.caravan.enums.ProfileGender;
import com.caravan.caravan.enums.ProfileRole;
import com.caravan.caravan.enums.ProfileStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDTO {

    private UUID id;

    private String name;

    private String surname;

    @ValidEmail
    private String email;
private String phoneNumber;
    private ProfileRole role;

    private ProfileStatus status;
    private ProfileGender gender;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    //attach qolib ketgan
}
