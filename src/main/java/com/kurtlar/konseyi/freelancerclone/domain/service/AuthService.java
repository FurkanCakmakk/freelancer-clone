package com.kurtlar.konseyi.freelancerclone.domain.service;

import com.kurtlar.konseyi.freelancerclone.domain.dto.LoginDto;
import com.kurtlar.konseyi.freelancerclone.domain.dto.UserDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(UserDto userDto);
}
