package com.caravan.caravan.service;


import com.caravan.caravan.dto.ProfileDTO;
import com.caravan.caravan.dto.ReviewTripDTO;
import com.caravan.caravan.dto.TripDTO;
import com.caravan.caravan.entity.ReviewTripEntity;
import com.caravan.caravan.exceptions.ItemNotFoundException;
import com.caravan.caravan.repository.ReviewTripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewTripService {

    private ReviewTripRepository repository;

    private TripService tripService;
    private ProfileService profileService;


    public ReviewTripDTO create(ReviewTripDTO dto) {
        TripDTO tripDTO = tripService.getById(dto.getTripId());

        ProfileDTO profileDTO = profileService.getById(dto.getProfileId());

        if (tripDTO == null) throw new ItemNotFoundException("trip not found");

        if (profileDTO == null) throw new ItemNotFoundException("profile not found");

        ReviewTripEntity entity = new ReviewTripEntity();
        entity.setTripId(dto.getTripId());
        entity.setContent(dto.getContent());
        entity.setProfileId(dto.getProfileId());
        entity.setTripId(dto.getTripId());

        repository.save(entity);

        return ConverterService.convertToDTO(entity);
    }

    public boolean delete(Long profileId, Long tripId) {
        return 0 < repository.deleteByProfileIdAndTripId(profileId, tripId);
    }

    public PageImpl<ReviewTripDTO> getReviewByTripId(Long tripId,int page,int size){

        PageRequest of = PageRequest.of(page, size);
        Page<ReviewTripEntity> entityPage = repository.findAllByTripId(tripId, of);
        List<ReviewTripDTO> reviewTripDTOS = entityPage.stream().map(ConverterService::convertToDTO).toList();

        return new PageImpl<>(reviewTripDTOS,of,entityPage.getTotalElements());
    }


}
