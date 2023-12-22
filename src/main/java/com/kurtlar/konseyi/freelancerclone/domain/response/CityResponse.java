package com.kurtlar.konseyi.freelancerclone.domain.response;

import com.kurtlar.konseyi.freelancerclone.domain.dto.CountryDto;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CityResponse {
    private String id;
    private String name;
    private CountryDto country;
}
