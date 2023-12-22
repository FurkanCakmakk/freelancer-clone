package com.kurtlar.konseyi.freelancerclone.domain.service;

import com.kurtlar.konseyi.freelancerclone.domain.dto.JobDto;

import java.util.List;

public interface JobService {
    JobDto save(JobDto job);
    JobDto getById(String jobId);
    JobDto update(String jobId, JobDto job);
    void delete(String jobId);
    List<JobDto> getAllJobsByOwner(String ownerId);
    List<JobDto> getAllJobsByWorker(String workerId);
}
