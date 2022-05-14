package com.caravan.caravan.service;



import com.caravan.caravan.dto.GuideRateDTO;
import com.caravan.caravan.entity.GuideRateEntity;
import com.caravan.caravan.exceptions.ItemNotFoundException;
import com.caravan.caravan.repository.GuideRateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GuideRateService {
    private final GuideRateRepository repository;
    private final GuideService guideService;
    private final ProfileService profileService;

    public GuideRateDTO create(GuideRateDTO dto){
        guideService.getDtoById(dto.getGuideId());
        profileService.getById(dto.getProfileId());


        GuideRateEntity entity = new GuideRateEntity();
        entity.setGuideId(dto.getGuideId());
        entity.setMark(dto.getMark());
        entity.setProfileId(dto.getProfileId());

        repository.save(entity);
        return dto;
    }

    public GuideRateDTO getGuideIdProfileId(Long guideId,Long profileId){
     GuideRateEntity entity = repository.findByProfileIdAndGuideId(profileId,guideId).orElseThrow(()->{
            log.warn("Not found");
            throw new ItemNotFoundException("Not found");
        });

     return ConverterService.convertToDTO(entity);
    }

}
