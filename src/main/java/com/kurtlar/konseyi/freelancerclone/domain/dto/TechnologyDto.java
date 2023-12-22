package com.kurtlar.konseyi.freelancerclone.domain.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechnologyDto {
    private String id;
    private Date created;
    private Date modified;
    private String name;
}
