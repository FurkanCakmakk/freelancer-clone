package com.kurtlar.konseyi.freelancerclone.domain.service.mapper;

import com.kurtlar.konseyi.freelancerclone.domain.dto.CountryDto;
import com.kurtlar.konseyi.freelancerclone.domain.dto.UniversityDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.Country;
import com.kurtlar.konseyi.freelancerclone.domain.entity.University;
import com.kurtlar.konseyi.freelancerclone.domain.service.CityService;
import com.kurtlar.konseyi.freelancerclone.domain.service.CountryService;

public class UniversityMapper {
    public static UniversityDto toDto(University university , CityService cityService , CountryService countryService) {
        return UniversityDto.builder()
                .id(university.getId())
                .name(university.getName())
                .country(countryService.getById(university.getCountryId()))
                .city(cityService.getById(university.getCityId()))
                .build();
    }

    public static University toEntity(University university, UniversityDto universityDto) {
        university.setName(universityDto.getName());
        university.setCountryId(universityDto.getCountry().getId());
        university.setCityId(universityDto.getCity().getId());
        return university;
    }
}
