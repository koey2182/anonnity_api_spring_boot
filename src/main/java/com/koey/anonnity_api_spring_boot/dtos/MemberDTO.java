package com.koey.anonnity_api_spring_boot.dtos;

import java.time.OffsetDateTime;
import java.util.Set;

public record MemberDTO(
        Long id,
        String loginId,
        String nickname,
        OffsetDateTime createdAt,
        Set<RoleDTO> roles
) {
}
