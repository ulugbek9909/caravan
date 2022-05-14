package com.caravan.caravan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "place_attach")
public class PlaceAttachEntity extends BaseEntity{


    @Column(name = "place_id")
    private Long placeId;

    @Column(name = "attach_id")
    private Long attachId;


}