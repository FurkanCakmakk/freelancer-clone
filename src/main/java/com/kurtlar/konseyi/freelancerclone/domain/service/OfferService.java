package com.kurtlar.konseyi.freelancerclone.domain.service;

import com.kurtlar.konseyi.freelancerclone.domain.dto.OfferDto;

import java.util.List;

public interface OfferService {
    OfferDto save(OfferDto offer);
    OfferDto getById(String offerId);
    OfferDto update(String offerId, OfferDto offer);
    void delete(String offerId);
    List<OfferDto> getAllOffersByJob(String jobId);
    List<OfferDto> getAllOffersByUser(String userId);
}
