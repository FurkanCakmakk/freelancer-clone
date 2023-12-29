package com.kurtlar.konseyi.freelancerclone.domain.controller.mapper;

import com.kurtlar.konseyi.freelancerclone.domain.dto.LoginDto;
import com.kurtlar.konseyi.freelancerclone.domain.request.LoginRequest;

public class AuthMapper {

    public static LoginDto toDto(LoginRequest request ) {
        return LoginDto.builder()
                .usernameOrEmail(request.getUsernameOrEmail())
                .password(request.getPassword())
                .build();
    }

}
