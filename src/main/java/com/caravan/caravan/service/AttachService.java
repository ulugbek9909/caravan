package com.caravan.caravan.service;

import com.caravan.caravan.dto.AttachDto;
import com.caravan.caravan.entity.AttachEntity;
import com.caravan.caravan.exceptions.AppBadRequestException;
import com.caravan.caravan.exceptions.ItemNotFoundException;
import com.caravan.caravan.repository.AttachRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.UUID;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AttachService {
    private final ConverterService converter;
    @Autowired
    private AttachRepository attachRepository;
    @Value("${attach.upload.folder}")
    private String attachFolder;
    @Value("${server.domain.name}")
    private String domainName;

    public AttachDto upload(MultipartFile file){
        String pathFolder=getYmDString();
        File folder=new File(attachFolder+pathFolder);
        if (folder.exists()){
            folder.mkdirs();
        }

        String key = UUID.randomUUID().toString();
        String extension=getExtension(file.getOriginalFilename());
        AttachEntity entity = saveAttach(key, pathFolder, extension, file);
        AttachDto dto = toDTO(entity);

        try {// uploads/2022/04/23/dasdasd-dasdasda-asdasda-asdasd.jpg
            byte[] bytes = file.getBytes();
            Path path = Paths.get(attachFolder + pathFolder + "/" + key + "." + extension);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dto;
    }
    public AttachEntity uploadForProfile(MultipartFile file) {
        String pathFolder = getYmDString(); // 2022/04/23
        File folder = new File(attachFolder + pathFolder);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String key = UUID.randomUUID().toString(); // dasdasd-dasdasda-asdasda-asdasd
        String extension = getExtension(file.getOriginalFilename()); // dasda.asdas.dasd.jpg

        AttachEntity entity = saveAttach(key, pathFolder, extension, file);

        try {// uploads/2022/04/23/dasdasd-dasdasda-asdasda-asdasd.jpg
            byte[] bytes = file.getBytes();
            Path path = Paths.get(attachFolder + pathFolder + "/" + key + "." + extension);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public byte[] open_general(String key) {
        byte[] data;
        try {
            AttachEntity entity = get(key);
            String path = entity.getPath() + "/" + key + "." + entity.getExtension();
            Path file = Paths.get(attachFolder + path);
            data = Files.readAllBytes(file);
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    public ResponseEntity<Resource> download(String key) { // images.png
        try {
            AttachEntity entity = get(key);
            String path = entity.getPath() + "/" + key + "." + entity.getExtension();
            Path file = Paths.get(attachFolder + path);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                                "attachment; filename=\"" + entity.getOriginName() + "\"")
                        .body(resource);

            } else {
                log.warn("cloud not read the file : {}", key );
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public AttachDto update(MultipartFile fileDto, String key ){
        if (delete(key)) {
            return upload(fileDto);
        } else throw new AppBadRequestException("Could not read the file!");
    }

    public AttachEntity updateForProfile(MultipartFile fileDto, String key ){
        if (delete(key)) {
            return uploadForProfile(fileDto);
        } else throw new AppBadRequestException("Could not read the file!");
    }

    public Boolean delete(String key) {
        AttachEntity entity = get(key);

        File file = new File(attachFolder + entity.getPath() +
                "/" + entity.getId() + "." + entity.getExtension());

        if (file.delete()) {
            attachRepository.deleteById(key);
            return true;
        } else throw new AppBadRequestException("Could not read the file!");

    }


    public AttachEntity saveAttach(String key, String pathFolder, String extension, MultipartFile file) {
        AttachEntity entity = new AttachEntity();
        entity.setId(key);
        entity.setPath(pathFolder);
        entity.setOriginName(file.getOriginalFilename());
        entity.setExtension(extension);
        entity.setSize(file.getSize());
        attachRepository.save(entity);
        return entity;
    }

    public AttachDto toDTO(AttachEntity entity) {
        AttachDto dto = new AttachDto();
        dto.setId(entity.getId());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setOriginName(entity.getOriginName());
        dto.setPath(entity.getPath());
        dto.setUrl(domainName + "/attach/download/" + entity.getId());
        return dto;
    }

    public String toOpenURL(String id) {
        return domainName + "/attach/open_general/" + id;
    }

    public String getPhotoURL(AttachEntity entity) {

        return attachFolder+entity.getPath() + "/" + entity.getId() + "." + entity.getExtension();
    }



    public List<AttachDto>paginationList(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdDate"));

        List<AttachDto> dtoList = new ArrayList<>();
        attachRepository.findAll(pageable).stream().forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }

    public AttachEntity get(String id) {
        return attachRepository.findById(id).orElseThrow(() -> {
            throw new ItemNotFoundException("Attach not found");
        });
    }

    public String getYmDString(){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int day = Calendar.getInstance().get(Calendar.DATE);

        return year + "/" + month + "/" + day;
    }

    public String getExtension(String fileName){
        int lastIndex = fileName.lastIndexOf(".");
        return fileName.substring(lastIndex+1);
    }
}
