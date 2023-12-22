package com.kurtlar.konseyi.freelancerclone.domain.controller;

import com.kurtlar.konseyi.freelancerclone.domain.controller.mapper.JobMapper;
import com.kurtlar.konseyi.freelancerclone.domain.request.JobRequest;
import com.kurtlar.konseyi.freelancerclone.domain.response.JobResponse;
import com.kurtlar.konseyi.freelancerclone.domain.service.JobService;
import com.kurtlar.konseyi.freelancerclone.library.rest.BaseController;
import com.kurtlar.konseyi.freelancerclone.library.rest.MetaResponse;
import com.kurtlar.konseyi.freelancerclone.library.rest.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("jobs")
@RequiredArgsConstructor
public class JobController extends BaseController {

    private final JobService service;

    @GetMapping("/{id}")
    public Response<JobResponse> getJobById(@PathVariable String id){
        return respond(JobMapper.toResponse(service.getById(id)));
    }

    @PostMapping
    public Response<JobResponse> createJob(@Valid @RequestBody JobRequest request){
        return respond(JobMapper.toResponse(service.save(JobMapper.toDto(request))));
    }

    @PutMapping("/{id}")
    public Response<JobResponse> updateJob(@PathVariable String id , @RequestBody JobRequest request){
        return  respond(JobMapper.toResponse(service.update(id , JobMapper.toDto(request))));
    }


    @DeleteMapping("/{id}")
    public Response<Void> deleteJob(@PathVariable String id){
        service.delete(id);
        return  new Response<>(MetaResponse.success());
    }
}
