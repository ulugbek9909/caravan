package com.caravan.caravan.repository;

import com.caravan.caravan.entity.GuideRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuideRateRepository extends JpaRepository<GuideRateEntity, Long> {

    Optional<GuideRateEntity>  findByProfileIdAndGuideId(Long pId,Long guideId);
}