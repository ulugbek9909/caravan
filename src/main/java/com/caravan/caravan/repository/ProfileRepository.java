package com.caravan.caravan.repository;

import com.caravan.caravan.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
    Optional<ProfileEntity> findByPhoneNumber(String phoneNumber);

    @Transactional
    @Modifying
    @Query("update ProfileEntity set photoId = :photoId where id = :id")
    int updateImage(@Param("photoId") UUID photoId,@Param("id") Long id);


}
