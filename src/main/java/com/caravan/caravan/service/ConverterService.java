package com.caravan.caravan.service;

import com.caravan.caravan.dto.ProfileDTO;
import com.caravan.caravan.dto.RegionDTO;
import com.caravan.caravan.dto.TripDTO;
import com.caravan.caravan.entity.ProfileEntity;
import com.caravan.caravan.entity.RegionEntity;
import com.caravan.caravan.entity.TripEntity;
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
        return null;
    }


    public static ProfileEntity convertToEntityAttribute(ProfileDTO tripDTO) {
        return null;
    }

    public RegionDTO convertToDatabaseColumn(RegionEntity tripEntity) {
        return null;
    }



    public RegionEntity convertToEntityAttribute(RegionDTO tripDTO) {
        return null;
    }

}
