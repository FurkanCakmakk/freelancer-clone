package com.kurtlar.konseyi.freelancerclone.domain.service.impl;

import com.kurtlar.konseyi.freelancerclone.domain.dto.LoginDto;
import com.kurtlar.konseyi.freelancerclone.domain.dto.UserDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.Role;
import com.kurtlar.konseyi.freelancerclone.domain.entity.User;
import com.kurtlar.konseyi.freelancerclone.domain.repository.RoleRepository;
import com.kurtlar.konseyi.freelancerclone.domain.repository.UserRepository;
import com.kurtlar.konseyi.freelancerclone.domain.service.AuthService;
import com.kurtlar.konseyi.freelancerclone.library.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {


    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(),
                loginDto.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateJwtToken(authentication);
        return token;
    }

    @Override
    public String register(UserDto userDto) {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new RuntimeException("Username is already taken!");
        }

        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new RuntimeException("Email is already taken!");
        }

        User user = new User();
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER").get();
        roles.add(userRole);
        user.setRoles(roles);

        user = userRepository.save(user);

        return "User registered successfully.";
    }
}

