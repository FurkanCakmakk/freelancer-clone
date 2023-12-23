package com.kurtlar.konseyi.freelancerclone.domain.service.impl;

import com.kurtlar.konseyi.freelancerclone.domain.dto.OfferDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.Offer;
import com.kurtlar.konseyi.freelancerclone.domain.repository.OfferRepository;
import com.kurtlar.konseyi.freelancerclone.domain.service.JobService;
import com.kurtlar.konseyi.freelancerclone.domain.service.OfferService;
import com.kurtlar.konseyi.freelancerclone.domain.service.UserService;
import com.kurtlar.konseyi.freelancerclone.domain.service.mapper.OfferMapper;
import com.kurtlar.konseyi.freelancerclone.library.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {

    private final OfferRepository repository;
    private final JobService jobService;
    private final UserService userService;

    @Override
    public OfferDto save(OfferDto offer) {
        Offer newOffer = repository.save(OfferMapper.toEntity(new Offer(), offer));
        return OfferMapper.toDto(newOffer,userService,jobService);
    }

    @Override
    public OfferDto getById(String offerId) {
        return repository.findById(offerId).map(offer ->  OfferMapper.toDto(offer,userService,jobService)).orElseThrow(
                () -> new ResourceNotFoundException(Offer.class.getSimpleName(), "id", offerId)
        );
    }

    @Override
    public OfferDto update(String offerId, OfferDto offer) {
        Offer oldOffer = repository.findById(offerId).orElseThrow(
                () -> new ResourceNotFoundException(Offer.class.getSimpleName(), "id", offerId)
        );
        return OfferMapper.toDto(repository.save(setOffer(oldOffer,offer)),userService,jobService);
    }

    @Override
    public void delete(String offerId) {
        var offer = repository.findById(offerId).orElseThrow(
                () -> new ResourceNotFoundException(Offer.class.getSimpleName(), "id", offerId));
        repository.delete(offer);
    }

    @Override
    public List<OfferDto> getAllOffersByJob(String jobId) {
        return repository.findAll()
                .stream()
                .map(offer -> OfferMapper.toDto(offer,userService,jobService))
                .collect(Collectors.toList());
    }

    @Override
    public List<OfferDto> getAllOffersByUser(String userId) {
        return null;
    }

    public Offer setOffer(Offer offer, OfferDto offerDto){
        offer.setWage(offerDto.getWage());
        offer.setMessage(offerDto.getMessage());
        return offer;
    }
}