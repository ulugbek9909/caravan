package com.caravan.caravan.repository;

import com.caravan.caravan.entity.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

public interface DistrictRepository extends JpaRepository<DistrictEntity, UUID> {

    Optional<DistrictEntity> findByKey(String key);

    Optional<DistrictEntity> findById(Integer id);

    @Transactional
    @Modifying
    @Query("delete from ProfileEntity  where id = :id")
    int updateVisible(@Param("id") Integer id);
}
