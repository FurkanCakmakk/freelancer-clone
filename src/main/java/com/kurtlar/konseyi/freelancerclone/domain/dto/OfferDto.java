package com.kurtlar.konseyi.freelancerclone.domain.dto;

import com.kurtlar.konseyi.freelancerclone.library.enums.JobStatus;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfferDto {
    private String id;
    private Date created;
    private Date modified;
    private String userId;
    private String jobId;
    private String message;
    private Double wage;
    private JobStatus status;
}
