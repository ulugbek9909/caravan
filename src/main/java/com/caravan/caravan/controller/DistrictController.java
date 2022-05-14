package com.caravan.caravan.controller;

import com.caravan.caravan.annotation.ValidEmail;
import com.caravan.caravan.dto.DistrictDTO;
import com.caravan.caravan.service.DistrictService;
import com.caravan.caravan.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/district")
@RequiredArgsConstructor
public class DistrictController {

    private final DistrictService service;

    // TODO: 14-May-22 DISTRICT to'liq emas
//    @PostMapping("/create")
//    public ResponseEntity<?> create(@RequestBody @Valid DistrictDTO dto) {
//        return ResponseEntity.ok(service.create(dto));
//    }
//
//    @GetMapping("/get") // TODO: 14-May-22
//    public ResponseEntity<?> get(HttpServletRequest request) {
//        Long id = JwtUtil.getIdFromHeader(request);
//        return ResponseEntity.ok(service.getById(id));
//    }
//
//    @GetMapping("/district/getlist")
//    public ResponseEntity<List<DistrictDTO>> getlist() {
//        return ResponseEntity.ok(service.getList());
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> update(@PathVariable("id") @Valid Long id, @RequestBody @Valid DistrictDTO dto) {
//        return ResponseEntity.ok(service.update(id, dto));
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable("id") @Valid Long id) {
//        return ResponseEntity.ok(service.delete(id));
//    }


}
