package com.caravan.caravan.repository;

import com.caravan.caravan.entity.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface DistrictRepository extends JpaRepository<DistrictEntity, Long> {

    Optional<DistrictEntity> findByKey(String key);

//    @Transactional
//    @Modifying
//    @Query("delete from DistrictEntity  where id = :id")
//    int updateVisible(@Param("id") Integer id);
}
