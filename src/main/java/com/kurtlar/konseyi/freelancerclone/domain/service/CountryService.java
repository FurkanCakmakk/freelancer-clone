package com.kurtlar.konseyi.freelancerclone.domain.service;

import com.kurtlar.konseyi.freelancerclone.domain.dto.CountryDto;
import com.kurtlar.konseyi.freelancerclone.domain.dto.UserDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CountryService {
    CountryDto createCountry(CountryDto countryDto);
    CountryDto getById(String id);
    CountryDto update(String id, CountryDto countryDto);
    void delete(String id);
    List<CountryDto> getAll();
    Page<CountryDto> getAll(String pageNumber, String pageSize , String  sortBy , String sortDir);

}
