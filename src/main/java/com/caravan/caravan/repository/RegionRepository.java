package com.caravan.caravan.repository;

import com.caravan.caravan.entity.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<RegionEntity,Long> {


    Optional<RegionEntity> findByNameEn(String  nameEn);

    Optional<RegionEntity> findByNameRu(String  nameRu);

    Optional<RegionEntity> findByNameUz(String  nameUz);



}

