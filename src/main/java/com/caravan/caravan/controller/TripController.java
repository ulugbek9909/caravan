package com.caravan.caravan.controller;

import com.caravan.caravan.dto.TripDTO;
import com.caravan.caravan.service.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/trip")
@RequiredArgsConstructor
@Slf4j
public class TripController {
    private final TripService service;

    @PostMapping("/create")

    public ResponseEntity<?> create(@RequestBody TripDTO dto) {

        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@RequestParam UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestParam UUID id, TripDTO dto) {

        return ResponseEntity.ok(service.update(id,dto));
    }


}
