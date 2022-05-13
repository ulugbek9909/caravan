package com.caravan.caravan.entity;

import com.caravan.caravan.enums.GuideStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "guide")
public class GuideEntity extends BaseEntity {

    @Column(unique = true)
    private String secondPhoneNumber; // OPTIONAL

    @Column(columnDefinition = "text")
    private String biography;

    @Column
    private GuideStatus activity;

    @Column
    private Double guideRate;

    @Column(name = "profile_id")
    private Long profileId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", insertable = false, updatable = false)
    private ProfileEntity profile;
}