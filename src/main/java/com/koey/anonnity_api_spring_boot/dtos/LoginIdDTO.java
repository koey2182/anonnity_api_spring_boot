package com.koey.anonnity_api_spring_boot.dtos;

import java.util.Optional;

public record LoginIdDTO(
        String value
) {
    public LoginIdDTO {
        final var regex = "^[a-zA-Z0-9_]{4,20}$";
        if (!value.matches(regex)) {
            throw new IllegalArgumentException("로그인 아이디가 유효하지 않습니다. 로그인 아이디는 영문 대소문자, 숫자, 언더바(_)를 포함하여 4자 이상 20자 이하여야 합니다.");
        }
    }

    public static Optional<LoginIdDTO> from(String rawLoginId) {
        try {
            return Optional.of(new LoginIdDTO(rawLoginId));
        } catch (IllegalArgumentException ex) {
            return Optional.empty();
        }
    }
}
