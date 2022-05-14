package com.caravan.caravan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "trip_price")
public class TripPriceEntity extends BaseEntity{

    @Column(name = "trip_id")
    private Long tripId;

    @Lob
    @Column(name = "price_type")
    private String priceType;

    @Column(name = "price")
    private Double price;


}