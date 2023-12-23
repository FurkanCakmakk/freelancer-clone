package com.kurtlar.konseyi.freelancerclone.domain.request;

import com.kurtlar.konseyi.freelancerclone.library.rest.AbstractEntity;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfferRequest {
    private String userId;
    private String jobId;
    private String message;
    private Double wage;
}
