package com.kurtlar.konseyi.freelancerclone.domain.response;

import com.kurtlar.konseyi.freelancerclone.domain.dto.UserDto;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponse {
    private String id;
    private Date created;
    private Date modified;
    private UserDto reviewer;
    private UserDto reviewed;
    private String content;
    private int rating;
}
