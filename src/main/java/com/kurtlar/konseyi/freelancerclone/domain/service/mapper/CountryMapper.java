package com.kurtlar.konseyi.freelancerclone.domain.service.mapper;

import com.kurtlar.konseyi.freelancerclone.domain.dto.CountryDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.Country;

public class CountryMapper {
    public static CountryDto toDto(Country country) {
        return CountryDto.builder()
                .id(country.getId())
                .name(country.getName())
                .build();
    }

    public static Country toEntity(Country country, CountryDto countryDto) {
        country.setName(countryDto.getName());
        return country;
    }
}
