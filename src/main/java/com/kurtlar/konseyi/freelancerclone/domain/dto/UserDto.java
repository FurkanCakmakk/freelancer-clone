package com.kurtlar.konseyi.freelancerclone.domain.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String id;
    private String name;
    private String username;
    private String surname;
    private String email;
    private String password;
    private String recipientAddress;
}
