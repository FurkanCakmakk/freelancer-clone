package com.kurtlar.konseyi.freelancerclone.domain.service.impl;

import com.kurtlar.konseyi.freelancerclone.domain.dto.CityDto;
import com.kurtlar.konseyi.freelancerclone.domain.dto.CountryDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.City;
import com.kurtlar.konseyi.freelancerclone.domain.entity.Country;
import com.kurtlar.konseyi.freelancerclone.domain.repository.CityRepository;
import com.kurtlar.konseyi.freelancerclone.domain.service.CityService;
import com.kurtlar.konseyi.freelancerclone.domain.service.CountryService;
import com.kurtlar.konseyi.freelancerclone.domain.service.mapper.CityMapper;
import com.kurtlar.konseyi.freelancerclone.domain.service.mapper.CountryMapper;
import com.kurtlar.konseyi.freelancerclone.library.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository repository;
    private final CountryService countryService;

    @Override
    public CityDto createCity(CityDto cityDto) {
        return CityMapper.toDto(repository.save(CityMapper.toEntity(new City(), cityDto)) , countryService);
    }

    @Override
    public CityDto getById(String id) {
        return CityMapper.toDto(repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(City.class.getSimpleName(), "id", id)
        ) , countryService);
    }

    @Override
    public CityDto update(String id, CityDto cityDto) {
        City city = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(City.class.getSimpleName(), "id", id)
        );
        return CityMapper.toDto(repository.save(setCity(city, cityDto)) , countryService);
    }

    @Override
    public void delete(String id) {
        var city = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(City.class.getSimpleName(), "id", id)

        );
        repository.delete(city);
    }

    @Override
    public List<CityDto> getAll() {
        return repository.findAll().stream().map(city -> CityMapper.toDto(city, countryService)).toList();
    }

    @Override
    public Page<CityDto> getAll(String pageNumber, String pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(Integer.parseInt(pageNumber), Integer.parseInt(pageSize), sort);

        return repository.findAll(pageable).map(city -> CityMapper.toDto(city, countryService));
    }

    private City setCity(City city, CityDto cityDto) {
        city.setName(cityDto.getName());
        city.setCountryId(cityDto.getCountry().getId());
        return city;
    }
}
