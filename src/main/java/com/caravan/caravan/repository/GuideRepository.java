package com.caravan.caravan.repository;

import com.caravan.caravan.entity.GuideEntity;
import com.caravan.caravan.enums.GuideStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface GuideRepository extends JpaRepository<GuideEntity, Long> {

    @Transactional
    @Modifying
    @Query("update GuideEntity set isHiring = :isHiring where id = :id")
    int updateStatus(@Param("isHiring") GuideStatus isHiring, @Param("id") Long id);

}