package com.caravan.caravan.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
public class BaseDTO {
    private UUID id;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
