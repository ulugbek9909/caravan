package com.caravan.caravan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.lang.Long;

@Entity
@Table(name = "review_guide")
public class ReviewGuideEntity extends BaseEntity {

    @Column(name = "content")
    private String content;

    @Column(name = "guide_id")
    private Long guideId;

    @Column(name = "profile_id")
    private Long profileId;


    @Column(name = "type")
    private String type;

}