package com.caravan.caravan.entity;

import com.caravan.caravan.enums.ReviewType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "review_trip")
public class ReviewTripEntity extends BaseEntity {

    @Column(name = "content")
    private String content;

    @Column(name = "trip_id", nullable = false)
    private Long tripId;
    @JoinColumn(name = "trip_id", insertable = false, updatable = false)
    @ManyToOne
    private TripEntity trip;

    @Column(name = "profile_id", nullable = false)
    private Long profileId;
    @JoinColumn(name = "profile_id", insertable = false, updatable = false)
    @ManyToOne
    private ProfileEntity profile;

    // TODO: 14-May-22 Reply masalasi
//    @Column(name = "type")
//    private ReviewType type;
//
//    @Column(name = "reply_id")
//    private Long replyId;
//    @JoinColumn(name = "reply_id", insertable = false, updatable = false)
//    @ManyToOne
//    private ReviewTripEntity reply;

}