package com.kurtlar.konseyi.freelancerclone.domain.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {
    private String id;
    private UserDto reviewer;
    private UserDto reviewed;
    private String content;
    private int rating;
    private Date created;
    private Date modified;
}
