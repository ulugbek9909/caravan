package com.caravan.caravan.controller;


import com.caravan.caravan.dto.LoginDTO;
import com.caravan.caravan.service.AuthService;
import com.caravan.caravan.service.ProfileService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Api(tags = "Auth")
@Slf4j
public class AuthController {

    private final AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<?> sendMessage(@RequestBody @Valid LoginDTO dto){
        return null;
    }
}
