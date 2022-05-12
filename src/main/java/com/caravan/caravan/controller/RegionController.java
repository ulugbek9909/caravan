package com.caravan.caravan.controller;
import com.caravan.caravan.dto.RegionDTO;
import com.caravan.caravan.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/region")
public class RegionController {

   private final RegionService service;

    @PostMapping("/create")
    public ResponseEntity<?> create(RegionDTO dto){
        return ResponseEntity.ok(service.create(dto));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getByid(@PathVariable("id") UUID uuid){
        return ResponseEntity.ok( service.getById(uuid));
    }
    @GetMapping("/getlist")
    public ResponseEntity<List<RegionDTO>> getall(){
        return ResponseEntity.ok(service.getregionDTOList());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(UUID id,RegionDTO dto){
        return ResponseEntity.ok( service.update(id,dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(UUID id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
