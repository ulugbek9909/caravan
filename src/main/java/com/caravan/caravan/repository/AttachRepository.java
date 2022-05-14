package com.caravan.caravan.repository;

import com.caravan.caravan.entity.AttachEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AttachRepository extends JpaRepository<AttachEntity, UUID> {
}