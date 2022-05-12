package com.caravan.caravan.service;

import com.caravan.caravan.dto.PlaceDTO;
import com.caravan.caravan.entity.PlaceEntity;
import com.caravan.caravan.exceptions.ItemNotFoundException;
import com.caravan.caravan.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository repository;

    public PlaceDTO create(PlaceDTO dto) {
        PlaceEntity entity = new PlaceEntity();
        entity.setTitle(dto.getTitle());
        entity.setDescription(entity.getDescription());
        entity.setDistrictId(dto.getDistrictId());

        repository.save(entity);
        return toDTO(entity);
    }

    public PlaceDTO toDTO(PlaceEntity entity) {
        PlaceDTO dto = new PlaceDTO();
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setTripCount(entity.getTripCount());
        return dto;
    }

    public PlaceEntity getById(String id) {
        return repository.findById(UUID.fromString(id))
                .orElseThrow(() -> {
                    log.warn("Not found {}", id);
                    throw new ItemNotFoundException("Not found!");
                });
    }
}
