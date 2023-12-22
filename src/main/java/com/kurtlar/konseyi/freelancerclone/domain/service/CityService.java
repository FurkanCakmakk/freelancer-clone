package com.kurtlar.konseyi.freelancerclone.domain.service;

import com.kurtlar.konseyi.freelancerclone.domain.dto.CityDto;
import com.kurtlar.konseyi.freelancerclone.domain.dto.CountryDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CityService {
    CityDto createCountry(CityDto cityDto);
    CityDto getById(String id);
    CityDto update(String id, CityDto cityDto);
    void delete(String id);
    List<CityDto> getAll();
    Page<CityDto> getAll(String pageNumber, String pageSize , String  sortBy , String sortDir);

}
