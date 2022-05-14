package com.caravan.caravan.entity;

import com.caravan.caravan.enums.PriceType;
import com.caravan.caravan.enums.TripType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "trip_price")
@Getter
@Setter
public class TripPriceEntity extends BaseEntity {

    @Column(name = "trip_id", nullable = false)
    private Long tripId;
    @JoinColumn(name = "trip_id", insertable = false, updatable = false)
    @ManyToOne
    private TripEntity trip;

    @Column(name = "trip_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TripType tripType;

    @Column(name = "price_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private PriceType priceType;

    @Column(name = "price")
    private Long price;

}