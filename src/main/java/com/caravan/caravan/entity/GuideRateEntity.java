package com.caravan.caravan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "guide_rate")
public class GuideRateEntity extends BaseEntity{
    @Column(name = "guide_id")
    private Long guideId;

    @Column(name = "profile_id")
    private Long profileId;

    @Column(name = "mark")
    private Integer mark;


}