package com.caravan.caravan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "place_attach")
public class PlaceAttach extends BaseEntity{


    @Column(name = "place_id")
    private Long placeId;

    @Column(name = "attach_id")
    private Long attachId;


}