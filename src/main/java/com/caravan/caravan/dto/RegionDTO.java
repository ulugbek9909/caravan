package com.caravan.caravan.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class RegionDTO {

    private UUID id;
    private String nameUz;
    private String nameRu;
    private String nameEn;
    private String key;

}
