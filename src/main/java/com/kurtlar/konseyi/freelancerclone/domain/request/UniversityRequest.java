package com.kurtlar.konseyi.freelancerclone.domain.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UniversityRequest {
    private String name;
    private String countryId;
    private String cityId;
}
