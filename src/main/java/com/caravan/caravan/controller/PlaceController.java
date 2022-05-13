package com.caravan.caravan.controller;

import com.caravan.caravan.dto.PlaceDTO;
import com.caravan.caravan.service.PlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/place")
public class PlaceController {

    private final PlaceService service;

    @PutMapping("/")
    public ResponseEntity<?> create(@RequestBody @Valid PlaceDTO dto,
                                    HttpServletRequest request) {
        log.info("/{id} {}", dto);
        return ResponseEntity.ok(service.create(dto));
    }
    @GetMapping("/")
    public ResponseEntity<?> list(@RequestParam(value = "page", defaultValue = "0") int page,
                                  @RequestParam(value = "size", defaultValue = "5") int size,
                                    HttpServletRequest request) {
        log.info("LIST page={} size={}", page, size);
        return ResponseEntity.ok(service.list(page,size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByDistri(@RequestParam(value = "page", defaultValue = "0") int page,
                                  @RequestParam(value = "size", defaultValue = "5") int size,
                                    HttpServletRequest request) {
        log.info("LIST page={} size={}", page, size);
        return ResponseEntity.ok(service.list(page,size));
    }

}
