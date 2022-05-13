package com.caravan.caravan.entity;

import com.caravan.caravan.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "admin")
@Getter
@Setter
public class AdminEntity extends BaseEntity{

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "shortDesc")
    private String shortDesc;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "gender")
    private Gender gender;

}