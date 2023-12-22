package com.kurtlar.konseyi.freelancerclone.domain.controller.mapper;

import com.kurtlar.konseyi.freelancerclone.domain.dto.CountryDto;
import com.kurtlar.konseyi.freelancerclone.domain.request.CountryRequest;
import com.kurtlar.konseyi.freelancerclone.domain.response.CountryResponse;

public class CountryMapper {
    public static CountryDto toDto(CountryRequest request){
        return CountryDto.builder()
                .name(request.getName())
                .build();
    }

    public static CountryResponse toResponse(CountryDto dto){
        return CountryResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}
