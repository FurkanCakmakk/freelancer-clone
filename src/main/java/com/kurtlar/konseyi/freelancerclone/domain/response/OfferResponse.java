package com.kurtlar.konseyi.freelancerclone.domain.response;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfferResponse {
    private String id;
    private Date created;
    private Date modified;
    private String userId;
    private String  jobId;
    private String message;
    private Double wage;
}
