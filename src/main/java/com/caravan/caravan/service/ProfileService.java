package com.caravan.caravan.service;

import com.caravan.caravan.dto.ProfileDTO;
import com.caravan.caravan.entity.ProfileEntity;
import com.caravan.caravan.enums.ProfileRole;
import com.caravan.caravan.enums.ProfileStatus;
import com.caravan.caravan.exceptions.ItemAlreadyExistsExceptions;
import com.caravan.caravan.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileService {
    private final ProfileRepository repository;


    public ProfileDTO create(ProfileDTO dto){
        Optional<ProfileEntity> profile = repository.findByPhoneNumber(dto.getPhoneNumber());
        if (profile.isPresent()) throw new ItemAlreadyExistsExceptions("item all ready exists!");

        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setStatus(ProfileStatus.ACTIVE);
        entity.setSurname(dto.getSurname());
        entity.setRole(ProfileRole.TOURIST);
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setGender(dto.getGender());
        return  null;
    }
}
