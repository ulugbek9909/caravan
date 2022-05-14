package com.caravan.caravan.service;
import com.caravan.caravan.dto.AttachDTO;
import com.caravan.caravan.entity.AttachEntity;
import com.caravan.caravan.exceptions.AppBadRequestException;
import com.caravan.caravan.exceptions.ItemNotFoundException;
import com.caravan.caravan.repository.AttachRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AttachService {
    private final AttachRepository repository;
    @Value("${attach.upload.folder}")
    private String attachFolder;
    @Value("${server.domain.name}")
    private String domainName;

    public AttachDTO upload(MultipartFile file) {
        AttachEntity entity = new AttachEntity();
        String pathFolder = getYmDString();

        File folder = new File(attachFolder + "/" + pathFolder);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        try {
            String extension = getExtension(file.getOriginalFilename());

            byte[] bytes = file.getBytes();

            entity = saveAttach(entity, pathFolder, extension, file);

            Path url = Paths.get(folder.getAbsolutePath() + "/" + entity.getId() + "." + extension);

            Files.write(url, bytes);

            return toDTO(entity);
        } catch (IOException | RuntimeException e) {
            log.warn("Cannot Upload");
            delete(entity.getId());
            throw new AppBadRequestException(e.getMessage());
        }
    }

    public byte[] open_general(UUID id) {
        byte[] data;
        try {
            AttachEntity entity = get(id);
            String path = entity.getPath() + "/" + id + "." + entity.getExtension();
            Path file = Paths.get(attachFolder + path);
            data = Files.readAllBytes(file);
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    public ResponseEntity<Resource> download(UUID key) { // images.png
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
                log.warn("cloud not read the file : {}", key);
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public AttachDTO update(MultipartFile fileDto, UUID key) {
        if (delete(key)) {
            return upload(fileDto);
        } else throw new AppBadRequestException("Could not read the file!");
    }

    public Boolean delete(UUID key) {
        AttachEntity entity = get(key);

        File file = new File(attachFolder + entity.getPath() +
                "/" + entity.getId() + "." + entity.getExtension());

        if (file.delete()) {
            repository.deleteById(key);
            return true;
        } else throw new AppBadRequestException("Could not read the file!");

    }




    public AttachEntity saveAttach(AttachEntity entity, String pathFolder, String extension, MultipartFile file) {
        entity.setPath(pathFolder);
        entity.setOriginName(file.getOriginalFilename());
        entity.setExtension(extension);
        entity.setSize(file.getSize());
        repository.save(entity);
        return entity;
    }

    public AttachDTO toDTO(AttachEntity entity) {
        AttachDTO dto = new AttachDTO();
        dto.setId(entity.getId());
        dto.setCreatedDate(entity.getCreatedDate());
       // dto.setOriginalName(entity.getOriginalName());
        dto.setPath(entity.getPath());
        dto.setUrl(domainName + "attach/download/" + entity.getId());
        return dto;
    }

    public List<AttachDTO> paginationList(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdDate"));

        List<AttachDTO> dtoList = new ArrayList<>();
        repository.findAll(pageable).stream().forEach(entity -> {
            dtoList.add(toDTO(entity));
        });

        return dtoList;
    }

    public AttachEntity get(UUID id) {
        return repository.findById(id).orElseThrow(() -> {
            throw new ItemNotFoundException("Attach not found");
        });
    }

    public String getYmDString() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int day = Calendar.getInstance().get(Calendar.DATE);

        return year + "/" + month + "/" + day;
    }

    public String getExtension(String fileName) {
        int lastIndex = fileName.lastIndexOf(".");
        return fileName.substring(lastIndex + 1);
    }
}
