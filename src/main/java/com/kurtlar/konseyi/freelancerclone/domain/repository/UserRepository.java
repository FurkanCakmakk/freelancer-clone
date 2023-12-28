package com.kurtlar.konseyi.freelancerclone.domain.repository;

import com.kurtlar.konseyi.freelancerclone.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User , String > {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameOrEmail(String username , String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
