package com.kurtlar.konseyi.freelancerclone.domain.response;

import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TechnologyResponse {
    private String id;
    private Date created;
    private Date modified;
    private String name;
}