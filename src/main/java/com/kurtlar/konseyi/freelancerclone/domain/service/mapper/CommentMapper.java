package com.kurtlar.konseyi.freelancerclone.domain.service.mapper;

import com.kurtlar.konseyi.freelancerclone.domain.dto.CommentDto;
import com.kurtlar.konseyi.freelancerclone.domain.dto.CountryDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.Comment;
import com.kurtlar.konseyi.freelancerclone.domain.entity.Country;
import com.kurtlar.konseyi.freelancerclone.domain.service.UserService;

public class CommentMapper {
    public static CommentDto toDto(Comment comment , UserService userService) {
        return CommentDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .rating(comment.getRating())
                .reviewed(userService.getById(comment.getReviewedId()))
                .reviewer(userService.getById(comment.getReviewerId()))
                .build();
    }

    public static Comment toEntity(Comment comment, CommentDto commentDto) {
        comment.setContent(commentDto.getContent());
        comment.setRating(commentDto.getRating());
        comment.setReviewedId(commentDto.getReviewed().getId());
        comment.setReviewerId(commentDto.getReviewer().getId());
        return comment;
    }
}
