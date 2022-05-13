package com.caravan.caravan.controller;

import com.caravan.caravan.service.AttachService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/attach")
@RequiredArgsConstructor
public class AttachController {
    private final AttachService attachService;

    @PostMapping("/upload")
    public ResponseEntity<?> create(@RequestParam("file") MultipartFile file) {
        log.info("create : {}", file );
        return ResponseEntity.ok(attachService.upload(file));
    }

    @GetMapping(value = "/open_general/{fileName}", produces = MediaType.ALL_VALUE)
    public byte[] open_general(@PathVariable("fileName") String fileName) {
        log.info("open_general : {}", fileName );
        return attachService.open_general(fileName);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> download(@PathVariable("fileName") String fileName) {
        log.info("download : {}", fileName );
        return attachService.download(fileName);
    }
    @PutMapping("/update/{key}")
    public ResponseEntity<?> update(@RequestParam("file") MultipartFile file,
                                    @PathVariable("key") String key) {
        log.info("update : {}", file +" key:"+key);
        return ResponseEntity.ok(attachService.update(file,key));
    }


    @GetMapping("/list")
    public ResponseEntity<?> list(@RequestParam(value = "page", defaultValue = "0") int page,
                                  @RequestParam(value = "size", defaultValue = "3") int size) {
        log.info("list : {}", "page: "+page , " size: "+size );
        return ResponseEntity.ok(attachService.paginationList(page, size));
    }

    @DeleteMapping("/delete/{key}")
    public ResponseEntity<?> delete(@PathVariable("key") String key) {
        log.info("delete : {}", key );
        return ResponseEntity.ok(attachService.delete(key));
    }
}
