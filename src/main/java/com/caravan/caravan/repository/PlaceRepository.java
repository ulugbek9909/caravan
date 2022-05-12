package com.caravan.caravan.repository;

import com.caravan.caravan.entity.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.UUID;

public interface PlaceRepository extends JpaRepository<PlaceEntity, String> {

    @Transactional
    @Modifying
    @Query(value = "update PlaceEntity set tripCount = tripCount + 1 where UUID =:UUID")
    void updateTripCount(@Param("UUID") UUID id);
}