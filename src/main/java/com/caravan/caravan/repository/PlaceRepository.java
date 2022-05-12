package com.caravan.caravan.repository;

import com.caravan.caravan.entity.PlaceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.UUID;

public interface PlaceRepository extends JpaRepository<PlaceEntity, UUID> {


    Page<PlaceEntity> findAllByDistrictId(UUID districtId, Pageable pageable);
    @Transactional
    @Modifying
    @Query(value = "update PlaceEntity set tripCount = tripCount + 1 where id =:id")
    void updateTripCount(@Param("UUID") UUID id);
}