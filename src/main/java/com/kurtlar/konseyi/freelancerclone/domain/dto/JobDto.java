package com.kurtlar.konseyi.freelancerclone.domain.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobDto {
    private String id;
    private Date created;
    private Date modified;
    private String name;
    private String description;
    private String salary;
    private Date startDate;
    private Date endDate;
    private String workerId;
    private String ownerId;
    private Boolean status;
    private List<TechnologyDto> technologies;
    private List<String> offers;
}
