package com.caravan.caravan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "social_network")
@Getter
@Setter
public class SocialNetworkEntity extends BaseEntity{

    @Column(name = "type")
    private String type;

    @Column(name = "link")
    private String link;

    @Column(name = "guide_id")
    private Long guideId;

}