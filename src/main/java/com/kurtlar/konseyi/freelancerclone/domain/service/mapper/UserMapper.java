package com.kurtlar.konseyi.freelancerclone.domain.service.mapper;

import com.kurtlar.konseyi.freelancerclone.domain.dto.UserDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.User;

public class UserMapper {
    public static UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .surname(user.getSurname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public static User toEntity(User user, UserDto dto) {
        user.setName(dto.getName());
        user.setUsername(dto.getUsername());
        user.setSurname(dto.getSurname());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }

}
