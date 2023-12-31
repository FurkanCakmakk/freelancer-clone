package com.kurtlar.konseyi.freelancerclone.domain.service.impl;

import com.kurtlar.konseyi.freelancerclone.domain.dto.UserDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.User;
import com.kurtlar.konseyi.freelancerclone.domain.repository.UserRepository;
import com.kurtlar.konseyi.freelancerclone.domain.response.TcDogrulaResponse;
import com.kurtlar.konseyi.freelancerclone.domain.service.UserService;
import com.kurtlar.konseyi.freelancerclone.domain.service.mapper.UserMapper;
import com.kurtlar.konseyi.freelancerclone.library.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    private final RestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:3000";

    public TcDogrulaResponse validateUser(String TCKimlikNo, String Ad, String Soyad, String DogumYili) {
        String REST_URL = BASE_URL + "/" + TCKimlikNo + "/" + Ad + "/" + Soyad + "/" + DogumYili;
        System.out.println("REST_URL  : " + REST_URL);
        TcDogrulaResponse result = restTemplate.getForObject(REST_URL, TcDogrulaResponse.class);
        return result;
    }

    @Override
    public String getUserMetamaskAddress(String userId) {
        User user = repository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException(User.class.getSimpleName(), "id", userId)
        );

        return user.getRecipientAddress();
    }


    @Override
    @Transactional
    public UserDto save(UserDto dto) {
        return UserMapper.toDto(repository.save(UserMapper.toEntity(new User(), dto)));
    }

    @Override
    public UserDto getById(String id) {
        return repository.findById(id).map(UserMapper::toDto).orElseThrow(
                () -> new ResourceNotFoundException(User.class.getSimpleName(), "id", id)
        );
    }

    @Override
    public List<UserDto> getAll() {
        return repository.findAll().stream().map(user -> UserMapper.toDto(user)).collect(Collectors.toList());
    }

    @Override
    public Page<UserDto> getAll(String pageNumber, String pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(Integer.parseInt(pageNumber), Integer.parseInt(pageSize), sort);
        return repository.findAll(pageable).map(todo -> UserMapper.toDto(todo));
    }

    @Override
    @Transactional
    public UserDto update(String id, UserDto dto) {
        User user = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(User.class.getSimpleName(), "id", id)
        );

        return UserMapper.toDto(repository.save(setUser(user, dto)));
    }

    @Override
    @Transactional
    public void delete(String id) {
        var user = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(User.class.getSimpleName(), "id", id)
        );
        repository.delete(user);
    }


    private User setUser(User user, UserDto dto) {
        user.setName(dto.getName());
        user.setUsername(dto.getUsername());
        user.setSurname(dto.getSurname());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }
}
