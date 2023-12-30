package com.kurtlar.konseyi.freelancerclone.domain.entity;

import com.kurtlar.konseyi.freelancerclone.library.rest.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = Offer.TABLE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Offer extends AbstractEntity {
    public static final String TABLE = "offers";
    private static final String COL_USER_ID = "user_id";
    private static final String COL_JOB_ID = "job_id";
    private static final String COL_MESSAGE = "message";
    private static final String COL_WAGE = "wage";

    @Column(name = COL_USER_ID)
    private String userId;

    @Column(name = COL_JOB_ID)
    private String jobId;

    @Column(name = COL_MESSAGE)
    private String message;

    @Column(name = COL_WAGE)
    private Double wage;

}
