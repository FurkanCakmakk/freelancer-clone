package com.kurtlar.konseyi.freelancerclone.domain.response;

import com.kurtlar.konseyi.freelancerclone.domain.dto.CityDto;
import com.kurtlar.konseyi.freelancerclone.domain.dto.CountryDto;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UniversityResponse {
    private String id;
    private String name;
    private CountryDto country;
    private CityDto city;
}
