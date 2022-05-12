package com.caravan.caravan.service;

import com.caravan.caravan.dto.DistrictDTO;
import com.caravan.caravan.entity.DistrictEntity;
import com.caravan.caravan.exceptions.ItemNotFoundException;
import com.caravan.caravan.repository.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DistrictService {

    private DistrictRepository districtRepository;

    public DistrictDTO create(DistrictDTO dto) {

        Optional<DistrictEntity> optional = districtRepository.findByKey(dto.getKey());
        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Item not found");
        }
        DistrictEntity entity = new DistrictEntity();
        entity.setKey(dto.getKey());
        entity.setNameRu(dto.getNameRu());
        entity.setNameUz(dto.getNameUz());
        entity.setNameEn(dto.getNameEn());
        entity.setRegionId(dto.getRegionId());
        entity.setCreatedDate(LocalDateTime.now());
        districtRepository.save(entity);
        dto.setId(entity.getId());
        return toDTO(entity);
    }

    public DistrictDTO update(Integer id, DistrictDTO dto) {

        DistrictEntity entity = districtRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Not Found!"));
        if (entity == null) {
            throw new ItemNotFoundException("Id null");
        }

        entity.setKey(dto.getKey());
        entity.setNameEn(dto.getNameEn());
        entity.setNameUz(dto.getNameUz());
        entity.setNameRu(dto.getNameRu());
        entity.setRegionId(dto.getRegionId());
        districtRepository.save(entity);

        return toDTO(entity);
    }

    public Boolean delete(Integer id) {
        DistrictEntity entity = districtRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Not Found!"));

        if (entity == null) {
            throw new ItemNotFoundException("Not Found!");
        }

        int n = districtRepository.updateVisible(id);
        return n > 0;
    }

    public DistrictDTO getById(Integer id) {
        DistrictEntity entity = districtRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Not Found!"));

        if (entity == null) {
            throw new ItemNotFoundException("Id null");
        }
        return toDTO(entity);
    }

    public DistrictDTO toDTO(DistrictEntity entity) {
        DistrictDTO dto = new DistrictDTO();
        dto.setKey(entity.getKey());
        dto.setNameUz(entity.getNameUz());
        dto.setNameRu(entity.getNameRu());
        dto.setNameEn(entity.getNameEn());
        entity.setRegionId(dto.getRegionId());
        dto.setCreateDate(entity.getCreatedDate());
        dto.setUpdateDate(entity.getUpdatedDate());
        return dto;
    }

}
