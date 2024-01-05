package com.kurtlar.konseyi.freelancerclone.domain.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
    private String name;
    private String username;
    private String surname;
    private String email;
    private String password;
    private String recipientAddress;

}
