package com.kurtlar.konseyi.freelancerclone.domain.service.mapper;

import com.kurtlar.konseyi.freelancerclone.domain.dto.CityDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.City;
import com.kurtlar.konseyi.freelancerclone.domain.service.CityService;
import com.kurtlar.konseyi.freelancerclone.domain.service.CountryService;

public class CityMapper {
    public static CityDto toDto(City city , CountryService countryService) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .country(countryService.getById(city.getCountryId()))
                .build();
    }

    public static City toEntity(City city, CityDto cityDto) {
        city.setName(cityDto.getName());
        city.setCountryId(cityDto.getCountry().getId());
        return city;
    }
}
