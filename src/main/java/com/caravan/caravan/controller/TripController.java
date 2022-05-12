package com.caravan.caravan.controller;

import com.caravan.caravan.dto.TripDTO;
import com.caravan.caravan.service.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trip")
@RequiredArgsConstructor
@Slf4j
public class TripController {
    private final TripService service;

    public ResponseEntity<?> create(@RequestBody TripDTO dto){
        TripDTO dto1 = service.create(dto);
        return ResponseEntity.ok(dto);
    }

}
