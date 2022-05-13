package com.caravan.caravan.repository;

import com.caravan.caravan.entity.SocialNetworkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialRepository extends JpaRepository<SocialNetworkEntity,Long> {
}
