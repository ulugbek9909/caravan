package com.caravan.caravan.service;

import com.caravan.caravan.dto.PlaceDTO;
import com.caravan.caravan.entity.PlaceEntity;
import com.caravan.caravan.exceptions.ItemNotFoundException;
import com.caravan.caravan.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
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
        entity.setDistrictId(UUID.fromString(dto.getDistrictId()));

        repository.save(entity);
        return toDTO(entity);
    }

    public PageImpl<PlaceDTO> list(int page, int size, String id) {
        Pageable pageable = PageRequest.of(page, size);

        Page<PlaceEntity> entityList = repository.findAllByDistrictId(UUID.fromString(id), pageable);
        List<PlaceDTO> dtoList = new LinkedList<>();

        entityList.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });
        return new PageImpl<>(dtoList, pageable, entityList.getTotalElements());
    }

    public PlaceDTO update(String id, PlaceDTO dto) {
        PlaceEntity entity = getById(id);
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());

        repository.save(entity);
        return toDTO(entity);
    }

    public Boolean delete(String id) {
        PlaceEntity entity = getById(id);
        repository.delete(entity);
        return true;
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
