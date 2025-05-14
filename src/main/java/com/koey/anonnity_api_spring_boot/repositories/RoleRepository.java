package com.koey.anonnity_api_spring_boot.repositories;

import com.koey.anonnity_api_spring_boot.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
