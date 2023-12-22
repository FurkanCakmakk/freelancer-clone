package com.kurtlar.konseyi.freelancerclone.domain.controller.mapper;

import com.kurtlar.konseyi.freelancerclone.domain.dto.CityDto;
import com.kurtlar.konseyi.freelancerclone.domain.dto.CountryDto;
import com.kurtlar.konseyi.freelancerclone.domain.dto.UniversityDto;
import com.kurtlar.konseyi.freelancerclone.domain.request.UniversityRequest;
import com.kurtlar.konseyi.freelancerclone.domain.response.UniversityResponse;

public class UniversityMapper {
    public static UniversityDto toDto(UniversityRequest request){
        return UniversityDto.builder()
                .name(request.getName())
                .country(CountryDto.builder().id(request.getCountryId()).build())
                .city(CityDto.builder().id(request.getCityId()).build())
                .build();
    }

    public static UniversityResponse toResponse(UniversityDto dto){
        return UniversityResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .city(dto.getCity())
                .country(dto.getCountry())
                .build();
    }
}
