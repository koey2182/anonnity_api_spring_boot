package com.koey.anonnity_api_spring_boot.services;

import com.koey.anonnity_api_spring_boot.dtos.*;
import com.koey.anonnity_api_spring_boot.entities.Member;
import com.koey.anonnity_api_spring_boot.repositories.MemberRepository;
import com.koey.anonnity_api_spring_boot.repositories.RoleCacheRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final RoleCacheRepository roleCacheRepository;

    public MemberService(MemberRepository memberRepository, RoleCacheRepository roleCacheRepository) {
        this.memberRepository = memberRepository;
        this.roleCacheRepository = roleCacheRepository;
    }

    public List<MemberDTO> getAllSimpleMembers() {
        return this.memberRepository.findAll().stream()
                .map(x -> {
                    var roles = x.getRoles().stream().map(r -> new RoleDTO(r.getId(), r.getFlag(), r.getName())).collect(Collectors.toSet());
                    return new MemberDTO(x.getId(), x.getLoginId(), x.getNickname(), x.getCreatedAt(), roles);
                })
                .toList();
    }

    public MemberDTO createMember(LoginIdDTO loginId, EncryptedLoginPwDTO encryptedLoginPw, NicknameDTO nickname) {
        var memberRole = this.roleCacheRepository.getMemberRole();
        var newMember = new Member(loginId.value(), encryptedLoginPw.value(), nickname.value(), Set.of(memberRole));
        this.memberRepository.save(newMember);
        var roles = newMember.getRoles().stream()
                .map(x -> new RoleDTO(x.getId(), x.getFlag(), x.getName()))
                .collect(Collectors.toSet());
        return new MemberDTO(newMember.getId(), newMember.getLoginId(), newMember.getNickname(), newMember.getCreatedAt(), roles);
    }
}
