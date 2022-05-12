package com.caravan.caravan.repository;

import com.caravan.caravan.entity.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TripRepository extends JpaRepository<TripEntity, UUID> {
}
