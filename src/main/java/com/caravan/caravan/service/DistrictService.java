package com.caravan.caravan.service;

import com.caravan.caravan.dto.DistrictDTO;
import com.caravan.caravan.entity.DistrictEntity;
import com.caravan.caravan.exceptions.DistrictAlreadyExistsExeption;
import com.caravan.caravan.exceptions.ItemNotFoundException;
import com.caravan.caravan.repository.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DistrictService {

    private DistrictRepository repository;

    public DistrictDTO create (DistrictDTO dto){
        Optional<DistrictEntity> byId = repository.findById(dto.getId());

        if (byId.isPresent()){
            throw new DistrictAlreadyExistsExeption("District already exists");
        }

        DistrictEntity entity = ConverterService.convertToEntity(dto);
        repository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    public DistrictDTO getbyId(Long id){
        Optional<DistrictEntity> district = repository.findById(id);
        if (!district.isPresent()){
            throw new ItemNotFoundException("item not found ");
        }
        return ConverterService.convertToDTO(district.get());
    }
    public List<DistrictDTO> getlist(){
        List<DistrictDTO> dtoList = new ArrayList<>();
        List<DistrictEntity> all = repository.findAll();
        for (DistrictEntity entity :all) {
            dtoList.add(ConverterService.convertToDTO(entity));
        }
        return dtoList;
    }

}
