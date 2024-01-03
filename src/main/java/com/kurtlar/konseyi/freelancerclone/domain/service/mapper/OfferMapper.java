package com.kurtlar.konseyi.freelancerclone.domain.service.mapper;

import com.kurtlar.konseyi.freelancerclone.domain.dto.OfferDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.Offer;
import com.kurtlar.konseyi.freelancerclone.library.enums.JobStatus;

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
                .status(offer.getStatus())
                .build();
    }

    public static Offer toEntity(Offer offer, OfferDto offerDto){
        offer.setStatus(offerDto.getStatus());
        offer.setUserId(offerDto.getUserId());
        offer.setJobId(offerDto.getJobId());
        offer.setMessage(offerDto.getMessage());
        offer.setWage(offerDto.getWage());
        return offer;
    }
}
