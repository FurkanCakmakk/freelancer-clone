package com.kurtlar.konseyi.freelancerclone.domain.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UniversityDto {
    private String id;
    private String name;
    private CountryDto country;
    private CityDto city;


}
