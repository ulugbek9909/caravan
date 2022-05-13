package com.caravan.caravan.service;

import com.caravan.caravan.dto.GuideDTO;
import com.caravan.caravan.entity.GuideEntity;
import com.caravan.caravan.enums.GuideStatus;
import com.caravan.caravan.exceptions.ItemNotFoundException;
import com.caravan.caravan.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class GuideService {
    private final GuideRepository repository;
    private final GuideRateRepository guideRateRepository;
    private final GuidLocationRepository guidLocationRepository;
    private final SocialNetworkRepository socialNetworkRepository;
    private final ReviewGuideRepository reviewGuideRepository;


    public GuideDTO create(GuideDTO dto) {
        var entity = new GuideEntity();
        entity.setProfileId(dto.getProfileId());
        entity.setGuideRate(0d);
        entity.setBiography(dto.getBiography());
        entity.setActivity(GuideStatus.ACTIVE);

        repository.save(entity);

        return ConverterService.convertToDTO(entity);
    }

    public GuideDTO update(GuideDTO dto, Long id) {
        GuideEntity entity = getById(id);

        entity.setBiography(dto.getBiography());
        entity.setUpdatedDate(LocalDateTime.now());

        repository.save(entity);

        return ConverterService.convertToDTO(entity);
    }

    public Boolean deleteById(Long id) {
        GuideEntity entity = getById(id);
        repository.delete(entity);
        return true;
    }

    public GuideEntity getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Not found {}", id);
                    return new ItemNotFoundException("Guide not Found!");
                });
    }


    // TODO: 14-May-22 tasks.txt vazifa (Guide 1. 2. -> Javlon)
    public GuideDTO addInfo(Long profileId, GuideDTO dto) {
        GuideEntity entity = getByProfileId(profileId);

        if (Optional.ofNullable(dto).isPresent()) {
            entity.setBiography(dto.getBiography());
            entity.setSecondPhoneNumber(dto.getSecondPhoneNumber());
            entity.setUpdatedDate(LocalDateTime.now());
        }

        repository.save(entity);

        return ConverterService.convertToDTO(entity);   // TODO: 14-May-22 Profile ni ma'lumotini to'g'irlab kerak
    }

    public Boolean changeStatus(Long profileId) {
        GuideEntity entity = getByProfileId(profileId);

        switch (entity.getActivity()) {
            case BUSY -> {
                entity.setActivity(GuideStatus.ACTIVE);
            }
            case ACTIVE -> {
                entity.setActivity(GuideStatus.BUSY);
            }
        }

        return repository.updateStatus(entity.getActivity(), entity.getId()) > 0;

    }

    public GuideEntity getByProfileId(Long profileId) {
        return repository.findByProfileId(profileId)
                .orElseThrow(() -> {
                    log.warn("Not found {}", profileId);
                    return new ItemNotFoundException("Guide not Found!");
                });
    }

    // TODO: 14-May-22 tugadi {tasks.txt vazifa (Guide 1. 2. -> Javlon)}
}
