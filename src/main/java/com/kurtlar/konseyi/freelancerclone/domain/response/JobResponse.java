package com.kurtlar.konseyi.freelancerclone.domain.response;

import com.kurtlar.konseyi.freelancerclone.domain.dto.OfferDto;
import com.kurtlar.konseyi.freelancerclone.domain.dto.TechnologyDto;
import com.kurtlar.konseyi.freelancerclone.library.enums.JobStatus;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobResponse {
    private String id;
    private Date created;
    private Date modified;
    private String name;
    private String description;
    private double salary;
    private Date startDate;
    private Date endDate;
    private String workerId;
    private String ownerId;
    private JobStatus status;
    private List<TechnologyDto> technologies;
    private List<OfferDto> offers;
}
