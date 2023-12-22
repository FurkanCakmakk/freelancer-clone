package com.kurtlar.konseyi.freelancerclone.domain.controller;

import com.kurtlar.konseyi.freelancerclone.domain.controller.mapper.CityMapper;
import com.kurtlar.konseyi.freelancerclone.domain.request.CityRequest;
import com.kurtlar.konseyi.freelancerclone.domain.response.CityResponse;
import com.kurtlar.konseyi.freelancerclone.domain.service.CityService;
import com.kurtlar.konseyi.freelancerclone.library.rest.*;
import com.kurtlar.konseyi.freelancerclone.library.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("cities")
@RequiredArgsConstructor
public class CityController extends BaseController {
    private final CityService cityService;

    @PostMapping
    public Response<CityResponse> createCountry(@RequestBody CityRequest request) {
        return respond(CityMapper.toResponse(cityService.createCountry(CityMapper.toDto(request))));
    }

    @GetMapping("/{id}")
    public Response<CityResponse> getCountryById(@PathVariable String id) {
        return respond(CityMapper.toResponse(cityService.getById(id)));
    }

    @GetMapping("/get-all-with-page-and-sorting")
    public Response<PageResponse<CityResponse>> getAllCountriesByPaginationAndSortingWithQuery(
            @RequestParam(value = "pageNumber", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) String pageNumber,
            @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) String pageSize,
            @RequestParam(value = "sortBy", defaultValue = Constants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir" , defaultValue = Constants.DEFAULT_SORT_DIRECTION , required = false) String sortDir
            ){
        return respond(cityService.getAll(pageNumber , pageSize,sortBy , sortDir).map(CityMapper::toResponse));
    }

    @GetMapping
    public Response<DataResponse<CityResponse>> getAllCountries(){
        return respond(cityService.getAll().stream().map(CityMapper::toResponse).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public Response<CityResponse> updateTodo(@PathVariable String id, @RequestBody CityRequest request) {
        return respond(CityMapper.toResponse(cityService.update(id, CityMapper.toDto(request))));
    }

    @DeleteMapping("/{id}")
    public Response<Void> deleteTodoById(@PathVariable String id) {
        cityService.delete(id);
        return new Response<>(MetaResponse.success());
    }


}
