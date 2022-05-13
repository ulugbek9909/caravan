package com.caravan.caravan.service;

import com.caravan.caravan.dto.ProfileDTO;
import com.caravan.caravan.entity.ProfileEntity;
import com.caravan.caravan.enums.ProfileRole;
import com.caravan.caravan.enums.ProfileStatus;
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

    public ProfileDTO update(Long id, ProfileDTO dto) {
        ProfileEntity entity = repository.findById(id).orElseThrow(() -> {
            throw new ItemNotFoundException("item not found!!");
        });
        entity.setGender(dto.getGender());
        entity.setEmail(dto.getEmail());
        entity.setName(entity.getName());
        repository.save(entity);
        return ConverterService.convertToDTO(entity);
    }


}
