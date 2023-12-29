package com.kurtlar.konseyi.freelancerclone.domain.service.mapper;


import com.kurtlar.konseyi.freelancerclone.domain.dto.JobDto;
import com.kurtlar.konseyi.freelancerclone.domain.dto.OfferDto;
import com.kurtlar.konseyi.freelancerclone.domain.dto.TechnologyDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.Job;
import com.kurtlar.konseyi.freelancerclone.domain.entity.Offer;
import com.kurtlar.konseyi.freelancerclone.domain.service.OfferService;
import com.kurtlar.konseyi.freelancerclone.domain.service.TechnologyService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class JobMapper {
    public JobMapper() {
    }

    public static JobDto toDto(Job job, TechnologyService technologyService, OfferService offerService) {
        return JobDto.builder()
                .id(job.getId())
                .name(job.getName())
                .description(job.getDescription())
                .salary(job.getSalary())
                .startDate(job.getStartDate())
                .endDate(job.getEndDate())
                .workerId(job.getWorkerId())
                .ownerId(job.getOwnerId())
                .status(job.getStatus())
                .technologies(job.getTechnologies()
                        .stream()
                        .map(technologyService::getById)
                        .collect(Collectors.toList()))
                .created(job.getCreated())
                .modified(job.getModified())
                .offers(job.getOffers().stream().map(offer-> offerService.getById(offer.getId())).collect(Collectors.toSet()))
                .build();
    }

    public static Job toEntity(Job job, JobDto dto) {
        job.setName(dto.getName());
        job.setDescription(dto.getDescription());
        job.setSalary(dto.getSalary());
        job.setStatus(dto.getStatus());
        job.setStartDate(dto.getStartDate());
        job.setEndDate(dto.getEndDate());
        job.setOwnerId(dto.getOwnerId());
        job.setWorkerId(dto.getWorkerId());
        job.setTechnologies(dto.getTechnologies()
                .stream()
                .map(TechnologyDto::getId)
                .collect(Collectors.toList()));
        return job;
    }
}
