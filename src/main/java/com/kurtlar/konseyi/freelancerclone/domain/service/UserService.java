package com.kurtlar.konseyi.freelancerclone.domain.service;

import com.kurtlar.konseyi.freelancerclone.domain.dto.UserDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    UserDto getById(String id);

    UserDto save(UserDto dto);

    UserDto update(String id, UserDto dto);

    void delete(String id);

    List<UserDto> getAll();

    Page<UserDto> getAll(String pageNumber, String pageSize , String  sortBy , String sortDir);
}
