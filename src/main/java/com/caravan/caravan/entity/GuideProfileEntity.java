package com.caravan.caravan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "guide_profile")
public class GuideProfileEntity extends BaseEntity {
    @Column
    private String phoneNumber;
    @Column(columnDefinition = "text")
    private String content;

}