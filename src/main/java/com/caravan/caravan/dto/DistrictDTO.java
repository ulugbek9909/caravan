package com.caravan.caravan.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class DistrictDTO {
    private UUID id;
    private String nameUz;
    private String nameRu;
    private String nameEn;
    private String key;
    private RegionDTO region;
    private Integer regionId;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;


}