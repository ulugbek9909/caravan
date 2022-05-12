package com.caravan.caravan.service;

import com.caravan.caravan.dto.GuideProfileDTO;
import com.caravan.caravan.entity.GuideProfileEntity;
import com.caravan.caravan.exceptions.ItemAlreadyExistsException;
import com.caravan.caravan.repository.GuideProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class GuideProfileService {
    private final GuideProfileRepository repository;

    public GuideProfileDTO create(GuideProfileDTO dto) {
        var optional = repository.findByPhoneNumber(dto.getPhoneNumber());

        if (optional.isPresent())
            throw new ItemAlreadyExistsException("Guide already exists!");

        var entity = new GuideProfileEntity();

        entity.setProfileId(dto.getProfileId());
        entity.setGuideRate(dto.getGuideRate());
        entity.setContent(dto.getContent());
        entity.setIsHiring(dto.getIsHiring());

        repository.save(entity);

        dto.setId(entity.getId());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setUpdatedDate(entity.getUpdatedDate());

        return dto;
    }

    public GuideProfileDTO getById(String uuid) {
        Optional<GuideProfileEntity> optional = repository.findById(UUID.fromString(uuid));

        if (optional.isPresent()) {
            throw new
        }
    }
}
