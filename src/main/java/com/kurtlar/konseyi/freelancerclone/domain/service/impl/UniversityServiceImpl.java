package com.kurtlar.konseyi.freelancerclone.domain.service.impl;

import com.kurtlar.konseyi.freelancerclone.domain.dto.UniversityDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.University;
import com.kurtlar.konseyi.freelancerclone.domain.repository.UniversityRepository;
import com.kurtlar.konseyi.freelancerclone.domain.service.CityService;
import com.kurtlar.konseyi.freelancerclone.domain.service.CountryService;
import com.kurtlar.konseyi.freelancerclone.domain.service.UniversityService;
import com.kurtlar.konseyi.freelancerclone.domain.service.mapper.UniversityMapper;
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
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository repository;
    private final CountryService countryService;
    private final CityService cityService;

    @Override
    public UniversityDto createUniversity(UniversityDto universityDto) {
        return UniversityMapper.toDto(repository.save(UniversityMapper.toEntity(new University(), universityDto)) , cityService , countryService);
    }

    @Override
    public UniversityDto getById(String id) {
        return UniversityMapper.toDto(repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(University.class.getSimpleName(), "id", id)
        ) , cityService , countryService);
    }

    @Override
    public UniversityDto update(String id, UniversityDto universityDto) {
        University university = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(University.class.getSimpleName(), "id", id)
        );
        return UniversityMapper.toDto(repository.save(setUniversity(university, universityDto)) , cityService , countryService);
    }

    @Override
    public void delete(String id) {
        var country = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(University.class.getSimpleName(), "id", id)

        );
        repository.delete(country);
    }

    @Override
    public List<UniversityDto> getAll() {
        return repository.findAll().stream().map(university -> UniversityMapper.toDto(university , cityService , countryService)).toList();
    }

    @Override
    public Page<UniversityDto> getAll(String pageNumber, String pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(Integer.parseInt(pageNumber), Integer.parseInt(pageSize), sort);

        return repository.findAll(pageable).map(university -> UniversityMapper.toDto(university , cityService , countryService));
    }

    private University setUniversity(University university, UniversityDto universityDto) {
        university.setName(universityDto.getName());
        university.setCountryId(universityDto.getCountry().getId());
        university.setCityId(universityDto.getCity().getId());
        return university;
    }
}
