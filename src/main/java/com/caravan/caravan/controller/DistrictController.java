package com.caravan.caravan.controller;

import com.caravan.caravan.annotation.ValidEmail;
import com.caravan.caravan.dto.DistrictDTO;
import com.caravan.caravan.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/district")
@RequiredArgsConstructor
public class DistrictController {

    private DistrictService service;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid DistrictDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") @Valid Long id){
        return ResponseEntity.ok(service.getbyId(id));
    }

}
