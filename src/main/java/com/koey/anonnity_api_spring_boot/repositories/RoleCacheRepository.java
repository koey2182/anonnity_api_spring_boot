package com.koey.anonnity_api_spring_boot.repositories;

import com.koey.anonnity_api_spring_boot.cache.Cache;
import com.koey.anonnity_api_spring_boot.entities.Role;
import com.koey.anonnity_api_spring_boot.entities.RoleType;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RoleCacheRepository {
    private final Cache<String, Role> roleCache;
    private final RoleRepository roleRepository;

    public RoleCacheRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
        this.roleCache = new Cache<>();
    }

    @PostConstruct
    public void initRoleCache() {
        var roles = this.roleRepository.findAll().stream()
                .collect(Collectors.toMap(Role::getName, x -> x));
        this.roleCache.putAll(roles);
    }

    public Role getMemberRole() {
        var roleMemberName = RoleType.Member.getName();
        return this.roleCache.get(roleMemberName)
                .orElseGet(() -> {
                    var role = this.roleRepository.findByName(roleMemberName)
                            .orElseThrow(() -> new RuntimeException("roles 테이블에 존재 하지 않는 name으로 조회를 시도했습니다."));
                    this.roleCache.put(role.getName(), role);
                    return role;
                });
    }
}