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

        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setStatus(ProfileStatus.ACTIVE);
        entity.setSurname(dto.getSurname());
        entity.setRole(ProfileRole.TOURIST);
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setGender(dto.getGender());
        repository.save(entity);
        return toDTOsimple(entity);
    }

    public ProfileDTO delete(UUID id){
        ProfileEntity entity = repository.findById(id).orElseThrow(()->{
            throw new ItemNotFoundException("item not found!!");
        });
        repository.deleteById(id);
        return toDTOsimple(entity);
    }

    public List<ProfileDTO> getList(){
        return repository.findAll().stream().map(this::toDTOsimple).toList();
    }

    public ProfileDTO getById(UUID id ){
        ProfileEntity entity = repository.findById(id).orElseThrow(()->{
            throw new ItemNotFoundException("item not found!!");
        });
        return toDTOsimple(entity);
    }

    public ProfileDTO update(UUID id,ProfileDTO dto){
        ProfileEntity entity = repository.findById(id).orElseThrow(()->{
            throw new ItemNotFoundException("item not found!!");
        });
        entity.setGender(dto.getGender());
        entity.setEmail(dto.getEmail());
        entity.setName(entity.getName());
        repository.save(entity);
        return toDTOsimple(entity);
    }

    public ProfileDTO toDTOsimple(ProfileEntity entity) {
        ProfileDTO dto = new ProfileDTO();
        dto.setGender(entity.getGender());
        dto.setName(entity.getName());
        dto.setRole(entity.getRole());
        dto.setStatus(entity.getStatus());
        dto.setSurname(entity.getSurname());
        dto.setEmail(entity.getEmail());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setId(entity.getId());
        return dto;

    }
}
