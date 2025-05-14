package com.koey.anonnity_api_spring_boot.dtos;

import java.util.Objects;
import java.util.Optional;

public record NicknameDTO(
        String value
) {
    public NicknameDTO {
        final var regex = "^[0-9a-zA-Z가-힣]{2,10}$";
        if (!value.matches(regex)) {
            throw new IllegalArgumentException("닉네임이 유효하지 않습니다. 닉네임은 숫자, 영문대소문자, 한글로 이루어져야 하며 2자 이상 10자 이하여야 합니다.");
        }
    }

    public static Optional<NicknameDTO> from(String rawNickname) {
        try {
            return Optional.of(new NicknameDTO(rawNickname));
        } catch (IllegalArgumentException ex) {
            return Optional.empty();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NicknameDTO(String value1))) return false;
        return Objects.equals(value, value1);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
