package com.kurtlar.konseyi.freelancerclone.domain.dto;

import lombok.*;

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
}
