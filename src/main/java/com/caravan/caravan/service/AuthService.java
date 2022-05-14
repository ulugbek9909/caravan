package com.caravan.caravan.service;


import com.caravan.caravan.dto.AuthDTO;
import com.caravan.caravan.dto.ProfileDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final ProfileService profileService;


    public ProfileDTO authorization(AuthDTO dto) {
        ProfileDTO profileDTO = profileService.getByPhoneNummber(dto.getPhoneNumber());
        if (profileDTO == null) {
            return null;
        }
        profileDTO.setCode(genereteNumber());
        return profileDTO;
    }

    public String genereteNumber() {
        int min = 100;
        int max = 999;
        int b = (int) (Math.random() * (max - min + 1) + min);
        int c = (int) (Math.random() * (max - min) + min);
        return b + "" + c;
    }
}
