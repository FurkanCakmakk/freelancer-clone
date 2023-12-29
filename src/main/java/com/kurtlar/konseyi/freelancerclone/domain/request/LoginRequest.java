package com.kurtlar.konseyi.freelancerclone.domain.request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequest {
    private String usernameOrEmail;
    private String password;

}
