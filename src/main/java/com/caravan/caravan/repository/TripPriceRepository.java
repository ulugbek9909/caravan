package com.caravan.caravan.repository;

import com.caravan.caravan.entity.TripPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripPriceRepository extends JpaRepository<TripPriceEntity, Long> {
}