package com.kurtlar.konseyi.freelancerclone.domain.service;

import com.kurtlar.konseyi.freelancerclone.domain.dto.LoginDto;
import com.kurtlar.konseyi.freelancerclone.domain.dto.UserDto;
import com.kurtlar.konseyi.freelancerclone.domain.response.AuthResponse;

public interface AuthService {
    AuthResponse login(LoginDto loginDto);

    String register(UserDto userDto);
}
