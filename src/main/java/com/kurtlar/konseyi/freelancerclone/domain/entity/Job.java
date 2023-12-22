package com.kurtlar.konseyi.freelancerclone.domain.entity;

import com.kurtlar.konseyi.freelancerclone.library.rest.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = Job.TABLE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Job extends AbstractEntity {
    public static final String TABLE = "job";
    private static final String COL_NAME = "name";
    private static final String COL_DESCRIPTION = "description";
    private static final String COL_SALARY = "salary";
    private static final String COL_START_DATE = "start_date";
    private static final String COL_END_DATE = "end_date";
    private static final String COL_WORKER_ID = "worker_id";
    private static final String COL_OWNER_ID = "owner_id";
    private static final String COL_STATUS = "status";
    private static final String COL_TECHNOLOGIES = "technologies";
    private static final String COL_OFFERS = "offers";

    @Column(name = COL_NAME)
    private String name;

    @Column(name = COL_DESCRIPTION)
    private String description;

    @Column(name = COL_SALARY)
    private String salary;

    @Column(name = COL_START_DATE)
    private Date startDate;

    @Column(name = COL_END_DATE)
    private Date endDate;

    @Column(name = COL_WORKER_ID)
    private String workerId;

    @Column(name = COL_OWNER_ID)
    private String ownerId;

    @Column(name = COL_STATUS)
    private Boolean status;

    @Column(name = COL_TECHNOLOGIES)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> technologies;

    @Column(name = COL_OFFERS)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> offers;
}
