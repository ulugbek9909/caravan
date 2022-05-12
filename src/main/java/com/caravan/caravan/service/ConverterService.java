package com.caravan.caravan.service;

import com.caravan.caravan.dto.ProfileDTO;
import com.caravan.caravan.dto.RegionDTO;
import com.caravan.caravan.dto.TripDTO;
import com.caravan.caravan.entity.ProfileEntity;
import com.caravan.caravan.entity.RegionEntity;
import com.caravan.caravan.entity.TripEntity;
import com.caravan.caravan.enums.ProfileRole;
import com.caravan.caravan.enums.ProfileStatus;
import org.springframework.stereotype.Service;

import javax.persistence.Converter;
import javax.persistence.AttributeConverter;

@Service
public class ConverterService  {


    public static TripDTO convertToDTO(TripEntity tripEntity) {
        return null;
    }


    public static TripEntity convertToEntityAttribute(TripDTO tripDTO) {
        return null;
    }

    public static ProfileDTO convertToDTO(ProfileEntity entity) {
        ProfileDTO dto = new ProfileDTO();
        dto.setGender(entity.getGender());
        dto.setName(entity.getName());
        dto.setRole(entity.getRole());
        dto.setStatus(entity.getStatus());
        dto.setSurname(entity.getSurname());
        dto.setEmail(entity.getEmail());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setId(entity.getId());
        return dto;
    }


    public static ProfileEntity convertToEntityAttribute(ProfileDTO dto) {
        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setStatus(ProfileStatus.ACTIVE);
        entity.setSurname(dto.getSurname());
        entity.setRole(ProfileRole.TOURIST);
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setGender(dto.getGender());
        return entity;
    }

    public RegionDTO convertToDatabaseColumn(RegionEntity tripEntity) {
        return null;
    }



    public RegionEntity convertToEntityAttribute(RegionDTO tripDTO) {
        return null;
    }

}
