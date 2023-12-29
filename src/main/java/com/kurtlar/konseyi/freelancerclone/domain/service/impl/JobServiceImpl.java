package com.kurtlar.konseyi.freelancerclone.domain.service.impl;

import com.kurtlar.konseyi.freelancerclone.domain.dto.JobDto;
import com.kurtlar.konseyi.freelancerclone.domain.dto.TechnologyDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.Job;
import com.kurtlar.konseyi.freelancerclone.domain.repository.JobRepository;
import com.kurtlar.konseyi.freelancerclone.domain.service.JobService;
import com.kurtlar.konseyi.freelancerclone.domain.service.OfferService;
import com.kurtlar.konseyi.freelancerclone.domain.service.TechnologyService;
import com.kurtlar.konseyi.freelancerclone.domain.service.mapper.JobMapper;
import com.kurtlar.konseyi.freelancerclone.library.exception.ResourceNotFoundException;
import com.kurtlar.konseyi.freelancerclone.library.utils.CreatePageable;
import com.kurtlar.konseyi.freelancerclone.library.utils.CreateSort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository repository;
    private final TechnologyService technologyService;
    private final OfferService offerService;

    @Override
    public JobDto save(JobDto jobDto) {
        Job job = repository.save(JobMapper.toEntity(new Job(), jobDto));
        return JobMapper.toDto(job, technologyService ,offerService);
    }

    @Override
    public JobDto getById(String jobId) {
        return repository.findById(jobId).map(job -> JobMapper.toDto(job,technologyService ,offerService)).orElseThrow(
                () -> new ResourceNotFoundException(Job.class.getSimpleName(), "id", jobId)
        );
    }

    @Override
    public JobDto update(String jobId, JobDto jobDto) {
        Job job = repository.findById(jobId).orElseThrow(
                () -> new ResourceNotFoundException(Job.class.getSimpleName(), "id", jobId));
        return JobMapper.toDto(repository.save(setJob(job, jobDto)),technologyService,offerService);
    }

    @Override
    public void delete(String jobId) {
        var job = repository.findById(jobId).orElseThrow(
                () -> new ResourceNotFoundException(Job.class.getSimpleName(), "id", jobId)
        );
        repository.delete(job);
    }

    @Override
    public Page<JobDto> getAllJobs(String pageNumber, String pageSize, String sortBy, String sortDir) {
        Sort sort = CreateSort.generateSort(sortBy, sortDir);
        Pageable pageable = CreatePageable.createPageable(pageNumber, pageSize, sort);

        return repository.findAll(pageable).map(job -> JobMapper.toDto(job,technologyService,offerService));
    }

    @Override
    public Job getEntityById(String jobId) {
        return repository.findById(jobId).orElseThrow(
                () -> new ResourceNotFoundException(Job.class.getSimpleName(), "id", jobId)
        );
    }

    @Override
    public Page<JobDto> getAllJobsByOwner(String ownerId , String pageNumber, String pageSize , String  sortBy , String sortDir) {
        Sort sort = CreateSort.generateSort(sortBy, sortDir);

        Pageable pageable = PageRequest.of(Integer.parseInt(pageNumber), Integer.parseInt(pageSize), sort);

        return repository.findAll(pageable).map(job -> JobMapper.toDto(job,technologyService,offerService));
    }

    @Override
    public Page<JobDto> getAllJobsByWorker(String workerId , String pageNumber, String pageSize , String  sortBy , String sortDir) {
        Sort sort = CreateSort.generateSort(sortBy, sortDir);

        Pageable pageable = PageRequest.of(Integer.parseInt(pageNumber), Integer.parseInt(pageSize), sort);

        return repository.findAll(pageable).map(job -> JobMapper.toDto(job,technologyService,offerService));
    }




    public Job setJob(Job job ,JobDto jobDto){
        job.setStartDate(jobDto.getStartDate());
        job.setEndDate(jobDto.getEndDate());
        job.setName(jobDto.getName());
        job.setDescription(jobDto.getDescription());
        job.setSalary(jobDto.getSalary());
        job.setStatus(jobDto.getStatus());
        job.setWorkerId(jobDto.getWorkerId());
        job.setTechnologies(jobDto.getTechnologies().stream().map(technologyDto ->technologyDto.getId()).collect(Collectors.toList()));
        return job;
    }
}
