package com.kurtlar.konseyi.freelancerclone.domain.controller.mapper;

import com.kurtlar.konseyi.freelancerclone.domain.dto.CityDto;
import com.kurtlar.konseyi.freelancerclone.domain.dto.CountryDto;
import com.kurtlar.konseyi.freelancerclone.domain.request.CityRequest;
import com.kurtlar.konseyi.freelancerclone.domain.request.CountryRequest;
import com.kurtlar.konseyi.freelancerclone.domain.response.CityResponse;
import com.kurtlar.konseyi.freelancerclone.domain.response.CountryResponse;
import com.kurtlar.konseyi.freelancerclone.domain.service.CityService;
import com.kurtlar.konseyi.freelancerclone.domain.service.CountryService;

public class CityMapper {
    public static CityDto toDto(CityRequest request){
        return CityDto.builder()
                .name(request.getName())
                .country(new CountryDto(request.getCountryId()))
                .build();
    }

    public static CityResponse toResponse(CityDto dto){
        return CityResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .country(dto.getCountry())
                .build();
    }
}
