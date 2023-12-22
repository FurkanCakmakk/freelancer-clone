package com.kurtlar.konseyi.freelancerclone.domain.entity;

import com.kurtlar.konseyi.freelancerclone.library.rest.AbstractEntity;
import com.kurtlar.konseyi.freelancerclone.library.rest.PageResponse;
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
@Table(name = University.TABLE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class University extends AbstractEntity {

    public static final String TABLE = "universities";
    private static final String COL_NAME = "name";
    private static final String COL_COUNTRY_ID = "country_id";
    private static final String COL_CITY_ID = "city_id";

    @Column(name = COL_NAME)
    private String name;

    @Column(name = COL_COUNTRY_ID)
    private String countryId;

    @Column(name = COL_CITY_ID)
    private String cityId;

}
