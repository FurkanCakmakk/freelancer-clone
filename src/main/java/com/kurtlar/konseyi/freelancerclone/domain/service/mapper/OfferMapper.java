package com.kurtlar.konseyi.freelancerclone.domain.service.mapper;

import com.kurtlar.konseyi.freelancerclone.domain.dto.OfferDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.Offer;

public class OfferMapper {
    public OfferMapper(){}

    public static OfferDto toDto(Offer offer){
        return OfferDto.builder()
                .id(offer.getId())
                .jobId(offer.getJobId())
                .userId(offer.getUserId())
                .message(offer.getMessage())
                .wage(offer.getWage())
                .created(offer.getCreated())
                .modified(offer.getModified())
                .build();
    }

    public static Offer toEntity(Offer offer, OfferDto offerDto){
        offer.setUserId(offerDto.getUserId());
        offer.setJobId(offerDto.getJobId());
        offer.setMessage(offerDto.getMessage());
        offer.setWage(offerDto.getWage());
        return offer;
    }
}
