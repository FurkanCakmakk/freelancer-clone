package com.kurtlar.konseyi.freelancerclone.domain.service.impl;

import com.kurtlar.konseyi.freelancerclone.domain.dto.CountryDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.Country;
import com.kurtlar.konseyi.freelancerclone.domain.repository.CountryRepository;
import com.kurtlar.konseyi.freelancerclone.domain.service.CountryService;
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
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;

    @Override
    public CountryDto createCountry(CountryDto countryDto) {
        return CountryMapper.toDto(repository.save(CountryMapper.toEntity(new Country(), countryDto)));
    }

    @Override
    public CountryDto getById(String id) {
        return CountryMapper.toDto(repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Country.class.getSimpleName(), "id", id)
        ));
    }

    @Override
    public CountryDto update(String id, CountryDto countryDto) {
        Country country = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Country.class.getSimpleName(), "id", id)
        );
        return CountryMapper.toDto(repository.save(setCountry(country, countryDto)));
    }

    @Override
    public void delete(String id) {
        var country = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Country.class.getSimpleName(), "id", id)

        );
        repository.delete(country);
    }

    @Override
    public List<CountryDto> getAll() {
        return repository.findAll().stream().map(CountryMapper::toDto).toList();
    }

    @Override
    public Page<CountryDto> getAll(String pageNumber, String pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(Integer.parseInt(pageNumber), Integer.parseInt(pageSize), sort);

        return repository.findAll(pageable).map(CountryMapper::toDto);
    }

    private Country setCountry(Country country, CountryDto countryDto) {
        country.setName(countryDto.getName());
        return country;
    }
}
