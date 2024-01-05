package com.kurtlar.konseyi.freelancerclone.domain.response;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private String id;
    private String name;
    private String username;
    private String surname;
    private String email;
    private String password;
    private String recipientAddress;
}
