package com.caravan.caravan.entity;

import com.caravan.caravan.enums.Gender;
import com.caravan.caravan.enums.ProfileRole;
import com.caravan.caravan.enums.ProfileStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "profile")
@Getter
@Setter
public class ProfileEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private ProfileRole role;

    @Column
    @Enumerated(EnumType.STRING)
    private ProfileStatus status;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "photo_id")
    private UUID photoId; // TODO: ATTACH UUID
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "photo_id", updatable = false, insertable = false)
    private AttachEntity photo;

}