package com.caravan.caravan.dto;

import com.caravan.caravan.enums.Gender;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminDTO extends BaseDTO{

    private String username;

    private String email;

    private String password;

    private String phoneNumber;

    private String shortDesc;

    private LocalDate birthdate;

    private String name;

    private String surname;

    private Gender gender;
}
