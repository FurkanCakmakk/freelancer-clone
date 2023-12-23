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
@Table(name = Comment.TABLE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Comment extends AbstractEntity {

    public static final String TABLE = "comments";
    private static final String COL_REVIEWER_ID = "reviewer_id";
    private static final String COL_REVIEWED_ID = "reviewed_id";
    private static final String COL_CONTENT = "content";
    private static final String COL_RATING = "rating";


    @Column(name = COL_REVIEWER_ID)
    private String reviewerId;

    @Column(name = COL_REVIEWED_ID)
    private String reviewedId;

    @Column(name = COL_CONTENT)
    private String content;

    @Column(name = COL_RATING)
    private int rating;

}
