package com.kurtlar.konseyi.freelancerclone.domain.service.mapper;


import com.kurtlar.konseyi.freelancerclone.domain.dto.JobDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.Job;

public class JobMapper {

    public JobMapper(){}

    public static JobDto toDto(Job job){
        return JobDto.builder()
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
                .build();
    }

    public static Job toEntity(Job job,JobDto dto){
        job.setName(dto.getName());
        job.setDescription(dto.getDescription());
        job.setSalary(dto.getSalary());
        job.setStatus(dto.getStatus());
        job.setStartDate(dto.getStartDate());
        job.setEndDate(dto.getEndDate());
        job.setOwnerId(dto.getOwnerId());
        job.setWorkerId(dto.getWorkerId());
        job.setOffers(dto.getOffers());
        job.setTechnologies(dto.getTechnologies());
        return job;
    }
}
