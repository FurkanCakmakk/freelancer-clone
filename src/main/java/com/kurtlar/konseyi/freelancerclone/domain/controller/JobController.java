package com.kurtlar.konseyi.freelancerclone.domain.controller;

import com.kurtlar.konseyi.freelancerclone.domain.controller.mapper.JobMapper;
import com.kurtlar.konseyi.freelancerclone.domain.request.JobRequest;
import com.kurtlar.konseyi.freelancerclone.domain.response.JobResponse;
import com.kurtlar.konseyi.freelancerclone.domain.service.JobService;
import com.kurtlar.konseyi.freelancerclone.library.rest.BaseController;
import com.kurtlar.konseyi.freelancerclone.library.rest.MetaResponse;
import com.kurtlar.konseyi.freelancerclone.library.rest.PageResponse;
import com.kurtlar.konseyi.freelancerclone.library.rest.Response;
import com.kurtlar.konseyi.freelancerclone.library.utils.Constants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("jobs")
@RequiredArgsConstructor
@CrossOrigin

public class JobController extends BaseController {

    private final JobService service;

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<JobResponse> getJobById(@PathVariable String id) {
        return respond(JobMapper.toResponse(service.getById(id)));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<PageResponse<JobResponse>> getAllJobs(
            @RequestParam(value = "pageNumber", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) String pageNumber,
            @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) String pageSize,
            @RequestParam(value = "sortBy", defaultValue = Constants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Constants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return respond(service.getAllJobs(pageNumber, pageSize, sortBy, sortDir).map(JobMapper::toResponse));
    }

    @GetMapping("/owner/{ownerId}")
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<PageResponse<JobResponse>> getJobsByOwner(
            @PathVariable String ownerId,
            @RequestParam(value = "pageNumber", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) String pageNumber,
            @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) String pageSize,
            @RequestParam(value = "sortBy", defaultValue = Constants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Constants.DEFAULT_SORT_DIRECTION, required = false) String sortDir

    ) {
        return respond(service.getAllJobsByOwner(ownerId, pageNumber, pageSize, sortBy, sortDir).map(JobMapper::toResponse));
    }

    @GetMapping("/worker/{workerId}")
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<PageResponse<JobResponse>> getJobsByWorker(
            @PathVariable String workerId,
            @RequestParam(value = "pageNumber", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) String pageNumber,
            @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) String pageSize,
            @RequestParam(value = "sortBy", defaultValue = Constants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Constants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return respond(service.getAllJobsByWorker(workerId, pageNumber, pageSize, sortBy, sortDir).map(JobMapper::toResponse));
    }


    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN')")
    public Response<JobResponse> createJob(@RequestBody JobRequest request) {
        return respond(JobMapper.toResponse(service.save(JobMapper.toDto(request))));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN')")
    public Response<JobResponse> updateJob(@PathVariable String id, @RequestBody JobRequest request) {
        return respond(JobMapper.toResponse(service.update(id, JobMapper.toDto(request))));
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN')")
    public Response<Void> deleteJob(@PathVariable String id) {
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }

    @PutMapping("accept/{jobId}/{workerId}")
    public Response<JobResponse> acceptOffer(@PathVariable String jobId, @PathVariable String workerId){
        return respond(JobMapper.toResponse(service.acceptOffer(jobId, workerId)));
    }
}
