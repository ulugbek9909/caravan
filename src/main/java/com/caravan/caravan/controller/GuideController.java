package com.caravan.caravan.controller;

import com.caravan.caravan.dto.GuideDTO;
import com.caravan.caravan.service.GuideService;
import com.caravan.caravan.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/guide-profile")
public class GuideController {
    private final GuideService service;

    @PostMapping("/")
    public ResponseEntity<GuideDTO> create(@RequestBody @Valid GuideDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody @Valid GuideDTO dto) {
        return ResponseEntity.ok(service.update(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.deleteById(id));
    }

    @PutMapping("/status/{jwt}")
    public ResponseEntity<?> changeStatus(@PathVariable("jwt") String jwt) {
        log.info("/status/{jwt} {}", jwt);
        Long id = JwtUtil.decodeAndGetId(jwt);
        return ResponseEntity.ok(service.changeStatus(id));
    }

    // TODO: 14-May-22 addInfo for Guide
    @PutMapping("/info")
    public ResponseEntity<?> addInfo(@RequestBody GuideDTO dto,
                                     HttpServletRequest request) {
        log.info("/info {}", dto);
        Long id = JwtUtil.getIdFromHeader(request);
        return ResponseEntity.ok(service.addInfo(id, dto));
    }


}
