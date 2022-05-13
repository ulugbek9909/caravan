package com.caravan.caravan.controller;

import com.caravan.caravan.dto.RegionDTO;
import com.caravan.caravan.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class RegionController {

    RegionService service;

    public ResponseEntity<?> create(RegionDTO dto){
        return ResponseEntity.ok().build();
    }
}
