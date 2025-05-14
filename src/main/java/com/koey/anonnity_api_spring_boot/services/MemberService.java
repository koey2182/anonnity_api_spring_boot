package com.koey.anonnity_api_spring_boot.services;

import com.koey.anonnity_api_spring_boot.dtos.SimpleMemberDTO;
import com.koey.anonnity_api_spring_boot.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<SimpleMemberDTO> getAllSimpleMembers() {
        return this.memberRepository.findAll().stream()
                .map(x -> new SimpleMemberDTO(x.getId(), x.getLoginId(), x.getNickname(), x.getCreatedAt()))
                .toList();
    }
}
