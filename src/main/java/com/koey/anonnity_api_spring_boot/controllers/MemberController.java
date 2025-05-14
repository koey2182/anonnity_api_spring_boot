package com.koey.anonnity_api_spring_boot.controllers;

import com.koey.anonnity_api_spring_boot.dtos.SimpleMemberDTO;
import com.koey.anonnity_api_spring_boot.services.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    @ResponseStatus(HttpStatus.OK)
    public List<SimpleMemberDTO> getAllMembers() {
        return this.memberService.getAllSimpleMembers();
    }
}
