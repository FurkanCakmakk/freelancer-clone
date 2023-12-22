package com.kurtlar.konseyi.freelancerclone.domain.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CityDto {
    private String id;
    private String name;
    private CountryDto country;
}
