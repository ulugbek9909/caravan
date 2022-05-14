package com.caravan.caravan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "place_attach")
@Getter
@Setter
public class PlaceAttachEntity extends BaseEntity {


    @Column(name = "place_id", nullable = false)
    private Long placeId;
    @JoinColumn(name = "place_id", insertable = false, updatable = false)
    @ManyToOne
    private PlaceEntity place;

    @Column(name = "attach_id", nullable = false)
    private Long attachId;
    @JoinColumn(name = "attach_id", insertable = false, updatable = false)
    @ManyToOne
    private AttachEntity attach;


}