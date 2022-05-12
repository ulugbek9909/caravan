package com.caravan.caravan.service;

import com.caravan.caravan.dto.TripDTO;
import com.caravan.caravan.entity.TripEntity;
import com.caravan.caravan.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TripService {
    private final TripRepository repository;

    public TripDTO create(TripDTO dto) {
        TripEntity entity = new TripEntity();
        entity.setName(dto.getName());
        entity.setMaxPeople(dto.getMaxPeople());
        entity.setMinPeople(dto.getMinPeople());
        entity.setDescription(dto.getDescription());
        entity.setGuideId(dto.getGuideId());
        entity.setPhoneNumber(dto.getPhoneNumber());
        TripEntity save = repository.save(entity);
        dto.setId(save.getId());
        return dto;
    }

    private TripDTO toDTO(TripEntity entity) {
        return null;
    }
}
/*    private UUID id;
    private String name;
    private Integer maxPeople;
    private Integer minPeople;
    private String description;
    private UUID guideId;
    private String phoneNumber;*/