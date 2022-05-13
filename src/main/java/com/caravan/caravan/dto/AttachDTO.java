package com.caravan.caravan.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttachDTO {

    private String id;

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
