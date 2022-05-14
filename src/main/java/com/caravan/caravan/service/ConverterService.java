package com.caravan.caravan.service;

import com.caravan.caravan.dto.*;
import com.caravan.caravan.entity.*;
import com.caravan.caravan.enums.ProfileRole;
import com.caravan.caravan.enums.ProfileStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ConverterService {


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

    public static GuideDTO convertToDTO(GuideEntity entity) {
        var dto = new GuideDTO();

        dto.setId(entity.getId());
        dto.setProfileId(entity.getProfileId());
        dto.setBiography(entity.getBiography());
        dto.setActivity(entity.getActivity());
        dto.setSecondPhoneNumber(entity.getSecondPhoneNumber());
        dto.setGuideRate(entity.getGuideRate());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setUpdatedDate(entity.getUpdatedDate());

        return dto;
    }

//    public static GuideEntity convertToEntity(GuideDTO dto) {
//        var entity = new GuideEntity();
//
//        entity.setProfileId(dto.getProfileId());
//        entity.setCreatedDate(entity.getCreatedDate());
//        entity.setContent(dto.getContent());
//        entity.setIsHiring(dto.getIsHiring());
//        entity.setPhoneNumber(dto.getPhoneNumber());
//        entity.setGuideRate(dto.getGuideRate());
//
//        return entity;
//    }

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


    public static PlaceEntity convertToEntity(PlaceDTO dto) {
        PlaceEntity entity = new PlaceEntity();
        entity.setTitle(dto.getTitle());
        entity.setDescription(entity.getDescription());
        entity.setDistrictId(dto.getDistrictId());
        return entity;
    }

    public static PlaceDTO convertToDTO(PlaceEntity entity) {
        PlaceDTO dto = new PlaceDTO();
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setTripCount(entity.getTripCount());
        return dto;
    }


}
