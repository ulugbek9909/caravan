package com.caravan.caravan.dto;

import com.caravan.caravan.enums.ProfileRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileJwtDTO {

    private Long id;

    private ProfileRole role;


}
