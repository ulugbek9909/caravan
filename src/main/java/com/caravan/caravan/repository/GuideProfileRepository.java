package com.caravan.caravan.repository;

import com.caravan.caravan.entity.GuideProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GuideProfileRepository extends JpaRepository<GuideProfileEntity, UUID> {

}