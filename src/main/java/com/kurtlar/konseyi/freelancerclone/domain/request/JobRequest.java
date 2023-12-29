package com.kurtlar.konseyi.freelancerclone.domain.request;

import com.kurtlar.konseyi.freelancerclone.library.enums.JobStatus;
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
    private double salary;
    private Date startDate;
    private Date endDate;
    private String workerId;
    private String ownerId;
    private JobStatus status;
    private List<String> technologies;
}
