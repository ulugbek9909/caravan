package com.caravan.caravan.entity;

import com.caravan.caravan.enums.SocialType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "social_network", uniqueConstraints = @UniqueConstraint(columnNames = {"type", "guideId"}))
@Getter
@Setter
public class SocialNetworkEntity extends BaseEntity {

    @Column(name = "type")
    private SocialType type;

    @Column(name = "link")
    private String link;

    @Column(name = "guide_id")
    private Long guideId;
    @JoinColumn(name = "guide_id", insertable = false, updatable = false)
    @ManyToOne
    private GuideEntity guide;

}