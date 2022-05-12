package com.caravan.caravan.service;

import com.caravan.caravan.dto.GuideProfileDTO;
import com.caravan.caravan.entity.GuideProfileEntity;
import com.caravan.caravan.repository.GuideProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class GuideProfileService {
    private final GuideProfileRepository repository;

    public GuideProfileDTO create(GuideProfileDTO dto){
        Optional<GuideProfileEntity> optional = repository.findById(dto.getId());

        /*if (optional.isPresent())
            throw new*/
}
