package com.kurtlar.konseyi.freelancerclone.domain.controller;

import com.kurtlar.konseyi.freelancerclone.domain.controller.mapper.CountryMapper;
import com.kurtlar.konseyi.freelancerclone.domain.controller.mapper.UserMapper;
import com.kurtlar.konseyi.freelancerclone.domain.request.CountryRequest;
import com.kurtlar.konseyi.freelancerclone.domain.request.UserRequest;
import com.kurtlar.konseyi.freelancerclone.domain.response.CountryResponse;
import com.kurtlar.konseyi.freelancerclone.domain.response.UserResponse;
import com.kurtlar.konseyi.freelancerclone.domain.service.CountryService;
import com.kurtlar.konseyi.freelancerclone.library.rest.*;
import com.kurtlar.konseyi.freelancerclone.library.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("countries")
@RequiredArgsConstructor
@CrossOrigin

public class CountryController extends BaseController {
    private final CountryService countryService;

    @PostMapping
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public Response<CountryResponse> createCountry(@RequestBody CountryRequest request) {
        return respond(CountryMapper.toResponse(countryService.createCountry(CountryMapper.toDto(request))));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<CountryResponse> getCountryById(@PathVariable String id) {
        return respond(CountryMapper.toResponse(countryService.getById(id)));
    }

    @GetMapping("/get-all-with-page-and-sorting")
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<PageResponse<CountryResponse>> getAllCountriesByPaginationAndSortingWithQuery(
            @RequestParam(value = "pageNumber", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) String pageNumber,
            @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) String pageSize,
            @RequestParam(value = "sortBy", defaultValue = Constants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir" , defaultValue = Constants.DEFAULT_SORT_DIRECTION , required = false) String sortDir
            ){
        return respond(countryService.getAll(pageNumber , pageSize,sortBy , sortDir).map(CountryMapper::toResponse));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<DataResponse<CountryResponse>> getAllCountries(){
        return respond(countryService.getAll().stream().map(CountryMapper::toResponse).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public Response<CountryResponse> updateCountry(@PathVariable String id, @RequestBody CountryRequest request) {
        return respond(CountryMapper.toResponse(countryService.update(id, CountryMapper.toDto(request))));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public Response<Void> deleteCountryById(@PathVariable String id) {
        countryService.delete(id);
        return new Response<>(MetaResponse.success());
    }


}
