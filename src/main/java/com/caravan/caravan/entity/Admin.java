package com.caravan.caravan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "\"Admin\"")
public class Admin extends BaseEntity{
    @Lob
    @Column(name = "username")
    private String username;

    @Lob
    @Column(name = "email")
    private String email;

    @Lob
    @Column(name = "password")
    private String password;

    @Lob
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Lob
    @Column(name = "\"shortDesc\"")
    private String shortDesc;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Lob
    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "surname")
    private String surname;

    @Lob
    @Column(name = "gender")
    private String gender;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}