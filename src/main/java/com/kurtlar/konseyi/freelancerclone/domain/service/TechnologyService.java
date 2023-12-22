package com.kurtlar.konseyi.freelancerclone.domain.service;

import com.kurtlar.konseyi.freelancerclone.domain.dto.TechnologyDto;

import java.util.List;

public interface TechnologyService {
    TechnologyDto save(TechnologyDto technologyDto);
    TechnologyDto getById(String technologyId);
    TechnologyDto update(String technologyId, TechnologyDto technologyDto);
    void delete(String jobId);
    List<TechnologyDto> getAll();
}
