package com.kurtlar.konseyi.freelancerclone.domain.controller.mapper;

import com.kurtlar.konseyi.freelancerclone.domain.dto.JobDto;
import com.kurtlar.konseyi.freelancerclone.domain.dto.OfferDto;
import com.kurtlar.konseyi.freelancerclone.domain.dto.UserDto;
import com.kurtlar.konseyi.freelancerclone.domain.request.OfferRequest;
import com.kurtlar.konseyi.freelancerclone.domain.response.OfferResponse;

public class OfferMapper {
    public OfferMapper(){}

    public static OfferDto toDto(OfferRequest request){
        return OfferDto.builder()
                .job(JobDto.builder().id(request.getJobId()).build())
                .user(UserDto.builder().id(request.getUserId()).build())
                .message(request.getMessage())
                .wage(request.getWage())
                .build();
    }

    public static OfferResponse toResponse(OfferDto offer){
        return OfferResponse.builder()
                .id(offer.getId())
                .created(offer.getCreated())
                .modified(offer.getModified())
                .job(offer.getJob())
                .user(offer.getUser())
                .message(offer.getMessage())
                .wage(offer.getWage())
                .build();
    }
}
