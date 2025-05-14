package com.koey.anonnity_api_spring_boot.dtos;

import java.util.Optional;

public record LoginPwDTO(
        String value
) {
    public LoginPwDTO {
        final var regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[`~!@#$%^&*()\\-_+={}\\[\\];:\"'<>,.?/|]).{12,20}$";
        if (!value.matches(regex)) {
            throw new IllegalArgumentException("로그인 비밀번호가 유효하지 않습니다.");
        }
    }

    public static Optional<LoginPwDTO> from(String rawLoginPw) {
        try {
            return Optional.of(new LoginPwDTO(rawLoginPw));
        } catch (IllegalArgumentException ex) {
            return Optional.empty();
        }
    }
}
