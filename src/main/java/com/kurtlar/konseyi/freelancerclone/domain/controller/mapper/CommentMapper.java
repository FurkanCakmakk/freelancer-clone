package com.kurtlar.konseyi.freelancerclone.domain.controller.mapper;

import com.kurtlar.konseyi.freelancerclone.domain.dto.CommentDto;
import com.kurtlar.konseyi.freelancerclone.domain.dto.CountryDto;
import com.kurtlar.konseyi.freelancerclone.domain.dto.UserDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.Comment;
import com.kurtlar.konseyi.freelancerclone.domain.request.CommentRequest;
import com.kurtlar.konseyi.freelancerclone.domain.request.CountryRequest;
import com.kurtlar.konseyi.freelancerclone.domain.response.CommentResponse;
import com.kurtlar.konseyi.freelancerclone.domain.response.CountryResponse;

public class CommentMapper {
    public static CommentDto toDto(CommentRequest request){
        return CommentDto.builder()
                .reviewer(UserDto.builder().id(request.getReviewerId()).build())
                .reviewed(UserDto.builder().id(request.getReviewedId()).build())
                .content(request.getContent())
                .rating(request.getRating())
                .build();
    }

    public static CommentResponse toResponse(CommentDto dto){
        return CommentResponse.builder()
                .created(dto.getCreated())
                .modified(dto.getModified())
                .id(dto.getId())
                .reviewer(dto.getReviewer())
                .reviewed(dto.getReviewed())
                .content(dto.getContent())
                .rating(dto.getRating())
                .build();
    }
}
