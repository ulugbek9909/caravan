package com.caravan.caravan.dto;

import lombok.Data;

@Data
public class SocialNetworkDTO {
    private Long id;
    private String type;
    private String link;
    private Long guideId;
}
