package com.caravan.caravan.service;

import com.caravan.caravan.dto.DistrictDTO;
import com.caravan.caravan.entity.DistrictEntity;
import com.caravan.caravan.exceptions.DistrictAlreadyExistsExeption;
import com.caravan.caravan.exceptions.ItemNotFoundException;
import com.caravan.caravan.repository.DistrictRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class DistrictService {

    private final DistrictRepository repository;

    // TODO: 14-May-22 DISTRICT to'liq emas
//    public DistrictDTO create(DistrictDTO dto) {
//        Optional<DistrictEntity> byId = repository.findById(dto.getId());
//        if (byId.isPresent()) {
//            throw new DistrictAlreadyExistsExeption("District already exists");
//        }
//
//        DistrictEntity entity = ConverterService.convertToEntity(dto);
//        repository.save(entity);
//        dto.setId(entity.getId());
//        return dto;
//    }
//
//    public DistrictDTO getById(Long id) {
//        Optional<DistrictEntity> district = repository.findById(id);
//        if (district.isEmpty()) {
//            throw new ItemNotFoundException("item not found ");
//        }
//        return ConverterService.convertToDTO(district.get());
//    }
//
//    public List<DistrictDTO> getList() {
//        return repository.findAll().stream().map(ConverterService::convertToDTO).toList();
//    }
//
//    public DistrictDTO update(Long id, DistrictDTO dto) {
//        getById(id);
//        DistrictEntity entity = ConverterService.convertToEntity(dto);
//        repository.save(entity);
//        return dto;
//    }
//
//    public DistrictDTO delete(Long id) {
//        DistrictDTO dto = getById(id);
//        repository.deleteById(id);
//        return dto;
//    }

}
