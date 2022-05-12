package com.caravan.caravan.repository;

import com.caravan.caravan.entity.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DistrictRepository extends JpaRepository<DistrictEntity, UUID> {

    Optional<DistrictEntity> findByKey(String key);
}
