package com.caravan.caravan.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttachDTO {

    private UUID id;

    private String originalName;

    private Long size;

    private String path;

    private String extension;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private String url;

    public AttachDTO(String url) {
        this.url = url;
    }
}
