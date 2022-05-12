package com.caravan.caravan.repository;
import com.caravan.caravan.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;


public interface ProfileRepository extends JpaRepository<ProfileEntity, UUID> {
    Optional<ProfileEntity> findByPhoneNumber(String phoneNumber);
}
