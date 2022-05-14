package com.caravan.caravan.controller;

import com.caravan.caravan.dto.GuideDTO;
import com.caravan.caravan.dto.ProfileDTO;
import com.caravan.caravan.service.GuideService;
import com.caravan.caravan.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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



    //  TODO: 3. Update (bio, second_number) ; Update Profile Detail in Guide by Profile Id; {Ulugbek}

    @PutMapping("/update/all/{id}")
    public ResponseEntity<?> updateAll(@PathVariable("id") Long id,@RequestBody GuideDTO dto, @RequestBody ProfileDTO profileDTO){
        return ResponseEntity.ok(service.updateAll(id,dto,profileDTO));
    }

    @PutMapping("/update/photo/{id}")
   // @PutMapping("/update/{key}")
/*    public ResponseEntity<?> update(@RequestParam("file") MultipartFile file,
                                    @PathVariable("key") String key) {*/


    public ResponseEntity<?> getById(@PathVariable("id") Long id,@RequestParam("file") MultipartFile file){
        //log.info("update : {}", file +" key:"+key);
        return ResponseEntity.ok(service.updatePhoto(id,file));
    }

   // TODO: 4. Delete (Guide Account, Change Role Profile Id) -> by Month; {Ulugbek}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.deleteById(id));
    }
}
