package com.koey.anonnity_api_spring_boot.services;

import com.koey.anonnity_api_spring_boot.dtos.EncryptedLoginPwDTO;
import com.koey.anonnity_api_spring_boot.dtos.LoginPwDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncryptService {
    private final PasswordEncoder passwordEncoder;

    public PasswordEncryptService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public EncryptedLoginPwDTO encryptPassword(LoginPwDTO loginPw) {
        return new EncryptedLoginPwDTO(this.passwordEncoder.encode(loginPw.value()));
    }
}
