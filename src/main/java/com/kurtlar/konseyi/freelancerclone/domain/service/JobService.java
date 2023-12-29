package com.kurtlar.konseyi.freelancerclone.domain.service;

import com.kurtlar.konseyi.freelancerclone.domain.dto.JobDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface JobService {
    JobDto save(JobDto job);
    JobDto getById(String jobId);
    JobDto update(String jobId, JobDto job);
    void delete(String jobId);
    Page<JobDto> getAllJobsByOwner(String ownerId , String pageNumber, String pageSize , String  sortBy , String sortDir);
    Page<JobDto> getAllJobsByWorker(String workerId , String pageNumber, String pageSize , String  sortBy , String sortDir);
}
