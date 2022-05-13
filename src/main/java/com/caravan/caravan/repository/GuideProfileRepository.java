package com.caravan.caravan.repository;

import com.caravan.caravan.entity.GuideEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface GuideProfileRepository extends JpaRepository<GuideEntity, UUID> {
    Optional<GuideEntity> findByPhoneNumber(String phoneNumber);
}