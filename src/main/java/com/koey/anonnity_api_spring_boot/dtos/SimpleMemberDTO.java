package com.koey.anonnity_api_spring_boot.dtos;

import java.time.OffsetDateTime;

public record SimpleMemberDTO(
        Long id,
        String loginId,
        String nickname,
        OffsetDateTime createdAt
) {
}
