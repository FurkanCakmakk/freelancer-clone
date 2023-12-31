package com.kurtlar.konseyi.freelancerclone.domain.controller;

import com.kurtlar.konseyi.freelancerclone.domain.controller.mapper.UniversityMapper;
import com.kurtlar.konseyi.freelancerclone.domain.request.UniversityRequest;
import com.kurtlar.konseyi.freelancerclone.domain.response.UniversityResponse;
import com.kurtlar.konseyi.freelancerclone.domain.service.UniversityService;
import com.kurtlar.konseyi.freelancerclone.library.rest.*;
import com.kurtlar.konseyi.freelancerclone.library.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("universities")
@RequiredArgsConstructor
@CrossOrigin

public class UniversityController extends BaseController {
    private final UniversityService universityService;

    @PostMapping
    @PreAuthorize("hasRole('SUPER_ADMIN' )")
    public Response<UniversityResponse> createUniversity(@RequestBody UniversityRequest request) {
        return respond(UniversityMapper.toResponse(universityService.createUniversity(UniversityMapper.toDto(request))));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<UniversityResponse> getUniversityById(@PathVariable String id) {
        return respond(UniversityMapper.toResponse(universityService.getById(id)));
    }

    @GetMapping("/get-all-with-page-and-sorting")
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<PageResponse<UniversityResponse>> getAllUniversitiesByPaginationAndSortingWithQuery(
            @RequestParam(value = "pageNumber", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) String pageNumber,
            @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) String pageSize,
            @RequestParam(value = "sortBy", defaultValue = Constants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir" , defaultValue = Constants.DEFAULT_SORT_DIRECTION , required = false) String sortDir
            ){
        return respond(universityService.getAll(pageNumber , pageSize,sortBy , sortDir).map(UniversityMapper::toResponse));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<DataResponse<UniversityResponse>> getAllUniversities(){
        return respond(universityService.getAll().stream().map(UniversityMapper::toResponse).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN' )")
    public Response<UniversityResponse> updateUniversity(@PathVariable String id, @RequestBody UniversityRequest request) {
        return respond(UniversityMapper.toResponse(universityService.update(id, UniversityMapper.toDto(request))));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN' )")
    public Response<Void> deleteUniversityById(@PathVariable String id) {
        universityService.delete(id);
        return new Response<>(MetaResponse.success());
    }


}
