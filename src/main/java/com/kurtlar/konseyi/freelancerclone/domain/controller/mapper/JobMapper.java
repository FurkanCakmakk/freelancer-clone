package com.kurtlar.konseyi.freelancerclone.domain.controller.mapper;

import com.kurtlar.konseyi.freelancerclone.domain.dto.JobDto;
import com.kurtlar.konseyi.freelancerclone.domain.dto.TechnologyDto;
import com.kurtlar.konseyi.freelancerclone.domain.request.JobRequest;
import com.kurtlar.konseyi.freelancerclone.domain.response.JobResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JobMapper {

    public JobMapper() {
    }

    public static JobDto toDto(JobRequest request) {
        return JobDto.builder()
                .name(request.getName())
                .description(request.getDescription())
                .salary(request.getSalary())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .workerId(request.getWorkerId())
                .ownerId(request.getOwnerId())
                .status(request.getStatus())
                .technologies(request.getTechnologies()
                        .stream()
                        .map(technology -> TechnologyDto.builder()
                                .id(technology)
                                .build()).toList())
                .build();
    }

    public static JobResponse toResponse(JobDto job) {
        return JobResponse.builder()
                .id(job.getId())
                .name(job.getName())
                .description(job.getDescription())
                .salary(job.getSalary())
                .startDate(job.getStartDate())
                .endDate(job.getEndDate())
                .workerId(job.getWorkerId())
                .ownerId(job.getOwnerId())
                .status(job.getStatus())
                .technologies(job.getTechnologies())
                .offers(job.getOffers())
                .created(job.getCreated())
                .modified(job.getModified())
                .build();
    }

}
