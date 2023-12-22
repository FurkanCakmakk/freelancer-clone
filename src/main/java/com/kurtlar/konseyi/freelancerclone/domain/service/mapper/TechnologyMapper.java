package com.kurtlar.konseyi.freelancerclone.domain.service.mapper;


import com.kurtlar.konseyi.freelancerclone.domain.dto.TechnologyDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.Technology;

public class TechnologyMapper {

    public TechnologyMapper(){}

    public static TechnologyDto toDto(Technology technology){
        return TechnologyDto.builder()
                .id(technology.getId())
                .created(technology.getCreated())
                .modified(technology.getModified())
                .name(technology.getName())
                .build();
    }

    public static Technology toEntity(Technology technology,TechnologyDto dto){
        technology.setName(dto.getName());
        return technology;
    }
}
