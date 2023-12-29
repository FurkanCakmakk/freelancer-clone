package com.kurtlar.konseyi.freelancerclone.domain.service.mapper;

import com.kurtlar.konseyi.freelancerclone.domain.dto.OfferDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.Offer;
import com.kurtlar.konseyi.freelancerclone.domain.service.JobService;
import com.kurtlar.konseyi.freelancerclone.domain.service.UserService;

public class OfferMapper {
    public OfferMapper(){}

    public static OfferDto toDto(Offer offer, UserService userService, JobService jobService){
        return OfferDto.builder()
                .id(offer.getId())
                .job(jobService.getById(offer.getJobId()))
                .user(userService.getById(offer.getUserId()))
                .message(offer.getMessage())
                .wage(offer.getWage())
                .created(offer.getCreated())
                .modified(offer.getModified())
                .build();
    }

    public static Offer toEntity(Offer offer, OfferDto offerDto){
        offer.setUserId(offerDto.getUser().getId());
        offer.setJobId(offerDto.getJob().getId());
        offer.setMessage(offerDto.getMessage());
        offer.setWage(offerDto.getWage());
        return offer;
    }
}
