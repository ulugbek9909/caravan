package com.caravan.caravan.service;

import com.caravan.caravan.dto.TripDTO;
import com.caravan.caravan.entity.TripEntity;
import com.caravan.caravan.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TripService {
    private final TripRepository repository;
    private final GuideRepository guideProfileRepository;
    private final ConverterService converter;
    private final TripPlaceRepository tripPlaceRepository;
    private final TripPriceRepository tripPriceRepository;
    private final TripRateRepository tripRateRepository;
    private final ReviewTripRepository reviewTripRepository;
    private final FacilityRepository facilityRepository;

    public TripDTO create(TripDTO dto) {
        converter.convertToEntityAttribute(dto);
        TripEntity entity = new TripEntity();
        entity.setName(dto.getName());
        entity.setMaxPeople(dto.getMaxPeople());
        entity.setMinPeople(dto.getMinPeople());
        entity.setDescription(dto.getDescription());

        //entity.setGuideId(guideProfileRepository.getById(dto.getGuideId()));

        entity.setPhoneNumber(dto.getPhoneNumber());
        repository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }


    public List<TripDTO> list() {
        List<TripDTO> tripList = new LinkedList<>();
        for (TripEntity entity : repository.findAll()) {
            tripList.add(toDTO(entity));
        }

        return tripList;
    }

    private TripDTO toDTO(TripEntity entity) {
        TripDTO dto = new TripDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setMaxPeople(entity.getMaxPeople());
        dto.setMinPeople(entity.getMinPeople());
        //dto.setGuideId(entity.getGuideId().getId());
        dto.setPhoneNumber(dto.getPhoneNumber());
        return dto;
    }

    public TripDTO getById(Long id) {
        return toDTO(repository.getById(id));
    }

    public TripDTO update(Long id, TripDTO dto) {
        TripEntity entity = repository.getById(id);
        entity.setName(dto.getName());
        entity.setMaxPeople(dto.getMaxPeople());
        entity.setMinPeople(dto.getMinPeople());
        entity.setDescription(dto.getDescription());
        //entity.setGuideId(guideProfileRepository.getById(dto.getGuideId()));
        entity.setPhoneNumber(dto.getPhoneNumber());
        return toDTO(entity);
    }

    public TripDTO delete(Long id) {
        TripEntity entity = repository.getById(id);
        TripDTO dto = toDTO(entity);
        repository.delete(entity);
        return dto;
    }
}
/*    private UUID id;
    private String name;
    private Integer maxPeople;
    private Integer minPeople;
    private String description;
    private UUID guideId;
    private String phoneNumber;*/