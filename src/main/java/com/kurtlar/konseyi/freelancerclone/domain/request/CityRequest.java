package com.kurtlar.konseyi.freelancerclone.domain.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CityRequest {
    private String name;
    private String countryId;
}
