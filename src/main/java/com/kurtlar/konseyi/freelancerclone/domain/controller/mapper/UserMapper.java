package com.kurtlar.konseyi.freelancerclone.domain.controller.mapper;

import com.kurtlar.konseyi.freelancerclone.domain.dto.UserDto;
import com.kurtlar.konseyi.freelancerclone.domain.request.UserRequest;
import com.kurtlar.konseyi.freelancerclone.domain.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserMapper {

    public static UserDto toDto(UserRequest request){
        return UserDto.builder()
                .name(request.getName())
                .username(request.getUsername())
                .surname(request.getSurname())
                .email(request.getEmail())
                .password(request.getPassword())
                .recipientAddress(request.getRecipientAddress())
                .build();
    }

    public static UserResponse toResponse(UserDto dto){
        return UserResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .username(dto.getUsername())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .recipientAddress(dto.getRecipientAddress())
                .build();
    }


}
