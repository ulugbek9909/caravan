package com.caravan.caravan.service;

import com.caravan.caravan.dto.AttachDTO;
import com.caravan.caravan.dto.GuideDTO;
import com.caravan.caravan.dto.ProfileDTO;
import com.caravan.caravan.entity.AttachEntity;
import com.caravan.caravan.entity.GuideEntity;
import com.caravan.caravan.entity.ProfileEntity;
import com.caravan.caravan.enums.GuideStatus;
import com.caravan.caravan.enums.ProfileRole;
import com.caravan.caravan.exceptions.ItemNotFoundException;
import com.caravan.caravan.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class GuideService {
    private final GuideRepository repository;
    private final GuideRateRepository guideRateRepository;
    private final GuideLocationRepository guideLocationRepository;
    private final SocialNetworkRepository socialNetworkRepository;
    private final ReviewGuideRepository reviewGuideRepository;
    private final ProfileService profileService;
    private final AttachService attachService;
    private final ProfileRepository profileRepository;
    private final AttachRepository attachRepository;


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


    public GuideEntity getById(Long id) {
        return repository.findById(id).orElseThrow(() -> {
                    log.warn("Not found {}", id);
                    return new ItemNotFoundException("Guide not Found!");
                });
    }

    public GuideDTO getDtoById(Long id) {

        return ConverterService.convertToDTO(repository.findById(id).orElseThrow(() -> {
            log.warn("Not found {}", id);
            return new ItemNotFoundException("Guide not Found!");
        }));
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


    /**
     * TODO:  3. Update (bio, second_number) ; Update Profile Detail in Guide by Profile Id; {Ulugbek}
     **/
    public GuideDTO updateAll(Long id, GuideDTO dto, ProfileDTO profileDTO) {


        GuideEntity guide = getById(id);
        guide.setBiography(dto.getBiography());
        guide.setSecondPhoneNumber(dto.getSecondPhoneNumber());


        ProfileEntity profile = profileRepository.getById(guide.getProfileId());

        profile.setGender(profileDTO.getGender());
        profile.setEmail(profileDTO.getEmail());
        profile.setName(profileDTO.getName());
        profile.setSurname(profileDTO.getSurname());

        guide.setProfile(profile);
        profileRepository.save(profile);
        repository.save(guide);

        return ConverterService.convertToDTO(guide);
    }

    // TODO: Update Photo Guide  {Ulugbek}

    public Boolean updatePhoto(Long id, MultipartFile file) {
        GuideEntity guideEntity = getById(id);
        ProfileEntity profileEntity = profileRepository.getById(guideEntity.getProfileId());

        AttachEntity photo = profileEntity.getPhoto();
        AttachDTO attachDTO = attachService.update(file, photo.getId());
        AttachEntity byId = attachRepository.getById(attachDTO.getId());

        profileEntity.setPhoto(byId);
        profileEntity.setPhotoId((byId.getId()));

        ProfileEntity profile = profileRepository.save(profileEntity);

        guideEntity.setProfile(profile);

        repository.save(guideEntity);
        return true;
    }

    /**
     * TODO: 4. Delete (Guide Account, Change Role Profile Id) -> by Month; {Ulugbek}
     **/

    public Boolean deleteById(Long id) {
        GuideEntity entity = getById(id);
        ProfileEntity profile = entity.getProfile();
        profile.setRole(ProfileRole.TOURIST);
        profileRepository.save(profile);
        repository.delete(entity);
        return true;
    }
}
