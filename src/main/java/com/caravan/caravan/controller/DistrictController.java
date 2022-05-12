package com.caravan.caravan.controller;

import com.caravan.caravan.dto.DistrictDTO;
import com.caravan.caravan.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/district")
@RequiredArgsConstructor
public class DistrictController {

    private DistrictService districtService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DistrictDTO dto) {
        return ResponseEntity.ok(districtService.create(dto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody DistrictDTO dto) {
        return ResponseEntity.ok(districtService.update(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(districtService.delete(id));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(districtService.getById(id));
    }


}
