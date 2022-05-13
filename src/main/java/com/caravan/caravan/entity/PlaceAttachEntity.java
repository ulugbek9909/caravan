package com.caravan.caravan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "place_attach")
public class PlaceAttachEntity extends BaseEntity{


    @Column(name = "place_id")
    private Long placeId;

    @Column(name = "attach_id")
    private Long attachId;


}