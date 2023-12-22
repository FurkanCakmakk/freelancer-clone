package com.kurtlar.konseyi.freelancerclone.domain.controller.mapper;

import com.kurtlar.konseyi.freelancerclone.domain.dto.JobDto;
import com.kurtlar.konseyi.freelancerclone.domain.request.JobRequest;
import com.kurtlar.konseyi.freelancerclone.domain.response.JobResponse;

public class JobMapper {

    public JobMapper(){}

    public static JobDto toDto(JobRequest request){
        return JobDto.builder()
                .name(request.getName())
                .description(request.getDescription())
                .salary(request.getSalary())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .workerId(request.getWorkerId())
                .ownerId(request.getOwnerId())
                .status(request.getStatus())
                .technologies(request.getTechnologies())
                .build();
    }

    public static JobResponse toResponse(JobDto job){
        return JobResponse.builder()
                .id(job.getId())
                .created(job.getCreated())
                .modified(job.getModified())
                .name(job.getName())
                .description(job.getDescription())
                .salary(job.getSalary())
                .startDate(job.getStartDate())
                .endDate(job.getEndDate())
                .workerId(job.getWorkerId())
                .ownerId(job.getOwnerId())
                .status(job.getStatus())
                .offers(job.getOffers())
                .technologies(job.getTechnologies())
                .build();
    }

}
