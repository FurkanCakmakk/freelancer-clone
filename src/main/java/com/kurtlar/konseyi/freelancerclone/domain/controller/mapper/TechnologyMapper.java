package com.kurtlar.konseyi.freelancerclone.domain.controller.mapper;


import com.kurtlar.konseyi.freelancerclone.domain.dto.TechnologyDto;
import com.kurtlar.konseyi.freelancerclone.domain.request.TechnologyRequest;
import com.kurtlar.konseyi.freelancerclone.domain.response.TechnologyResponse;

public class TechnologyMapper {

    public TechnologyMapper(){}

    public static TechnologyDto toDto(TechnologyRequest request){
        return TechnologyDto.builder()
                .name(request.getName())
                .build();
    }

    public static TechnologyResponse toResponse(TechnologyDto dto){
        return TechnologyResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}
