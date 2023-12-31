package com.kurtlar.konseyi.freelancerclone.domain.controller;

import com.kurtlar.konseyi.freelancerclone.domain.controller.mapper.OfferMapper;
import com.kurtlar.konseyi.freelancerclone.domain.request.OfferRequest;
import com.kurtlar.konseyi.freelancerclone.domain.response.OfferResponse;
import com.kurtlar.konseyi.freelancerclone.domain.service.OfferService;
import com.kurtlar.konseyi.freelancerclone.library.rest.BaseController;
import com.kurtlar.konseyi.freelancerclone.library.rest.DataResponse;
import com.kurtlar.konseyi.freelancerclone.library.rest.MetaResponse;
import com.kurtlar.konseyi.freelancerclone.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("offers")
@RequiredArgsConstructor
@CrossOrigin

public class OfferController extends BaseController {
    private final OfferService service;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<OfferResponse> createOffer(@RequestBody OfferRequest request) {
        return respond(OfferMapper.toResponse(service.save(OfferMapper.toDto(request))));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<OfferResponse> getOfferById(@PathVariable String id) {
        return respond(OfferMapper.toResponse(service.getById(id)));
    }

    @GetMapping("/job/{jobId}")
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<DataResponse<OfferResponse>> getAllOffersByJob(@PathVariable String jobId) {
        return respond(service.getAllOffersByJob(jobId).stream().map(OfferMapper::toResponse).collect(Collectors.toList()));
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<DataResponse<OfferResponse>> getAllOffersByUser(@PathVariable String userId) {
        return respond(service.getAllOffersByUser(userId).stream().map(OfferMapper::toResponse).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<OfferResponse> updateOffer(@PathVariable String id, @RequestBody OfferRequest request) {
        return respond(OfferMapper.toResponse(service.update(id, OfferMapper.toDto(request))));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<Void> deleteOfferById(@PathVariable String id) {
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }


}
