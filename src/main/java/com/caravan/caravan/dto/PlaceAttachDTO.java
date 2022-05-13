package com.caravan.caravan.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString

public class PlaceAttachDTO {
    private Long id;
    private Long placeId;
    private Long attachId;
}
