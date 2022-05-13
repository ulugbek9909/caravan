package com.caravan.caravan.controller;

import com.caravan.caravan.dto.GuideDTO;
import com.caravan.caravan.service.GuideService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/guide-profile")
public class GuideProfileController {
    private final GuideService service;

    @PostMapping("/")
    public ResponseEntity<GuideDTO> create(@RequestBody @Valid GuideDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody @Valid GuideDTO dto) {
        return ResponseEntity.ok(service.update(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.deleteById(id));
    }
}
