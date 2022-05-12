package com.caravan.caravan.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttachDto  {
    private String id;
    private String originName;
    private Long size;
    private String path;
    private String extention;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
