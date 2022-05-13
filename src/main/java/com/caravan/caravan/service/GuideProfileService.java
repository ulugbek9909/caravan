package com.caravan.caravan.service;

import com.caravan.caravan.dto.GuideDTO;
import com.caravan.caravan.entity.GuideEntity;
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
//    private final GuideProfileRepository repository;
//
//    public GuideDTO create(GuideDTO dto) {
//        var optional = repository.findByPhoneNumber(dto.getPhoneNumber());
//
//        if (optional.isPresent())
//            throw new ItemAlreadyExistsException("Guide already exists!");
//
//        var entity = new GuideEntity();
//
//        entity.setProfileId(dto.getProfileId());
//        entity.setGuideRate(dto.getGuideRate());
//        entity.setContent(dto.getContent());
//        entity.setIsHiring(dto.getIsHiring());
//
//        repository.save(entity);
//
//        dto.setId(entity.getId());
//        dto.setCreatedDate(entity.getCreatedDate());
//        dto.setUpdatedDate(entity.getUpdatedDate());
//
//        return dto;
//    }
//
//    public GuideDTO getById(String uuid) {
//        GuideEntity entity = repository.findById(UUID.fromString(uuid)).orElseThrow(() -> new ItemNotFoundException("Guide not Found!"));
//        return toDTO(entity);
//    }
//
//    public GuideDTO update(GuideDTO dto, String uuid) {
//        GuideEntity entity = repository.findById(UUID.fromString(uuid)).orElseThrow(() -> new ItemNotFoundException("Guide not Found!"));
//
//        entity.setProfileId(entity.getProfileId());
//        entity.setPhoneNumber(entity.getPhoneNumber());
//        entity.setIsHiring(dto.getIsHiring());
//        entity.setGuideRate(dto.getGuideRate());
//        entity.setUpdatedDate(LocalDateTime.now());
//        entity.setContent(dto.getContent());
//
//        repository.save(entity);
//        dto.setCreatedDate(entity.getCreatedDate());
//
//        return dto;
//    }
//
//    public Boolean deleteById(String uuid) {
//        GuideEntity entity = repository.findById(UUID.fromString(uuid)).orElseThrow(() -> new ItemNotFoundException("Guide not Found!"));
//
//        repository.delete(entity);
//
//        return true;
//    }
//
//
//    private GuideDTO toDTO(GuideEntity entity) {
//        var dto = new GuideDTO();
//
//        dto.setProfileId(entity.getProfileId());
//        dto.setCreatedDate(entity.getCreatedDate());
//        dto.setContent(entity.getContent());
//        dto.setIsHiring(entity.getIsHiring());
//        dto.setPhoneNumber(entity.getPhoneNumber());
//        dto.setId(entity.getId());
//        dto.setUpdatedDate(entity.getUpdatedDate());
//        dto.setGuideRate(entity.getGuideRate());
//
//        return dto;
//    }
}
