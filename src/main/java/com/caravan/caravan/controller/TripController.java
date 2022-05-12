package com.caravan.caravan.controller;

import com.caravan.caravan.dto.TripDTO;
import com.caravan.caravan.service.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/trip")
@RequiredArgsConstructor
@Slf4j
public class TripController {
    private final TripService service;


    //create Trip
    @PostMapping("/create")

    public ResponseEntity<?> create(@RequestBody TripDTO dto) {

        return ResponseEntity.ok(service.create(dto));
    }

    //get List of Trip
    @GetMapping("/list")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(service.list());
    }

    //get Trip By Id
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    //update Trip by Id
    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, TripDTO dto) {

        return ResponseEntity.ok(service.update(id,dto));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {

        return ResponseEntity.ok(service.delete(id));
    }
}
