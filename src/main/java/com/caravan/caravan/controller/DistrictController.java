package com.caravan.caravan.controller;

import com.caravan.caravan.dto.DistrictDTO;
import com.caravan.caravan.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/istrict")
@RequiredArgsConstructor
public class DistrictController {

    private DistrictService districtService;


    @PostMapping(name = "")
    public ResponseEntity<?> create(@RequestBody DistrictDTO dto){
        return ResponseEntity.ok(districtService.create(dto));
    }





}
