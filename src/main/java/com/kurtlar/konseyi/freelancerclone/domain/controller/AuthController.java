package com.kurtlar.konseyi.freelancerclone.domain.controller;

import com.kurtlar.konseyi.freelancerclone.domain.controller.mapper.AuthMapper;
import com.kurtlar.konseyi.freelancerclone.domain.controller.mapper.UserMapper;
import com.kurtlar.konseyi.freelancerclone.domain.dto.LoginDto;
import com.kurtlar.konseyi.freelancerclone.domain.request.LoginRequest;
import com.kurtlar.konseyi.freelancerclone.domain.request.UserRequest;
import com.kurtlar.konseyi.freelancerclone.domain.response.AuthResponse;
import com.kurtlar.konseyi.freelancerclone.domain.service.AuthService;
import com.kurtlar.konseyi.freelancerclone.library.rest.BaseController;
import com.kurtlar.konseyi.freelancerclone.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController extends BaseController {
    private final AuthService authService;

    @PostMapping(value = {"/login" , "/signin"})
    public Response<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        String token = authService.login(AuthMapper.toDto(loginRequest));
        AuthResponse jwtAuthResponse = new AuthResponse();
        jwtAuthResponse.setAccessToken(token);
        return respond(jwtAuthResponse);
    }

    @PostMapping(value = {"/register" , "/signup"})
    public Response<String> register(@RequestBody UserRequest registerRequest) {
        return respond(authService.register(UserMapper.toDto(registerRequest)));
    }

}
