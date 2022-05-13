package com.caravan.caravan.service;

import com.caravan.caravan.dto.GuideDTO;
import com.caravan.caravan.entity.GuideEntity;
import com.caravan.caravan.enums.GuideStatus;
import com.caravan.caravan.exceptions.ItemAlreadyExistsException;
import com.caravan.caravan.exceptions.ItemNotFoundException;
import com.caravan.caravan.repository.GuideRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class GuideService {

    private final GuideRepository repository;


    public GuideDTO create(GuideDTO dto) {
        var entity = new GuideEntity();

        entity.setProfileId(dto.getProfileId());
        entity.setGuideRate(0d);
        entity.setBiography(dto.getBiography());
        entity.setIsHiring(GuideStatus.ACTIVE);

        repository.save(entity);

        return ConverterService.convertToDTO(entity);
    }

    public GuideDTO update(GuideDTO dto, Long id) {
        GuideEntity entity = getById(id);

        entity.setBiography(dto.getBiography());
        entity.setUpdatedDate(LocalDateTime.now());

        repository.save(entity);

        return ConverterService.convertToDTO(entity);
    }

    public Boolean delete(Long id) {
        GuideEntity entity = getById(id);
        repository.delete(entity);
        return true;
    }

    public GuideEntity getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Not found {}", id);
                    return new ItemNotFoundException("Guide not Found!")
                });
    }
}
