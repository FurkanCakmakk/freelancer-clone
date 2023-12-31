package com.kurtlar.konseyi.freelancerclone.domain.controller;

import com.kurtlar.konseyi.freelancerclone.domain.controller.mapper.TechnologyMapper;
import com.kurtlar.konseyi.freelancerclone.domain.request.TechnologyRequest;
import com.kurtlar.konseyi.freelancerclone.domain.response.TechnologyResponse;
import com.kurtlar.konseyi.freelancerclone.domain.service.TechnologyService;
import com.kurtlar.konseyi.freelancerclone.library.rest.BaseController;
import com.kurtlar.konseyi.freelancerclone.library.rest.DataResponse;
import com.kurtlar.konseyi.freelancerclone.library.rest.MetaResponse;
import com.kurtlar.konseyi.freelancerclone.library.rest.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("technologies")
@RequiredArgsConstructor
@CrossOrigin

public class TechnologyController extends BaseController {

    private final TechnologyService service;

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<TechnologyResponse> getTechnologyById(@PathVariable String id){
        return respond(TechnologyMapper.toResponse(service.getById(id)));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<DataResponse<TechnologyResponse>> getAllTechnologies(){
        return respond(service.getAll()
                .stream()
                .map(TechnologyMapper::toResponse)
                .collect(Collectors.toList()));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<TechnologyResponse> createTechnology(@Valid @RequestBody TechnologyRequest request){
        return respond(TechnologyMapper.toResponse(service.save(TechnologyMapper.toDto(request))));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public Response<TechnologyResponse> updateTechnology(@PathVariable String id , @RequestBody TechnologyRequest request){
        return  respond(TechnologyMapper.toResponse(service.update(id , TechnologyMapper.toDto(request))));
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public Response<Void> deleteTechnology(@PathVariable String id){
        service.delete(id);
        return  new Response<>(MetaResponse.success());
    }
}
