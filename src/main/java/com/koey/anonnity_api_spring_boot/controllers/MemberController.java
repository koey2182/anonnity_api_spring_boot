package com.koey.anonnity_api_spring_boot.controllers;

import com.koey.anonnity_api_spring_boot.dtos.*;
import com.koey.anonnity_api_spring_boot.exceptions.ErrorCode;
import com.koey.anonnity_api_spring_boot.services.MemberService;
import com.koey.anonnity_api_spring_boot.services.PasswordEncryptService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    private final MemberService memberService;
    private final PasswordEncryptService passwordEncryptService;

    public MemberController(MemberService memberService, PasswordEncryptService passwordEncryptService) {
        this.memberService = memberService;
        this.passwordEncryptService = passwordEncryptService;
    }

    @GetMapping("/members")
    @ResponseStatus(HttpStatus.OK)
    public List<MemberDTO> getAllMembers() {
        return this.memberService.getAllSimpleMembers();
    }

    @PostMapping("/members")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberDTO createMember(@RequestParam("loginId") String rawLoginId, @RequestParam("loginPw") String rawLoginPw, @RequestParam("nickname") String rawNickname) {
        var loginId = LoginIdDTO.from(rawLoginId).orElseThrow(() -> ErrorCode.INVALID_LOGIN_ID.toApiException("로그인 아이디가 유효하지 않습니다."));
        var loginPw = LoginPwDTO.from(rawLoginPw).orElseThrow(() -> ErrorCode.INVALID_LOGIN_PW.toApiException("로그인 비밀번호가 유효하지 않습니다."));
        var encryptedLoginPw = this.passwordEncryptService.encryptPassword(loginPw);
        var nickname = NicknameDTO.from(rawNickname).orElseThrow(() -> ErrorCode.INVALID_NICKNAME.toApiException("닉네임이 유효하지 않습니다."));
        return this.memberService.createMember(loginId, encryptedLoginPw, nickname);
    }
}
