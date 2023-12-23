package com.kurtlar.konseyi.freelancerclone.domain.request;

import com.kurtlar.konseyi.freelancerclone.domain.dto.UserDto;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentRequest {
    private String reviewerId;
    private String reviewedId;
    private String content;
    private int rating;
}
