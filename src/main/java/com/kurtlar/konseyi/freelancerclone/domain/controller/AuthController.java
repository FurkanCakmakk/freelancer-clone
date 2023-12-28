package com.kurtlar.konseyi.freelancerclone.domain.controller;

import com.kurtlar.konseyi.freelancerclone.domain.controller.mapper.UserMapper;
import com.kurtlar.konseyi.freelancerclone.domain.dto.LoginDto;
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
    public Response<AuthResponse> login(@RequestBody LoginDto loginDto) {
        System.out.println("Logine GİRDİ");
        String token = authService.login(loginDto);
        System.out.println("token = " + token);
        AuthResponse jwtAuthResponse = new AuthResponse();
        System.out.println("jwtAuthResponse = " + jwtAuthResponse);
        jwtAuthResponse.setAccessToken(token);
        System.out.println("setAcces token yapıldı");

        return respond(jwtAuthResponse);
    }

    @PostMapping(value = {"/register" , "/signup"})
    public Response<String> register(@RequestBody UserRequest registerRequest) {
        return respond(authService.register(UserMapper.toDto(registerRequest)));
    }

}
