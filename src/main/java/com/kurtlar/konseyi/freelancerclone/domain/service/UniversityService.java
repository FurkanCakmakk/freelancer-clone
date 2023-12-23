package com.kurtlar.konseyi.freelancerclone.domain.service;

import com.kurtlar.konseyi.freelancerclone.domain.dto.CountryDto;
import com.kurtlar.konseyi.freelancerclone.domain.dto.UniversityDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UniversityService {
    UniversityDto createUniversity(UniversityDto universityDto);
    UniversityDto getById(String id);
    UniversityDto update(String id, UniversityDto universityDto);
    void delete(String id);
    List<UniversityDto> getAll();
    Page<UniversityDto> getAll(String pageNumber, String pageSize , String  sortBy , String sortDir);

}
