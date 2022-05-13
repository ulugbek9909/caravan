package com.caravan.caravan.service;

import com.caravan.caravan.dto.PlaceDTO;
import com.caravan.caravan.entity.PlaceEntity;
import com.caravan.caravan.exceptions.ItemNotFoundException;
import com.caravan.caravan.repository.PlaceAttachRepository;
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
    private final DistrictService districtService;
    private final PlaceAttachRepository placeAttachRepository;

    public PlaceDTO create(PlaceDTO dto) {
        districtService.getById(dto.getId());

        PlaceEntity entity = ConverterService.convertToEntity(dto);

        repository.save(entity);
        return ConverterService.convertToDTO(entity);
    }

    public PlaceDTO get(Long districtId) {
        return ConverterService.convertToDTO(getById(districtId));
    }

    public PageImpl<PlaceDTO> list(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<PlaceEntity> entityList = repository.findAll(pageable);
        List<PlaceDTO> dtoList = new LinkedList<>();

        entityList.forEach(entity -> dtoList.add(ConverterService.convertToDTO(entity)));
        return new PageImpl<>(dtoList, pageable, entityList.getTotalElements());
    }

    public PageImpl<PlaceDTO> listByDistrictId(int page, int size, Long districtId) {
        Pageable pageable = PageRequest.of(page, size);

        Page<PlaceEntity> entityList = repository.findAllByDistrictId(districtId, pageable);
        List<PlaceDTO> dtoList = new LinkedList<>();

        entityList.forEach(entity -> {
            dtoList.add(ConverterService.convertToDTO(entity));
        });
        return new PageImpl<>(dtoList, pageable, entityList.getTotalElements());
    }

    public PlaceDTO update(Long id, PlaceDTO dto) {
        PlaceEntity entity = getById(id);
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());

        repository.save(entity);
        return ConverterService.convertToDTO(entity);
    }

    public Boolean delete(Long id) {
        PlaceEntity entity = getById(id);
        repository.delete(entity);
        return true;
    }

    public PlaceEntity getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Not found {}", id);
                    throw new ItemNotFoundException("Not found!");
                });
    }
}
