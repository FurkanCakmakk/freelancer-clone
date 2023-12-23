package com.kurtlar.konseyi.freelancerclone.domain.request;

import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobRequest {
    private String name;
    private String description;
    private String salary;
    private Date startDate;
    private Date endDate;
    private String workerId;
    private String ownerId;
    private Boolean status;
    private List<String> technologies;
}