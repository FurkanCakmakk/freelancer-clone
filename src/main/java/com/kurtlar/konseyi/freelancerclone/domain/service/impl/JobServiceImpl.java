package com.kurtlar.konseyi.freelancerclone.domain.service.impl;

import com.kurtlar.konseyi.freelancerclone.domain.dto.JobDto;
import com.kurtlar.konseyi.freelancerclone.domain.dto.TechnologyDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.Job;
import com.kurtlar.konseyi.freelancerclone.domain.entity.User;
import com.kurtlar.konseyi.freelancerclone.domain.repository.JobRepository;
import com.kurtlar.konseyi.freelancerclone.domain.service.JobService;
import com.kurtlar.konseyi.freelancerclone.domain.service.TechnologyService;
import com.kurtlar.konseyi.freelancerclone.domain.service.mapper.JobMapper;
import com.kurtlar.konseyi.freelancerclone.library.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository repository;
    private final TechnologyService technologyService;

    @Override
    public JobDto save(JobDto jobDto) {
        Job job = repository.save(JobMapper.toEntity(new Job(), jobDto));
        return JobMapper.toDto(job, technologyService);
    }

    @Override
    public JobDto getById(String jobId) {
        return repository.findById(jobId).map(job -> JobMapper.toDto(job,technologyService)).orElseThrow(
                () -> new ResourceNotFoundException(Job.class.getSimpleName(), "id", jobId)
        );
    }

    @Override
    public JobDto update(String jobId, JobDto jobDto) {
        Job job = repository.findById(jobId).orElseThrow(
                () -> new ResourceNotFoundException(Job.class.getSimpleName(), "id", jobId));
        return JobMapper.toDto(repository.save(setJob(job, jobDto)),technologyService);
    }

    @Override
    public void delete(String jobId) {
        var job = repository.findById(jobId).orElseThrow(
                () -> new ResourceNotFoundException(Job.class.getSimpleName(), "id", jobId)
        );
        repository.delete(job);
    }

    @Override
    public List<JobDto> getAllJobsByOwner(String ownerId) {
        return repository.findAllByOwnerId(ownerId)
                .stream()
                .map(job -> JobMapper.toDto(job,technologyService))
                .collect(Collectors.toList());
    }

    @Override
    public List<JobDto> getAllJobsByWorker(String workerId) {
        return repository.findAllByWorkerId(workerId)
                .stream()
                .map(job -> JobMapper.toDto(job,technologyService))
                .collect(Collectors.toList());
    }


    public Job setJob(Job job ,JobDto jobDto){
        job.setStartDate(jobDto.getStartDate());
        job.setEndDate(jobDto.getEndDate());
        job.setName(jobDto.getName());
        job.setDescription(jobDto.getDescription());
        job.setSalary(jobDto.getSalary());
        job.setStatus(jobDto.getStatus());
        job.setOwnerId(jobDto.getOwnerId());
        job.setWorkerId(jobDto.getWorkerId());
        job.setOffers(jobDto.getOffers());
        job.setTechnologies(jobDto.getTechnologies()
                .stream()
                .map(TechnologyDto::getId)
                .toList());
        return job;
    }
}
