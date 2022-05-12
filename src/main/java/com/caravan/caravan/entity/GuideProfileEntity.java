package com.caravan.caravan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "guide_profile")
public class GuideProfileEntity extends BaseEntity {
    @Column(unique = true)
    private String phoneNumber;
    @Column(columnDefinition = "text")
    private String content;
    @Column
    private Boolean isHiring;
    @Column
    private Double guideRate;

    @Column(name = "profile_id")
    private String profileId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", insertable = false, updatable = false)
    ProfileEntity profile;
}