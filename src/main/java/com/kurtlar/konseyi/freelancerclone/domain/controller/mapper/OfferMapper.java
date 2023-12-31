package com.kurtlar.konseyi.freelancerclone.domain.controller.mapper;

import com.kurtlar.konseyi.freelancerclone.domain.dto.OfferDto;
import com.kurtlar.konseyi.freelancerclone.domain.request.OfferRequest;
import com.kurtlar.konseyi.freelancerclone.domain.response.OfferResponse;

public class OfferMapper {
    public OfferMapper(){}

    public static OfferDto toDto(OfferRequest request){
        return OfferDto.builder()
                .jobId(request.getJobId())
                .userId(request.getUserId())
                .message(request.getMessage())
                .wage(request.getWage())
                .status(request.getStatus())
                .build();
    }

    public static OfferResponse toResponse(OfferDto offer){
        return OfferResponse.builder()
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
}
