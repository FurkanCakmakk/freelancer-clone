package com.kurtlar.konseyi.freelancerclone.domain.service.impl;

import com.kurtlar.konseyi.freelancerclone.domain.dto.TechnologyDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.Technology;
import com.kurtlar.konseyi.freelancerclone.domain.entity.User;
import com.kurtlar.konseyi.freelancerclone.domain.repository.TechnologyRepository;
import com.kurtlar.konseyi.freelancerclone.domain.service.TechnologyService;
import com.kurtlar.konseyi.freelancerclone.domain.service.mapper.TechnologyMapper;
import com.kurtlar.konseyi.freelancerclone.library.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TechnologyServiceImpl implements TechnologyService {

    private final TechnologyRepository repository;

    @Override
    public TechnologyDto save(TechnologyDto technologyDto) {
        Technology technology = repository.save(TechnologyMapper.toEntity(new Technology(), technologyDto));
        return TechnologyMapper.toDto(technology);
    }

    @Override
    public TechnologyDto getById(String technologyId) {
        return repository.findById(technologyId).map(TechnologyMapper::toDto).orElseThrow(
                () -> new ResourceNotFoundException(User.class.getSimpleName(), "id", technologyId)
        );
    }

    @Override
    public TechnologyDto update(String technologyId, TechnologyDto technologyDto) {
        Technology technology = repository.findById(technologyId).orElseThrow(
                () -> new ResourceNotFoundException(Technology.class.getSimpleName(), "id", technologyId)
        );
        technology.setName(technologyDto.getName());
        return TechnologyMapper.toDto(repository.save(technology));
    }

    @Override
    public void delete(String technologyId) {
        var technology = repository.findById(technologyId).orElseThrow(
                () -> new ResourceNotFoundException(Technology.class.getSimpleName(), "id", technologyId));
        repository.delete(technology);
    }

    @Override
    public List<TechnologyDto> getAll() {
        return repository.findAll()
                .stream()
                .map(technology -> TechnologyMapper.toDto(technology))
                .collect(Collectors.toList());
    }
}
