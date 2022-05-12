package com.caravan.caravan.service;

import com.caravan.caravan.dto.GuideProfileDTO;
import com.caravan.caravan.entity.GuideProfileEntity;
import com.caravan.caravan.exceptions.ItemAlreadyExistsException;
import com.caravan.caravan.exceptions.ItemNotFoundException;
import com.caravan.caravan.repository.GuideProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        GuideProfileEntity entity = repository.findById(UUID.fromString(uuid)).orElseThrow(() -> new ItemNotFoundException("Guide not Found!"));
        return toDTO(entity);
    }

    public GuideProfileDTO update(GuideProfileDTO dto, String uuid) {
        GuideProfileEntity entity = repository.findById(UUID.fromString(uuid)).orElseThrow(() -> new ItemNotFoundException("Guide not Found!"));

        entity.setProfileId(entity.getProfileId());
        entity.setPhoneNumber(entity.getPhoneNumber());
        entity.setIsHiring(dto.getIsHiring());
        entity.setGuideRate(dto.getGuideRate());
        entity.setUpdatedDate(LocalDateTime.now());
        entity.setContent(dto.getContent());

        repository.save(entity);
        dto.setCreatedDate(entity.getCreatedDate());

        return dto;
    }

    private GuideProfileDTO toDTO(GuideProfileEntity entity) {
        var dto = new GuideProfileDTO();

        dto.setProfileId(entity.getProfileId());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setContent(entity.getContent());
        dto.setIsHiring(entity.getIsHiring());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setId(entity.getId());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setGuideRate(entity.getGuideRate());

        return dto;
    }
}
