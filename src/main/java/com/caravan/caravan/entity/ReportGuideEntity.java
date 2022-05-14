package com.caravan.caravan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "report_guide")
@Getter
@Setter
public class ReportGuideEntity extends BaseEntity {

    @Column(name = "content")
    private String content;

    @Column(name = "guide_id", nullable = false)
    private Long guideId;
    @JoinColumn(name = "guide_id", insertable = false, updatable = false)
    @ManyToOne
    private GuideEntity guide;

    @Column(name = "profile_id", nullable = false)
    private Long profileId;
    @JoinColumn(name = "profile_id", insertable = false, updatable = false)
    @ManyToOne
    private ProfileEntity profile;

}