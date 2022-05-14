package com.caravan.caravan.repository;

import com.caravan.caravan.entity.TripPlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripPlaceRepository extends JpaRepository<TripPlaceEntity, Long> {
}