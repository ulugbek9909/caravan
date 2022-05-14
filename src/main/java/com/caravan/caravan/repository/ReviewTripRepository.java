package com.caravan.caravan.repository;

import com.caravan.caravan.entity.ReviewTripEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewTripRepository extends JpaRepository<ReviewTripEntity, Long> {

    int deleteByProfileIdAndTripId(Long pId,Long tripId);

    Page<ReviewTripEntity> findAllByTripId(Long tripId, Pageable pageable);
}