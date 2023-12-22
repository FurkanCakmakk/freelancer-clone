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
    public Response<CityResponse> createCity(@RequestBody CityRequest request) {
        return respond(CityMapper.toResponse(cityService.createCity(CityMapper.toDto(request))));
    }

    @GetMapping("/{id}")
    public Response<CityResponse> getCityById(@PathVariable String id) {
        return respond(CityMapper.toResponse(cityService.getById(id)));
    }

    @GetMapping("/get-all-with-page-and-sorting")
    public Response<PageResponse<CityResponse>> getAllCitiesByPaginationAndSortingWithQuery(
            @RequestParam(value = "pageNumber", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) String pageNumber,
            @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) String pageSize,
            @RequestParam(value = "sortBy", defaultValue = Constants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir" , defaultValue = Constants.DEFAULT_SORT_DIRECTION , required = false) String sortDir
            ){
        return respond(cityService.getAll(pageNumber , pageSize,sortBy , sortDir).map(CityMapper::toResponse));
    }

    @GetMapping
    public Response<DataResponse<CityResponse>> getAllCities(){
        return respond(cityService.getAll().stream().map(CityMapper::toResponse).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public Response<CityResponse> updateCity(@PathVariable String id, @RequestBody CityRequest request) {
        return respond(CityMapper.toResponse(cityService.update(id, CityMapper.toDto(request))));
    }

    @DeleteMapping("/{id}")
    public Response<Void> deleteCityById(@PathVariable String id) {
        cityService.delete(id);
        return new Response<>(MetaResponse.success());
    }


}
