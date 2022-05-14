package com.caravan.caravan.service;

import com.caravan.caravan.dto.AttachDTO;
import com.caravan.caravan.dto.ProfileDTO;
import com.caravan.caravan.entity.ProfileEntity;
import com.caravan.caravan.enums.ProfileRole;
import com.caravan.caravan.exceptions.AppBadRequestException;
import com.caravan.caravan.exceptions.AppForbiddenException;
import com.caravan.caravan.exceptions.ItemAlreadyExistsException;
import com.caravan.caravan.exceptions.ItemNotFoundException;
import com.caravan.caravan.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileService {
    private final ProfileRepository repository;
    private final AttachService attachService;



    public ProfileDTO create(ProfileDTO dto) {
        Optional<ProfileEntity> profile = repository.findByPhoneNumber(dto.getPhoneNumber());

        if (profile.isPresent()) throw new ItemAlreadyExistsException("item all ready exists!");

        ProfileEntity entity = ConverterService.convertToEntityAttribute(dto);

        repository.save(entity);

        return ConverterService.convertToDTO(entity);
    }

    public ProfileDTO delete(Long id) {
        ProfileEntity entity = repository.findById(id).orElseThrow(() -> {
            throw new ItemNotFoundException("item not found!!");
        });
        repository.deleteById(id);
        return ConverterService.convertToDTO(entity);
    }

    public List<ProfileDTO> getList() {
        return repository.findAll().stream().map(ConverterService::convertToDTO).toList();
    }

    public ProfileDTO getById(Long id) {
        ProfileEntity entity = repository.findById(id).orElseThrow(() -> {
            throw new ItemNotFoundException("item not found!!");
        });
        return ConverterService.convertToDTO(entity);
    }
    public ProfileDTO getProfileByPhone(String phone){
        Optional<ProfileEntity> phoneNumber = repository.findByPhoneNumber(phone);
        if (!phoneNumber.isPresent()){
            throw new ItemNotFoundException("Item not found");
        }
        return ConverterService.convertToDTO(phoneNumber.get());
    }

    public ProfileDTO getByPhoneNummber(String phoneNumber) {
        Optional<ProfileEntity> optional = repository.findByPhoneNumber(phoneNumber);
        if (optional.isEmpty()) {
            return null;
        }
        return ConverterService.convertToDTO(optional.get());
    }

    public ProfileEntity get(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            log.warn("Not found {}", id);
            return new ItemNotFoundException("Not found!");
        });
    }

    public ProfileDTO update(Long id, ProfileDTO dto) {
        ProfileEntity entity = repository.findById(id).orElseThrow(() -> {
            throw new ItemNotFoundException("item not found!!");
        });
        entity.setGender(dto.getGender());
        entity.setEmail(dto.getEmail());
        entity.setSurname(dto.getSurname());
        entity.setName(entity.getName());

        repository.save(entity);
        return ConverterService.convertToDTO(entity);
    }

    public AttachDTO updateProfileImage(Long id, UUID attachId){

        ProfileDTO profileDTO = getById(id);
        if (profileDTO.getPhotoId() != null){
            attachService.delete(profileDTO.getPhotoId());
        }
        repository.updateImage(attachId,id);
        return attachService.toDTO(attachService.get(attachId));
    }


    // TODO: 14-May-22 Profile delete main Photo
    public Boolean deletePhoto(Long id) {
        ProfileEntity entity = get(id);

        if (entity.getRole().equals(ProfileRole.GUIDE)) {
            log.warn("Not access {}", id);
            throw new AppForbiddenException("Not access");
        }
        if (Optional.ofNullable(entity.getPhotoId()).isEmpty()) {
            log.warn("Not found {}", id);
            throw new AppBadRequestException("Photo not found");
        }
        attachService.delete(entity.getPhotoId());
        entity.setPhotoId(null);
        repository.save(entity);
        return true;
    }


}
