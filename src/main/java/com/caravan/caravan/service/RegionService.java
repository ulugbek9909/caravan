package com.caravan.caravan.service;

import com.caravan.caravan.dto.RegionDTO;
import com.caravan.caravan.entity.RegionEntity;
import com.caravan.caravan.exceptions.ItemNotFoundException;
import com.caravan.caravan.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository repository;

    public RegionDTO create(RegionDTO dto){
        RegionEntity entity= new RegionEntity();
        entity.setId(dto.getId());
        entity.setNameEn(dto.getNameEn());
        entity.setNameRu(dto.getNameRu());
        entity.setNameUz(dto.getNameUz());
        entity.setKey(dto.getKey());
        repository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    public RegionDTO getById(Long id){
        Optional<RegionEntity> optional = repository.findById(id);
        if (optional.isPresent()){
            throw new ItemNotFoundException("Region not found");
        }
        return toDTO(optional.get());
    }

    public List<RegionDTO> getregionDTOList(){
        List<RegionDTO> regionDTOList = new ArrayList<>();
        List<RegionEntity> entities = repository.findAll();
        for (RegionEntity entity:entities) {
            regionDTOList.add(toDTO(entity));
        }
        return regionDTOList;
    }
    public RegionDTO update(Long id,RegionDTO dto){
        Optional<RegionEntity> optional = repository.findById(id);
        if (optional.isPresent()){
            throw new ItemNotFoundException("region not found");
        }

        RegionEntity entity = new RegionEntity();
        entity.setNameUz(dto.getNameUz());
        entity.setNameRu(dto.getNameRu());
        entity.setNameEn(dto.getNameEn());
        repository.save(entity);
        return dto;

    }

    public RegionDTO toDTO(RegionEntity entity){
        RegionDTO dto = new RegionDTO();
        dto.setId(entity.getId());
        dto.setNameEn(entity.getNameEn());
        dto.setNameRu(entity.getNameRu());
        dto.setNameUz(entity.getNameUz());
        dto.setKey(entity.getKey());
        return dto;
    }

    public void deleteById(Long id){
        Optional<RegionEntity> optional = repository.findById(id);
        if (optional.isEmpty()){
            throw new ItemNotFoundException("region not found");
        }
        repository.deleteById(id);
    }

}
