package com.caravan.caravan.controller;

import com.caravan.caravan.dto.ProfileDTO;
import com.caravan.caravan.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;


@Slf4j
@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService service;


    //get by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    //create profile
    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody @Valid ProfileDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    //update profile
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") UUID id,
                                    @RequestBody @Valid ProfileDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    //delete profile
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/")
    public ResponseEntity<?> getProfileList() {
        return ResponseEntity.ok(service.getList());
    }
}
