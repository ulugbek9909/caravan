package com.caravan.caravan.repository;

import com.caravan.caravan.entity.TripPlace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripPlaceRepository extends JpaRepository<TripPlace, Long> {
}