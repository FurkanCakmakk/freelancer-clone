package com.kurtlar.konseyi.freelancerclone.domain.service.impl;

import com.kurtlar.konseyi.freelancerclone.domain.dto.OfferDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.Offer;
import com.kurtlar.konseyi.freelancerclone.domain.repository.OfferRepository;
import com.kurtlar.konseyi.freelancerclone.domain.service.OfferService;
import com.kurtlar.konseyi.freelancerclone.domain.service.mapper.OfferMapper;
import com.kurtlar.konseyi.freelancerclone.library.exception.EntityAlreadyExistsException;
import com.kurtlar.konseyi.freelancerclone.library.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {

    private final OfferRepository repository;

    @Override
    public OfferDto save(OfferDto offer) {
        var isExist = repository.findByUserIdAndJobId(offer.getUserId(),offer.getJobId());
        if (isExist != null){
            throw new EntityAlreadyExistsException(Offer.class.getSimpleName(), "id", isExist.getId());
        }
        Offer newOffer = repository.save(OfferMapper.toEntity(new Offer(), offer));
        return OfferMapper.toDto(newOffer);
    }

    @Override
    public OfferDto getById(String offerId) {
        return repository.findById(offerId).map(offer -> OfferMapper.toDto(offer)).orElseThrow(
                () -> new ResourceNotFoundException(Offer.class.getSimpleName(), "id", offerId)
        );
    }

    @Override
    public OfferDto update(String offerId, OfferDto offer) {
        Offer oldOffer = repository.findById(offerId).orElseThrow(
                () -> new ResourceNotFoundException(Offer.class.getSimpleName(), "id", offerId)
        );
        return OfferMapper.toDto(repository.save(setOffer(oldOffer, offer)));
    }

    @Override
    public void delete(String offerId) {
        var offer = repository.findById(offerId).orElseThrow(
                () -> new ResourceNotFoundException(Offer.class.getSimpleName(), "id", offerId));
        repository.delete(offer);
    }

    @Override
    public Set<OfferDto> getAllOffersByJob(String jobId) {
        return repository.findAllByJobId(jobId)
                .stream()
                .map(offer -> OfferMapper.toDto(offer))
                .collect(Collectors.toSet());
    }

    @Override
    public List<OfferDto> getAllOffersByUser(String userId) {
        return repository.findAllByUserId(userId).stream()
                .map(offer -> OfferMapper.toDto(offer))
                .collect(Collectors.toList());
    }

    @Override
    public Offer findByUserIdAndJobId(String userId, String jobId) {
        return repository.findByUserIdAndJobId(userId,jobId);
    }

    public Offer setOffer(Offer offer, OfferDto offerDto) {
        offer.setWage(offerDto.getWage());
        offer.setMessage(offerDto.getMessage());
        return offer;
    }
}
