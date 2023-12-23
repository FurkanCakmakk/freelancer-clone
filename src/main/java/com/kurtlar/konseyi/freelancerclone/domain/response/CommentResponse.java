package com.kurtlar.konseyi.freelancerclone.domain.response;

import com.kurtlar.konseyi.freelancerclone.domain.dto.UserDto;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponse {
    private String id;
    private UserDto reviewer;
    private UserDto reviewed;
    private String content;
    private int rating;
}
