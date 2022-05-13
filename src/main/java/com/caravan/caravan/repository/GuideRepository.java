package com.caravan.caravan.repository;

import com.caravan.caravan.entity.GuideEntity;
import com.caravan.caravan.enums.GuideStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface GuideRepository extends JpaRepository<GuideEntity, Long> {

    Optional<GuideEntity> findByProfileId(Long profileId);


    @Transactional
    @Modifying
    @Query("update GuideEntity set activity = :activity where id = :id")
    int updateStatus(@Param("activity") GuideStatus activity, @Param("id") Long id);

}