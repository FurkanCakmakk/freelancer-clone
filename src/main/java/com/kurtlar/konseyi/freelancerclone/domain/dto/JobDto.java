package com.kurtlar.konseyi.freelancerclone.domain.dto;

import com.kurtlar.konseyi.freelancerclone.library.enums.JobStatus;
import com.kurtlar.konseyi.freelancerclone.library.rest.AbstractEntity;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobDto {
    private String id;
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
    private Date created;
    private Date modified;
}
