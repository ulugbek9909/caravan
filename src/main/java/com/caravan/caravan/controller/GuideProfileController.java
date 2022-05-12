package com.caravan.caravan.controller;

import com.caravan.caravan.dto.GuideProfileDTO;
import com.caravan.caravan.service.GuideProfileService;
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
    private final GuideProfileService service;

    @PostMapping("/")
    public ResponseEntity<GuideProfileDTO> create(@RequestBody @Valid GuideProfileDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody @Valid GuideProfileDTO dto) {
        return ResponseEntity.ok(service.update(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.deleteById(id));
    }
}
