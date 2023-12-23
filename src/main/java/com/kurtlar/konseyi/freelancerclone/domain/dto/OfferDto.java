package com.kurtlar.konseyi.freelancerclone.domain.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfferDto {
    private String id;
    private Date created;
    private Date modified;
    private UserDto user;
    private JobDto job;
    private String message;
    private Double wage;
}
