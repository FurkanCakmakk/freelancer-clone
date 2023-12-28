package com.kurtlar.konseyi.freelancerclone.domain.repository;

import com.kurtlar.konseyi.freelancerclone.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByName(String name);
}
